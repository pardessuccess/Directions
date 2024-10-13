package com.pardess.directions.domain.usecase.mapview

import android.content.Context
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.camera.CameraAnimation
import com.kakao.vectormap.camera.CameraUpdateFactory
import com.kakao.vectormap.label.LabelLayer
import com.kakao.vectormap.route.RouteLineLayer
import com.kakao.vectormap.route.RouteLineOptions
import com.kakao.vectormap.route.RouteLineSegment
import com.kakao.vectormap.route.RouteLineStyle
import com.pardess.directions.R
import com.pardess.directions.domain.model.RouteLine
import com.pardess.directions.domain.model.TrafficState

lateinit var multiStyleLine: com.kakao.vectormap.route.RouteLine

class DrawRouteLineUseCase(
    private val context: Context,
    private val kakaoMap: KakaoMap,
    private val labelLayer: LabelLayer,
    private val routeLineLayer: RouteLineLayer,
    private val setLabelWithTextUseCase: SetLabelWithTextUseCase
) {

    fun execute(
        routeLineList: List<RouteLine>,
        origin: String,
        destination: String
    ) {
        val routeSegmentList = mutableListOf<RouteLineSegment>()
        val pointsLatLng = routeLineList.flatMap { routeLines ->
            routeLines.wayList
        }.toTypedArray()


        if (::multiStyleLine.isInitialized){
            routeLineLayer.remove(multiStyleLine)
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

        multiStyleLine = routeLineLayer.addRouteLine(options)


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

        kakaoMap.moveCamera(
            CameraUpdateFactory.fitMapPoints(pointsLatLng, 250),
            CameraAnimation.from(1000, true, true)
        )
    }
}