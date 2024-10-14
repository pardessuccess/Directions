package com.pardess.directions.domain.model.common

// 네트워크 호출 등의 상태를 나타내는 sealed 클래스
sealed class DataState {

    // 준비 상태를 나타내는 객체
    data object Ready : DataState()

    // 성공 상태를 나타내는 데이터 클래스
    data class Success(val responseType: ResponseType) : DataState()

    // 에러 상태를 나타내는 데이터 클래스
    data class Error(
        val message: String, // 에러 메시지
        val responseType: ResponseType, // 응답 타입
        val httpExceptionCode: Int = 0, // HTTP 예외 코드
        val exceptionType: ExceptionType // 예외 타입
    ) : DataState()
}