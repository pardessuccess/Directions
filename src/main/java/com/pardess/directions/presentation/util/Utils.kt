package com.pardess.directions.presentation.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.LayoutInflater
import android.view.View
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.route.RouteLineSegment
import com.kakao.vectormap.route.RouteLineStyle
import com.pardess.directions.domain.model.route_info.RouteInfo
import com.pardess.directions.domain.model.route_line_list.RouteLine
import com.pardess.directions.domain.model.route_line_list.TrafficState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.math.*

object Utils {

    // 경로 정보를 설정하는 함수 (시간과 거리 정보를 반환)
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

    // 거리 정보를 콤마와 함께 문자열로 반환하는 함수
    fun meterWithComma(text: String, number: Int): String {
        val distanceString = StringBuilder("$text : ")
        distanceString.append(String.format("%,d", number))
        distanceString.append(" m")
        return distanceString.toString().trim()
    }

    // 시간 정보를 설정하는 함수 (시간, 분, 초로 구성된 문자열 반환)
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

    // 두 지점 간의 직선 거리를 계산하는 함수 (하버사인 공식 사용)
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

    // 경로 리스트를 RouteLineSegment 리스트로 변환하는 함수
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
                    it.routeLine, routeLineStyle
                )
            )
        }

        return routeSegmentList
    }

    // 경로 리스트를 LatLng 배열로 변환하는 함수
    fun List<RouteLine>.convertToLatLngPoints(): Array<LatLng> {
        return this.flatMap { routeLines ->
            routeLines.routeLine
        }.toTypedArray()
    }

    // click 시에 코루틴에서 실행되도록 하는 함수
    fun Modifier.clickWithCoroutine(
        coroutineScope: CoroutineScope,
        onClick: suspend () -> Unit
    ): Modifier {
        return this.clickable {
            coroutineScope.launch {
                onClick()
            }
        }
    }
}