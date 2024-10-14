package com.pardess.directions.domain.repository

import com.pardess.directions.domain.model.common.Result
import com.pardess.directions.domain.model.route_list.Route
import com.pardess.directions.domain.model.route_info.RouteInfo
import com.pardess.directions.domain.model.route_line_list.RouteLine

// Kakao API와 상호작용하는 리포지토리 인터페이스
interface KakaoApiRepository {

    // 출발지와 목적지 목록을 가져오는 함수
    suspend fun getRouteList(): Result<List<Route>>

    // 출발지와 목적지 간의 경로 라인 목록을 가져오는 함수
    suspend fun getRouteLineList(
        origin: String,
        destination: String,
    ): Result<List<RouteLine>>

    // 출발지와 목적지 간의 경로 정보를 가져오는 함수
    suspend fun getRouteInfo(
        origin: String,
        destination: String,
    ): Result<RouteInfo>
}