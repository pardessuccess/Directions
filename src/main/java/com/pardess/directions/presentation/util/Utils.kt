package com.pardess.directions.presentation.util

import android.content.Context
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.route.RouteLineSegment
import com.kakao.vectormap.route.RouteLineStyle
import com.pardess.directions.domain.model.RouteInfo
import com.pardess.directions.domain.model.RouteLine
import com.pardess.directions.domain.model.TrafficState
import kotlin.math.*

object Utils {

    fun setRouteInfo(
        routeInfo: RouteInfo,
    ): Pair<String, String> {
        return Pair(
            setTime(routeInfo.hour, routeInfo.minute, routeInfo.second),
            meterWithComma(
                "거리",
                routeInfo.distance
            ),
        )
    }

    fun meterWithComma(text: String, number: Int): String {
        val distanceString = StringBuilder("$text : ")
        distanceString.append(String.format("%,d", number))
        distanceString.append(" m")
        return distanceString.toString().trim()
    }

    private fun setTime(hour: Int, minute: Int, second: Int): String {

        val timeString = StringBuilder("소요 시간 : ")

        if (hour > 0) {
            timeString.append(String.format("%d시간 ", hour))
        }

        if (minute > 0) {
            timeString.append(String.format("%1d분 ", minute))
        }

        timeString.append(String.format("%1d초", second))

        return timeString.toString().trim()
    }

    fun haversine(startLatLng: LatLng, endLatLng: LatLng): Int {

        val startLat = startLatLng.latitude
        val startLng = startLatLng.longitude

        val endLat = endLatLng.latitude
        val endLng = endLatLng.longitude

        val R = 6371e3 // 지구 반지름 (미터)
        val phi1 = startLat * (Math.PI / 180) // 위도를 라디안으로 변환
        val phi2 = endLat * (Math.PI / 180)
        val deltaPhi = (endLat - startLat) * (Math.PI / 180)
        val deltaLambda = (endLng - startLng) * (Math.PI / 180)

        val a = sin(deltaPhi / 2) * sin(deltaPhi / 2) +
                cos(phi1) * cos(phi2) *
                sin(deltaLambda / 2) * sin(deltaLambda / 2)
        val c = 2 * atan2(sqrt(a), sqrt(1 - a))
        val distance = R * c // 두 지점 사이의 직선 거리 (미터)
        return distance.toInt()
    }

    fun List<RouteLine>.convertToRouteSegmentList(context: Context): List<RouteLineSegment> {
        val routeSegmentList = mutableListOf<RouteLineSegment>()

        this.forEach {
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

        return routeSegmentList
    }

    fun List<RouteLine>.convertToLatLngPoints(): Array<LatLng> {
        return this.flatMap { routeLines ->
            routeLines.wayList
        }.toTypedArray()
    }

}