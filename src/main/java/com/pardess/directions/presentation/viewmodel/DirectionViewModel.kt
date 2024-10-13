package com.pardess.directions.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakao.vectormap.route.RouteLineOptions
import com.orhanobut.logger.Logger
import com.pardess.directions.data.ResponseType
import com.pardess.directions.data.Result
import com.pardess.directions.domain.model.Route
import com.pardess.directions.domain.model.RouteInfo
import com.pardess.directions.domain.model.RouteLine
import com.pardess.directions.domain.usecase.distance_time.GetRouteInfoUseCase
import com.pardess.directions.domain.usecase.location.GetRouteListUseCase
import com.pardess.directions.domain.usecase.route.GetRouteLineListUseCase
import com.pardess.directions.presentation.DataState
import com.pardess.directions.presentation.util.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DirectionViewModel @Inject constructor(
    private val getRouteListUseCase: GetRouteListUseCase,
    private val getRouteLineListUseCase: GetRouteLineListUseCase,
    private val getRouteInfoUseCase: GetRouteInfoUseCase
) : ViewModel() {

    var multiStyleLine by mutableStateOf<com.kakao.vectormap.route.RouteLine?>(null)
        set

    var routeLineLayer by mutableStateOf<com.kakao.vectormap.route.RouteLineLayer?>(null)
        set

    var labelLayer by mutableStateOf<com.kakao.vectormap.label.LabelLayer?>(null)
        set

    var kakaoMap by mutableStateOf<com.kakao.vectormap.KakaoMap?>(null)
        set

    var dataState by mutableStateOf<DataState>(DataState.Ready)
        set

    var isRouteListSuccess by mutableStateOf(false)
        private set

    var isRouteInfoSuccess by mutableStateOf(false)
        private set

    var isRouteLineListSuccess by mutableStateOf(false)
        private set

    var routeListIndex by mutableIntStateOf(-1)
        set

    var isRouteListLoading by mutableStateOf(false)
        set

    var isRouteInfoLoading by mutableStateOf(false)
        set

    var isRouteLineListLoading by mutableStateOf(false)
        set

    fun routeSelected(index: Int) {
        routeListIndex = index
        val route = routeList[routeListIndex]
        updateRouteInfo(
            route.origin, route.destination,
        )
        updateRouteLineList(
            route.origin, route.destination,
        )
    }

    init {
        updateRouteList()
    }

    var straightDistance by mutableIntStateOf(0)
        set

    var route by mutableStateOf(Route("", ""))
        set

    var routeList by mutableStateOf<List<Route>>(emptyList())
        private set

    fun updateRouteList() = viewModelScope.launch {
        isRouteListLoading = true
        val data = getRouteListUseCase()
        Logger.d(data.data.toString())
        if (data is Result.Success) {
            routeList = data.data!!
            dataState = DataState.Success(
                responseType = data.responseType!!
            )
            isRouteListSuccess = true
        } else if (data is Result.Error) {
            handleError(data)
            isRouteListSuccess = false
        }
        isRouteListLoading = false
    }

    var routeInfo by mutableStateOf(RouteInfo(0, 0, 0, 0))
        private set

    fun updateRouteInfo(origin: String, destination: String) = viewModelScope.launch {
        isRouteInfoLoading = true
        val data = getRouteInfoUseCase(origin = origin, destination = destination)
        Logger.d(data.toString())
        route = Route(origin, destination)
        if (data is Result.Success) {
            routeInfo = data.data!!
            isRouteInfoSuccess = true
            dataState = DataState.Success(
                responseType = data.responseType!!
            )
        } else if (data is Result.Error) {
            isRouteInfoSuccess = false
            handleError(data)
        }
        isRouteInfoLoading = false
    }

    var routeLineList by mutableStateOf<List<RouteLine>>(emptyList())
        private set

    fun updateRouteLineList(origin: String, destination: String) = viewModelScope.launch {
        isRouteLineListLoading = true
        val data = getRouteLineListUseCase(origin = origin, destination = destination)
        Logger.d(data.toString())
        println("@@@@@@@@@ updateRouteLineList")
        if (data is Result.Success) {
            routeLineList = data.data!!
            straightDistance = Utils.haversine(
                data.data.first().wayList.first(),
                data.data.last().wayList.last()
            )
            isRouteLineListSuccess = true
            dataState = DataState.Success(
                responseType = data.responseType!!
            )
        } else if (data is Result.Error) {
            handleError(data)
            isRouteLineListSuccess = false
        }
        isRouteLineListLoading = false
    }

    private fun handleError(error: Result.Error<*>) {
        when (error.responseType) {
            ResponseType.ROUTE_LIST -> {
                // Handle ROUTE_LIST error
                routeList = emptyList()
            }

            ResponseType.ROUTE_INFO -> {
                // Handle ROUTE_INFO error
                routeLineList = emptyList()
                routeInfo = RouteInfo(0, 0, 0, 0)
                straightDistance = 0
            }

            ResponseType.ROUTE_LINE_LIST -> {
                // Handle ROUTE_LINE_LIST error
                routeLineList = emptyList()
                routeInfo = RouteInfo(0, 0, 0, 0)
                straightDistance = 0
            }

            else -> {
                //Nothing
            }
        }
        dataState = DataState.Error(
            message = error.message.toString(),
            responseType = error.responseType!!,
            httpExceptionCode = error.exceptionCode,
            exceptionType = error.exceptionType!!
        )
    }
}