package com.pardess.directions.presentation.mapview

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView
import com.kakao.vectormap.camera.CameraAnimation
import com.kakao.vectormap.camera.CameraUpdateFactory
import com.kakao.vectormap.label.LabelLayer
import com.kakao.vectormap.route.RouteLine
import com.kakao.vectormap.route.RouteLineLayer
import com.kakao.vectormap.route.RouteLineOptions
import com.orhanobut.logger.Logger
import com.pardess.directions.R
import com.pardess.directions.data.ResponseType
import com.pardess.directions.domain.usecase.mapview.SetLabelWithTextUseCase
import com.pardess.directions.presentation.DataState
import com.pardess.directions.presentation.DataState.Success
import com.pardess.directions.presentation.util.Utils.convertToLatLngPoints
import com.pardess.directions.presentation.util.Utils.convertToRouteSegmentList
import com.pardess.directions.presentation.viewmodel.DirectionViewModel

private lateinit var routeLineLayer: RouteLineLayer
private lateinit var multiStyleLine: RouteLine
private lateinit var labelLayer: LabelLayer
private lateinit var kakaoMap: KakaoMap

@Stable
@Composable
fun KakaoMapView(
    viewModel: DirectionViewModel,
    mapView: MapView,
) {
    val context = LocalContext.current

    val routeLineList = viewModel.routeLineList
    val dateState = viewModel.dataState
    val location = viewModel.route

    if (routeLineList.isNotEmpty()) {
        if (dateState is Success && dateState.responseType == ResponseType.ROUTE_LINE_LIST) {
            viewModel.dataState = DataState.Ready
            println("@@@@@@@ SUCCESS ${dateState.responseType}")
            Logger.d(routeLineList.toString())
            drawRouteLine(
                context = context,
                routeLineList = routeLineList,
                viewModel = viewModel,
                origin = location.origin,
                destination = location.destination
            )
        }
    }

    if (dateState is DataState.Error) {
        if (viewModel.labelLayer != null) {
            viewModel.labelLayer!!.remove(viewModel.labelLayer!!.getLabel(stringResource(R.string.origin_label_id)))
            viewModel.labelLayer!!.remove(viewModel.labelLayer!!.getLabel(stringResource(R.string.destination_label_id)))
        }
        if (viewModel.multiStyleLine != null) {
            viewModel.routeLineLayer!!.remove(viewModel.multiStyleLine)
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
                            override fun onMapReady(map: KakaoMap) {
                                viewModel.kakaoMap = map
                                Toast.makeText(context, "Ready", Toast.LENGTH_SHORT).show()
                                viewModel.labelLayer = viewModel.kakaoMap!!.labelManager!!.layer!!
                                viewModel.routeLineLayer =
                                    viewModel.kakaoMap!!.routeLineManager!!.layer

                                viewModel.kakaoMap!!.moveCamera(
                                    CameraUpdateFactory.newCenterPosition(
                                        LatLng.from(37.55595957732287, 126.97227318174524), 16
                                    )
                                )
                            }
                        },
                    )
                }
            }
        )
    }
}


fun drawRouteLine(
    context: Context,
    viewModel: DirectionViewModel,
    routeLineList: List<com.pardess.directions.domain.model.RouteLine>,
    origin: String,
    destination: String,
) {

    val latLngPoints = routeLineList.convertToLatLngPoints()

    val routeSegmentList = routeLineList.convertToRouteSegmentList(context)

    if (viewModel.multiStyleLine != null) {
        viewModel.routeLineLayer!!.remove(viewModel.multiStyleLine)
    }

    if (viewModel.labelLayer != null) {
        viewModel.labelLayer!!.remove(viewModel.labelLayer!!.getLabel(context.getString(R.string.origin_label_id)))
        viewModel.labelLayer!!.remove(viewModel.labelLayer!!.getLabel(context.getString(R.string.destination_label_id)))
    }

    val options = RouteLineOptions.from(
        routeSegmentList
    )

    viewModel.multiStyleLine = viewModel.routeLineLayer!!.addRouteLine(options)

    val setLabelWithTextUseCase =
        SetLabelWithTextUseCase(viewModel.kakaoMap!!, viewModel.labelLayer!!)

    setLabelWithTextUseCase.execute(
        context = context,
        labelId = context.getString(R.string.origin_label_id),
        text = context.getString(R.string.origin_label_text),
        locationName = origin,
        lat = routeSegmentList[0].lats[0],
        lng = routeSegmentList[0].lngs[0]
    )

    setLabelWithTextUseCase.execute(
        context = context,
        labelId = context.getString(R.string.destination_label_id),
        text = context.getString(R.string.destination_label_text),
        locationName = destination,
        lat = routeSegmentList.last().lats.last(),
        lng = routeSegmentList.last().lngs.last()
    )

    viewModel.kakaoMap!!.moveCamera(
        CameraUpdateFactory.fitMapPoints(latLngPoints, 250), CameraAnimation.from(1000, true, true)
    )
}

//
//private fun setLabelWithText(
//    context: Context,
//    labelId: String,
//    text: String,
//    locationName: String,
//    lat: Double,
//    lng: Double
//) {
//    val pos = LatLng.from(lat, lng)
//
//    val marker = when (text) {
//        context.getString(R.string.origin_label_text) -> {
//            Triple(
//                R.drawable.blue_marker,
//                LabelTextStyle.from(context, R.style.labelTextStyleBlack),
//                LabelTextStyle.from(context, R.style.labelTextStyleBlue)
//            )
//        }
//
//        context.getString(R.string.destination_label_text) -> {
//            Triple(
//                R.drawable.pink_marker,
//                LabelTextStyle.from(context, R.style.labelTextStyleBlack),
//                LabelTextStyle.from(context, R.style.labelTextStyleRed)
//            )
//        }
//
//        else -> {
//            Triple(
//                R.drawable.green_marker,
//                LabelTextStyle.from(context, R.style.labelTextStyleBlack),
//                LabelTextStyle.from(context, R.style.labelTextStyleBlue)
//            )
//        }
//    }
//
//    val styles = kakaoMap.labelManager
//        ?.addLabelStyles(
//            LabelStyles.from(
//                LabelStyle.from(
//                    marker.first
//                ).setTextStyles(
//                    marker.second,
//                    marker.third
//                )
//                    .setIconTransition(LabelTransition.from(Transition.None, Transition.None))
//            )
//        )
//
//    labelLayer.addLabel(
//        LabelOptions.from(labelId, pos).setStyles(styles)
//            .setTexts(
//                LabelTextBuilder().setTexts(
//                    text,
//                    locationName,
//                )
//            )
//    )
//    kakaoMap.moveCamera(
//        CameraUpdateFactory.newCenterPosition(pos, 15),
//        CameraAnimation.from(duration)
//    )
//}
//

//    val routeSegmentList = mutableListOf<RouteLineSegment>()

//    routeLineList.forEach {
//        val style = when (it.trafficState) {
//            TrafficState.UNKNOWN -> TrafficState.UNKNOWN.styleRes
//            TrafficState.JAM -> TrafficState.JAM.styleRes
//            TrafficState.DELAY -> TrafficState.DELAY.styleRes
//            TrafficState.SLOW -> TrafficState.SLOW.styleRes
//            TrafficState.NORMAL -> TrafficState.NORMAL.styleRes
//            TrafficState.BLOCK -> TrafficState.BLOCK.styleRes
//        }
//
//        val routeLineStyle = RouteLineStyle.from(context, style)
//
//        routeSegmentList.add(
//            RouteLineSegment.from(
//                it.wayList, routeLineStyle
//            )
//        )
//    }
