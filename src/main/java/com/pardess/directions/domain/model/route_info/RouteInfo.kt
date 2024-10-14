package com.pardess.directions.domain.model.route_info


// 경로 정보를 나타내는 데이터 클래스
data class RouteInfo(
    val distance: Int, // 경로 거리 (미터 단위)
    val hour: Int, // 경로 소요 시간 (시간 단위)
    val minute: Int, // 경로 소요 시간 (분 단위)
    val second: Int, // 경로 소요 시간 (초 단위)
)