package com.pardess.directions.domain.model.route_line_list

import com.kakao.vectormap.LatLng

// 경로 라인을 나타내는 데이터 클래스
data class RouteLine(
    val routeLine: List<LatLng>, // 경로 좌표 리스트
    val trafficState: TrafficState // 경로의 교통 상태
)