package com.pardess.directions.data.mapper

import com.kakao.vectormap.LatLng
import com.pardess.directions.data.response.distance_time.RouteInfoDto
import com.pardess.directions.data.response.location.LocationListDto
import com.pardess.directions.data.response.route.RouteListDto
import com.pardess.directions.domain.model.Route
import com.pardess.directions.domain.model.RouteInfo
import com.pardess.directions.domain.model.RouteLine
import com.pardess.directions.domain.model.TrafficState
import java.math.BigDecimal
import java.math.RoundingMode

object DataMapper {

    fun LocationListDto.mapToRoute(): List<Route> {
        return this.locations.map { location ->
            Route(
                origin = location.origin,
                destination = location.destination
            )
        }
    }

    fun RouteListDto.mapToRouteLine(): List<RouteLine> {
        return this.map { routeItem ->
            val latLngList = routeItem.points.split(" ").map { point ->
                // Double로 변한하되 최대한 근사값을 유지해야 하므로, BigDecimal 17자리에서 반올림
                val coordinates = point.split(",").map {
                    BigDecimal(it).setScale(16, RoundingMode.HALF_UP).toDouble()
                }
                LatLng.from(coordinates[1], coordinates[0])  // LatLng 생성 (위도, 경도)
            }

            val trafficState = when (routeItem.traffic_state) {
                "UNKNOWN" -> {
                    TrafficState.UNKNOWN
                }

                "JAM" -> {
                    TrafficState.JAM
                }

                "DELAY" -> {
                    TrafficState.DELAY
                }

                "SLOW" -> {
                    TrafficState.SLOW
                }

                "NORMAL" -> {
                    TrafficState.NORMAL
                }

                "BLOCK" -> {
                    TrafficState.BLOCK
                }

                else -> {
                    TrafficState.UNKNOWN
                }
            }

            RouteLine(
                wayList = latLngList,
                trafficState = trafficState
            )
        }
    }

    fun RouteInfoDto.mapToRouteInfo(): RouteInfo {
        val totalSeconds = this.time
        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60

        return RouteInfo(
            distance = this.distance, // distance in meters
            hour = hours,
            minute = minutes,
            second = seconds
        )
    }

}