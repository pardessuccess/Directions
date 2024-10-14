package com.pardess.directions.domain.usecase.mapview

import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.camera.CameraAnimation
import com.kakao.vectormap.camera.CameraUpdateFactory
import com.kakao.vectormap.route.RouteLineLayer
import com.kakao.vectormap.route.RouteLineOptions
import com.kakao.vectormap.route.RouteLineSegment
import com.pardess.directions.domain.model.route_line_list.RouteLine
import com.pardess.directions.domain.model.route_line_list.TrafficState
import com.pardess.directions.domain.repository.AppContextRepository
import com.pardess.directions.presentation.util.Utils.convertToLatLngPoints
import javax.inject.Inject

// 경로 라인을 그리는 유스케이스 클래스
class DrawRouteLineUseCase @Inject constructor(
    private val appContextRepository: AppContextRepository,
) {

    operator fun invoke(
        routeLineList: List<RouteLine>,
        kakaoMap: KakaoMap,
        routeLineLayer: RouteLineLayer?,
        multiStyleLine: com.kakao.vectormap.route.RouteLine?,
    ): com.kakao.vectormap.route.RouteLine? {
        val routeSegmentList = mutableListOf<RouteLineSegment>()
        val pointsLatLng = routeLineList.convertToLatLngPoints()

        // 기존의 라인 제거
        multiStyleLine?.let { styleLine ->
            multiStyleLine.lineId?.let { lineId ->
                routeLineLayer?.remove(styleLine)
            }
        }

        // 각 경로에 대해 라인 스타일을 설정하고 세그먼트를 추가
        routeLineList.forEach {
            val style = when (it.trafficState) {
                TrafficState.UNKNOWN -> TrafficState.UNKNOWN.styleRes
                TrafficState.JAM -> TrafficState.JAM.styleRes
                TrafficState.DELAY -> TrafficState.DELAY.styleRes
                TrafficState.SLOW -> TrafficState.SLOW.styleRes
                TrafficState.NORMAL -> TrafficState.NORMAL.styleRes
                TrafficState.BLOCK -> TrafficState.BLOCK.styleRes
            }

            val routeLineStyle = appContextRepository.setRouteLineStyle(style)
            routeSegmentList.add(
                RouteLineSegment.from(
                    it.routeLine, routeLineStyle
                )
            )
        }

        // 경로 라인 옵션 생성
        val options = RouteLineOptions.from(
            routeSegmentList
        )

        // 카메라를 경로에 맞게 이동
        kakaoMap.moveCamera(
            CameraUpdateFactory.fitMapPoints(pointsLatLng, 250),
            CameraAnimation.from(1000, true, true)
        )

        // 경로 라인 추가
        return routeLineLayer?.addRouteLine(options)
    }
}