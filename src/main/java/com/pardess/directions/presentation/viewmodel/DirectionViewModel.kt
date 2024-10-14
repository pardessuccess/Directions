package com.pardess.directions.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.camera.CameraUpdateFactory
import com.kakao.vectormap.route.RouteLineSegment
import com.pardess.directions.domain.model.common.DataState
import com.pardess.directions.domain.model.common.ExceptionType
import com.pardess.directions.domain.model.common.ResponseType
import com.pardess.directions.domain.model.common.Result
import com.pardess.directions.domain.model.route_info.RouteInfo
import com.pardess.directions.domain.model.route_line_list.RouteLine
import com.pardess.directions.domain.model.route_list.Route
import com.pardess.directions.domain.usecase.mapview.DrawRouteLineUseCase
import com.pardess.directions.domain.usecase.mapview.SetLabelWithTextUseCase
import com.pardess.directions.domain.usecase.route_info.GetRouteInfoUseCase
import com.pardess.directions.domain.usecase.route_line_list.GetRouteLineListUseCase
import com.pardess.directions.domain.usecase.route_list.GetRouteListUseCase
import com.pardess.directions.presentation.util.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DirectionViewModel @Inject constructor(
    private val getRouteListUseCase: GetRouteListUseCase,
    private val getRouteLineListUseCase: GetRouteLineListUseCase,
    private val getRouteInfoUseCase: GetRouteInfoUseCase,
    private val drawRouteLineUseCase: DrawRouteLineUseCase,
    private val setLabelWithTextUseCase: SetLabelWithTextUseCase,
) : ViewModel() {

    // RouteList 출발지,목적지 리스트
    var route by mutableStateOf(Route("", ""))
        private set

    var routeList by mutableStateOf<List<Route>>(emptyList())
        private set

    // RouteInfo 경로 시간, 거리 정보
    var routeInfo by mutableStateOf(RouteInfo(0, 0, 0, 0))
        private set

    // RouteLineList 경로 라인 정보
    var routeLineList by mutableStateOf<List<RouteLine>>(emptyList())
        private set

    // 직선 거리
    var straightDistance by mutableIntStateOf(0)
        private set

    // 로딩 상태
    var isRouteListLoading by mutableStateOf(false)
        private set
    var isRouteInfoLoading by mutableStateOf(false)
        private set
    var isRouteLineListLoading by mutableStateOf(false)
        private set

    // 에러 코드 및 메시지
    var errorCodeResult by mutableStateOf(Triple("", "", ""))
    var errorMessageResult by mutableStateOf(Triple("", "", ""))

    // API 호출 성공 여부
    var isRouteListSuccess by mutableStateOf(false)
    var isRouteInfoSuccess by mutableStateOf(false)
    var isRouteLineListSuccess by mutableStateOf(false)

    // DataState 네트워크 호출 데이터 상태
    var dataState by mutableStateOf<DataState>(DataState.Ready)

    // 출발지,목적지 리스트에서 선택된 index
    private var routeListIndex by mutableIntStateOf(-1)

    init {
        route = Route("", "")
        routeInfo = RouteInfo(0, 0, 0, 0)
        isRouteInfoLoading = false
        straightDistance = 0
        isRouteListLoading = false
        isRouteLineListLoading = false
        routeList = emptyList()
        routeLineList = emptyList()
        dataState = DataState.Ready
        routeListIndex = -1
        errorCodeResult = Triple("", "", "")
        errorMessageResult = Triple("", "", "")
        isRouteListSuccess = false
        isRouteInfoSuccess = false
        isRouteLineListSuccess = false
        updateRouteList()
    }

    // RouteLineSegmentList 경로 라인 리스트
    private var routeLineSegmentList by mutableStateOf(listOf<RouteLineSegment>())
        set

    // RouteLineSegmentList 변환 함수
    fun convertToRouteSegmentList(routeLineSegmentList: List<RouteLineSegment>) {
        this.routeLineSegmentList = routeLineSegmentList
    }

    //카카오맵 객체 및 RouteLine, RouteLineLayer, LabelLayer 객체
    private var kakaoMap by mutableStateOf<KakaoMap?>(null)
    var multiStyleLine by mutableStateOf<com.kakao.vectormap.route.RouteLine?>(null)
        private set
    var routeLineLayer by mutableStateOf<com.kakao.vectormap.route.RouteLineLayer?>(null)
        private set
    var labelLayer by mutableStateOf<com.kakao.vectormap.label.LabelLayer?>(null)
        private set

    // 카카오맵 초기화 함수
    fun initKakaoMap(kakaoMap: KakaoMap) {
        this.kakaoMap = kakaoMap
        labelLayer = kakaoMap.labelManager!!.layer
        routeLineLayer = kakaoMap.routeLineManager!!.layer
        kakaoMap.moveCamera(
            CameraUpdateFactory.newCenterPosition(
                LatLng.from(37.394726159, 127.111209047), 16
            )
        )
    }

    // 경로 그리는 함수
    fun drawRouteLine() {
        multiStyleLine?.let {
            routeLineLayer?.remove(it)
        }
        this.multiStyleLine = drawRouteLineUseCase(
            routeLineList = this.routeLineList,
            kakaoMap = this.kakaoMap!!,
            routeLineLayer = this.routeLineLayer,
            multiStyleLine = this.multiStyleLine
        )
    }

    // 라벨 그리는 함수
    fun setLabelWithText(
        originLabelId: String,
        originLabelText: String,
        destinationLabelId: String,
        destinationLabelText: String,
    ) {
        labelLayer?.let {
            it.remove(it.getLabel(originLabelId))
            it.remove(it.getLabel(destinationLabelId))
        }

        setLabelWithTextUseCase(
            kakaoMap = kakaoMap!!,
            labelLayer = labelLayer!!,
            labelId = originLabelId,
            labelText = originLabelText,
            routeName = route.origin,
            latLng = routeLineSegmentList.first().points.first(),
        )

        setLabelWithTextUseCase(
            kakaoMap = kakaoMap!!,
            labelLayer = labelLayer!!,
            labelId = destinationLabelId,
            labelText = destinationLabelText,
            routeName = route.destination,
            latLng = routeLineSegmentList.last().points.last(),
        )
    }

    // 출발지,목적지 리스트 선택 함수
    fun routeSelected(index: Int) {
        routeListIndex = index
        route = routeList[routeListIndex]
        updateRouteInfo(
            route.origin, route.destination,
        )
        updateRouteLineList(
            route.origin, route.destination,
        )
    }

    // RouteList 출발지,목적지 리스트 호출 함수
    fun updateRouteList() = viewModelScope.launch {
        isRouteListLoading = true
        isRouteListSuccess = false
        errorCodeResult = Triple("", errorCodeResult.second, errorCodeResult.third)
        errorMessageResult = Triple("", errorMessageResult.second, errorMessageResult.third)
        val data = getRouteListUseCase()
        if (data is Result.Success) {
            routeList = data.data
            dataState = DataState.Success(
                responseType = data.responseType
            )
            isRouteListSuccess = true
        } else if (data is Result.Error) {
            handleError(data)
        }
        isRouteListLoading = false
    }


    // RouteInfo 경로 시간, 거리 정보 호출 함수
    private fun updateRouteInfo(origin: String, destination: String) = viewModelScope.launch {
        isRouteInfoLoading = true
        isRouteInfoSuccess = false
        errorCodeResult = Triple(errorCodeResult.first, "", errorCodeResult.third)
        errorMessageResult = Triple(errorMessageResult.first, "", errorMessageResult.third)
        val data = getRouteInfoUseCase(origin = origin, destination = destination)
        route = Route(origin, destination)
        if (data is Result.Success) {
            routeInfo = data.data
            dataState = DataState.Success(
                responseType = data.responseType
            )
            isRouteInfoSuccess = true
        } else if (data is Result.Error) {
            handleError(data)
        }
        isRouteInfoLoading = false
    }


    // RouteLineList 경로 리스트 호출 함수
    private fun updateRouteLineList(origin: String, destination: String) = viewModelScope.launch {
        isRouteLineListLoading = true
        isRouteLineListSuccess = false
        errorCodeResult = Triple(errorCodeResult.first, errorCodeResult.second, "")
        errorMessageResult = Triple(errorMessageResult.first, errorMessageResult.second, "")
        val data = getRouteLineListUseCase(origin = origin, destination = destination)
        if (data is Result.Success) {
            routeLineList = data.data
            straightDistance = Utils.haversine(
                data.data.first().routeLine.first(),
                data.data.last().routeLine.last()
            )
            isRouteLineListSuccess = true
            dataState = DataState.Success(
                responseType = data.responseType
            )
        } else if (data is Result.Error) {
            handleError(data)
        }
        isRouteLineListLoading = false
    }

    // 에러 처리 함수
    private fun handleError(error: Result.Error<*>) {
        if (error.exceptionType == ExceptionType.UNKNOWN_ERROR) {
            errorCodeResult = Triple(
                "", "", ""
            )
            errorMessageResult = Triple(
                "", "", ""
            )
        }
        when (error.responseType) {
            ResponseType.ROUTE_LIST -> {
                errorCodeResult =
                    Triple(
                        errorCodeResult.first + error.httpExceptionCode,
                        errorCodeResult.second,
                        errorCodeResult.third
                    )
                errorMessageResult =
                    Triple(
                        errorMessageResult.first + error.message,
                        errorMessageResult.second,
                        errorMessageResult.third
                    )
            }

            ResponseType.ROUTE_INFO -> {
                // Route 정보 관련 에러 처리
                errorCodeResult =
                    Triple(
                        errorCodeResult.first,
                        errorCodeResult.second + error.httpExceptionCode,
                        errorCodeResult.third
                    )
                errorMessageResult =
                    Triple(
                        errorMessageResult.first,
                        errorMessageResult.second + error.message,
                        errorMessageResult.third
                    )
            }

            ResponseType.ROUTE_LINE_LIST -> {
                // Route 라인 리스트 관련 에러 처리
                errorCodeResult =
                    Triple(
                        errorCodeResult.first,
                        errorCodeResult.second,
                        errorCodeResult.third + error.httpExceptionCode
                    )
                errorMessageResult =
                    Triple(
                        errorMessageResult.first,
                        errorMessageResult.second,
                        errorMessageResult.third + error.message
                    )
            }
        }
        routeLineList = emptyList()
        routeInfo = RouteInfo(0, 0, 0, 0)
        straightDistance = 0

        dataState = DataState.Error(
            message = error.message,
            responseType = error.responseType,
            httpExceptionCode = error.httpExceptionCode,
            exceptionType = error.exceptionType
        )
    }
}