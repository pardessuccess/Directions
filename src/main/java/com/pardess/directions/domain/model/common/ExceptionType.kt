package com.pardess.directions.domain.model.common


// 예외 유형을 정의하는 Enum 클래스
enum class ExceptionType {
    HTTP_ERROR, // 일반적인 HTTP 오류
    UNKNOWN_ERROR, // 알 수 없는 오류
    BAD_REQUEST_ERROR, // 잘못된 요청 오류 (400)
    AUTHENTICATION_ERROR, // 인증 오류 (401)
    SERVER_ERROR, // 서버 오류 (500)
    RESOURCE_NOT_FOUND // 리소스를 찾을 수 없는 오류 (404)
}