package com.pardess.directions.presentation.mapview

import android.widget.Toast
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView
import com.pardess.directions.R
import com.pardess.directions.domain.model.common.ResponseType
import com.pardess.directions.domain.model.common.DataState
import com.pardess.directions.domain.model.common.DataState.Success
import com.pardess.directions.presentation.util.Utils.convertToRouteSegmentList
import com.pardess.directions.presentation.viewmodel.DirectionViewModel


// 카카오 지도 뷰를 표시하는 컴포저블 함수
@Composable
fun KakaoMapView(
    viewModel: DirectionViewModel,
    mapView: MapView,
) {
    val context = LocalContext.current
    val dateState = viewModel.dataState

    // 경로 리스트, 경로 정보, 경로 라인 리스트가 모두 성공적으로 로드되었을 때 지도에 라벨, 라인을 그려줌
    if (dateState is Success && dateState.responseType == ResponseType.ROUTE_LINE_LIST && viewModel.isRouteLineListSuccess && viewModel.isRouteInfoSuccess) {
        viewModel.dataState = DataState.Ready
        viewModel.convertToRouteSegmentList(
            viewModel.routeLineList.convertToRouteSegmentList(context)
        )
        viewModel.drawRouteLine()
        viewModel.setLabelWithText(
            originLabelId = context.getString(R.string.origin_label_id),
            originLabelText = context.getString(R.string.origin_label_text),
            destinationLabelId = context.getString(R.string.destination_label_id),
            destinationLabelText = context.getString(R.string.destination_label_text),
        )
    }

    // 오류 발생 시 지도에 표시된 레이어 제거
    if (dateState is DataState.Error) {
        viewModel.labelLayer?.let {
            it.remove(it.getLabel(context.getString(R.string.origin_label_id)))
            it.remove(it.getLabel(context.getString(R.string.destination_label_id)))
        }
        viewModel.multiStyleLine?.let {
            viewModel.routeLineLayer?.remove(it)
        }
    }

    Surface {
        AndroidView(
            factory = { context ->
                mapView.apply {
                    this.start(
                        object : MapLifeCycleCallback() {
                            // 지도 생명 주기 콜백: 지도가 파괴될 때 호출
                            override fun onMapDestroy() {
                                Toast.makeText(context, "Destroy", Toast.LENGTH_SHORT).show()
                            }

                            // 지도 생명 주기 콜백: 지도 로딩 중 에러가 발생했을 때 호출
                            override fun onMapError(exception: Exception?) {
                                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                            }
                        },
                        object : KakaoMapReadyCallback() {
                            // 지도 생성 후 호출
                            override fun onMapReady(kakaoMap: KakaoMap) {
                                viewModel.initKakaoMap(kakaoMap)
                            }
                        },
                    )
                }
            }
        )
    }
}