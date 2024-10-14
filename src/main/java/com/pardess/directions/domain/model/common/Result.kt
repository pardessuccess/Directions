package com.pardess.directions.domain.model.common

// API 호출 결과를 나타내는 Sealed 클래스
sealed class Result<T> {

    // 성공 결과를 나타내는 클래스
    data class Success<T>(
        val data: T,
        val responseType: ResponseType
    ) : Result<T>()

    // 오류 결과를 나타내는 클래스
    data class Error<T>(
        val message: String,
        val responseType: ResponseType,
        val httpExceptionCode: Int,
        val exceptionType: ExceptionType
    ) : Result<T>()

    // Result 객체의 문자열 표현을 정의하는 함수
    override fun toString(): String {
        return when (this) {
            is Success -> "Success(data=$data, responseType=$responseType)"
            is Error -> "Error(message=$message, responseType=$responseType, httpExceptionCode=$httpExceptionCode, exceptionType=$exceptionType)"
        }
    }
}
