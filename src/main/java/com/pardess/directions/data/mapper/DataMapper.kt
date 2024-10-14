package com.pardess.directions.data.mapper

import com.kakao.vectormap.LatLng
import com.pardess.directions.data.entity.route_info.RouteInfoDto
import com.pardess.directions.data.entity.route_list.LocationListDto
import com.pardess.directions.data.entity.route_line_list.RouteListDto
import com.pardess.directions.domain.model.route_list.Route
import com.pardess.directions.domain.model.route_info.RouteInfo
import com.pardess.directions.domain.model.route_line_list.RouteLine
import com.pardess.directions.domain.model.route_line_list.TrafficState
import java.math.BigDecimal
import java.math.RoundingMode

object DataMapper {

    // LocationListDto를 Route 리스트로 매핑하는 함수
    fun LocationListDto.mapToRoute(): List<Route> {
        return this.locations.map { location ->
            Route(
                origin = location.origin, // 출발지 설정
                destination = location.destination // 목적지 설정
            )
        }
    }

    // RouteListDto를 RouteLine 리스트로 매핑하는 함수
    fun RouteListDto.mapToRouteLine(): List<RouteLine> {
        return this.map { routeItem ->
            val latLngList = routeItem.points.split(" ").map { point ->
                // 문자열로 된 좌표를 나누어 BigDecimal로 변환, 소수점 17자리에서 반올림하여 정확도 유지
                // Double로 변한하되 최대한 근사값을 유지해야 하므로, BigDecimal 17자리에서 반올림
                val coordinates = point.split(",").map {
                    BigDecimal(it).setScale(17, RoundingMode.HALF_UP).toDouble()
                }
                LatLng.from(coordinates[1], coordinates[0])  // LatLng 생성 (위도, 경도)
            }

            // 교통 상태 문자열을 TrafficState Enum으로 변환
            val trafficState = when (routeItem.trafficState) {
                "UNKNOWN" -> TrafficState.UNKNOWN
                "JAM" -> TrafficState.JAM
                "DELAY" -> TrafficState.DELAY
                "SLOW" -> TrafficState.SLOW
                "NORMAL" -> TrafficState.NORMAL
                "BLOCK" -> TrafficState.BLOCK
                else -> TrafficState.UNKNOWN
            }

            // RouteLine 객체 생성
            RouteLine(
                routeLine = latLngList, // 경로 라인 좌표 리스트
                trafficState = trafficState // 교통 상태 설정
            )
        }
    }

    // RouteInfoDto를 RouteInfo로 매핑하는 함수
    fun RouteInfoDto.mapToRouteInfo(): RouteInfo {
        val totalSeconds = this.time
        val hours = totalSeconds / 3600 // 시간 계산
        val minutes = (totalSeconds % 3600) / 60 // 분 계산
        val seconds = totalSeconds % 60 // 초 계산

        return RouteInfo(
            distance = this.distance, // 거리 (미터 단위)
            hour = hours, // 시간 정보
            minute = minutes, // 분 정보
            second = seconds // 초 정보
        )
    }

}