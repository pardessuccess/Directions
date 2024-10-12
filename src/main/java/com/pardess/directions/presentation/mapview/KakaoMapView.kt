package com.pardess.directions.presentation.mapview

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView
import com.kakao.vectormap.camera.CameraAnimation
import com.kakao.vectormap.camera.CameraUpdateFactory
import com.kakao.vectormap.label.LabelLayer
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.label.LabelStyle
import com.kakao.vectormap.label.LabelStyles
import com.kakao.vectormap.label.LabelTextBuilder
import com.kakao.vectormap.label.LabelTextStyle
import com.kakao.vectormap.label.LabelTransition
import com.kakao.vectormap.label.Transition
import com.kakao.vectormap.route.RouteLineLayer
import com.kakao.vectormap.route.RouteLineOptions
import com.kakao.vectormap.route.RouteLineSegment
import com.kakao.vectormap.route.RouteLineStyle
import com.orhanobut.logger.Logger
import com.pardess.directions.R
import com.pardess.directions.domain.model.TrafficState
import com.pardess.directions.presentation.DataState
import com.pardess.directions.presentation.DataState.Success
import com.pardess.directions.presentation.SuccessType
import com.pardess.directions.presentation.viewmodel.DirectionViewModel

private lateinit var layer: RouteLineLayer
private lateinit var multiStyleLine: com.kakao.vectormap.route.RouteLine
private lateinit var labelLayer: LabelLayer
private lateinit var kakaoMap: KakaoMap
private lateinit var mapView: MapView
private val duration = 500

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
        if (dateState is Success && dateState.successType == SuccessType.ROUTE_LINE_LIST) {
            viewModel.dataState = DataState.Ready()
            println("@@@@@@@ SUCCESS ${dateState.successType}")
            Logger.d(routeLineList.toString())
            drawRouteLine(
                context = context,
                routeLineList = routeLineList,
                origin = location.origin,
                destination = location.destination
            )
        }
    }
    if (dateState is DataState.Error) {
        labelLayer.remove(labelLayer.getLabel("start_label"))
        labelLayer.remove(labelLayer.getLabel("end_label"))
        if (::multiStyleLine.isInitialized) {
            layer.remove(multiStyleLine)
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
                                println("@@@@@@@@@ Destroy")
                                Toast.makeText(context, "Destroy", Toast.LENGTH_SHORT).show()
                            }

                            // 지도 생명 주기 콜백: 지도 로딩 중 에러가 발생했을 때 호출
                            override fun onMapError(exception: Exception?) {
                                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
                            }
                        },
                        object : KakaoMapReadyCallback() {
                            override fun onMapReady(map: KakaoMap) {
                                kakaoMap = map
                                Toast.makeText(context, "Ready", Toast.LENGTH_SHORT).show()
                                labelLayer = kakaoMap.labelManager!!.layer!!
                                layer = kakaoMap.routeLineManager!!.layer

                                kakaoMap.moveCamera(
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
    routeLineList: List<com.pardess.directions.domain.model.RouteLine>,
    origin: String,
    destination: String,
) {
    val routeSegmentList = mutableListOf<RouteLineSegment>()
    println("@@@@@ drawRouteLine()")

    if (::multiStyleLine.isInitialized) {
        layer.remove(multiStyleLine)
    }

    val pointsLatLng = routeLineList.flatMap { routeLines ->
        routeLines.wayList
    }.toTypedArray()

    if (::labelLayer.isInitialized) {
        labelLayer.remove(labelLayer.getLabel("start_label"))
        labelLayer.remove(labelLayer.getLabel("end_label"))
    }

    routeLineList.forEach {
        val style = when (it.trafficState) {
            TrafficState.UNKNOWN -> TrafficState.UNKNOWN.styleRes
            TrafficState.JAM -> TrafficState.JAM.styleRes
            TrafficState.DELAY -> TrafficState.DELAY.styleRes
            TrafficState.SLOW -> TrafficState.SLOW.styleRes
            TrafficState.NORMAL -> TrafficState.NORMAL.styleRes
            TrafficState.BLOCK -> TrafficState.BLOCK.styleRes
        }

        val routeLineStyle = RouteLineStyle.from(context, style)

        routeSegmentList.add(
            RouteLineSegment.from(
                it.wayList, routeLineStyle
            )
        )
    }

    val options = RouteLineOptions.from(
        routeSegmentList
    )

    multiStyleLine = layer.addRouteLine(options)

    setLabelWithText(
        context = context,
        labelId = "start_label",
        text = "출발",
        locationName = origin,
        lat = routeSegmentList[0].lats[0],
        lng = routeSegmentList[0].lngs[0]
    )

    setLabelWithText(
        context = context,
        labelId = "end_label",
        text = "도착",
        locationName = destination,
        lat = routeSegmentList.last().lats.last(),
        lng = routeSegmentList.last().lngs.last()
    )

    kakaoMap.moveCamera(
        CameraUpdateFactory.fitMapPoints(pointsLatLng, 250), CameraAnimation.from(1000, true, true)
    )
}


private fun setLabelWithText(
    context: Context,
    labelId: String,
    text: String,
    locationName: String,
    lat: Double,
    lng: Double
) {
    val pos = LatLng.from(lat, lng)

    val marker = when (text) {
        "출발" -> {
            Triple(
                R.drawable.blue_marker,
                LabelTextStyle.from(context, R.style.labelTextStyleBlack),
                LabelTextStyle.from(context, R.style.labelTextStyleBlue)
            )
        }

        "도착" -> {
            Triple(
                R.drawable.pink_marker,
                LabelTextStyle.from(context, R.style.labelTextStyleBlack),
                LabelTextStyle.from(context, R.style.labelTextStyleRed)
            )
        }

        else -> {
            Triple(
                R.drawable.green_marker,
                LabelTextStyle.from(context, R.style.labelTextStyleBlack),
                LabelTextStyle.from(context, R.style.labelTextStyleBlue)
            )
        }
    }

    val styles = kakaoMap.labelManager
        ?.addLabelStyles(
            LabelStyles.from(
                LabelStyle.from(
                    marker.first
                ).setTextStyles(
                    marker.second,
                    marker.third
                )
                    .setIconTransition(LabelTransition.from(Transition.None, Transition.None))
            )
        )

    labelLayer.addLabel(
        LabelOptions.from(labelId, pos).setStyles(styles)
            .setTexts(
                LabelTextBuilder().setTexts(
                    text,
                    locationName,
                )
            )
    )
    kakaoMap.moveCamera(
        CameraUpdateFactory.newCenterPosition(pos, 15),
        CameraAnimation.from(duration)
    )
}

