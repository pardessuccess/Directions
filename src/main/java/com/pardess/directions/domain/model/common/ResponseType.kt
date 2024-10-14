package com.pardess.directions.domain.model.common


// 응답 유형을 정의하는 Enum 클래스
enum class ResponseType() {
    ROUTE_LIST(), // 경로 목록 응답
    ROUTE_INFO(), // 경로 정보 응답
    ROUTE_LINE_LIST() // 경로 라인 목록 응답
}