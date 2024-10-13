package com.pardess.directions.data

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null,
    val responseType: ResponseType? = null,
    val exceptionCode: Int? = null,
    val exceptionType: ExceptionType? = null
) {

    class Success<T>(
        data: T,
        responseType: ResponseType
    ) : Result<T>(
        data = data,
        responseType = responseType
    )

    class Error<T>(
        message: String,
        responseType: ResponseType,
        httpExceptionCode: Int,
        exceptionType: ExceptionType
    ) :
        Result<T>(
            message = message,
            responseType = responseType,
            exceptionCode = httpExceptionCode,
            exceptionType = exceptionType
        )

    override fun toString(): String {
        return "Resource(data=$data, message=$message, responseType=$responseType, httpExceptionCode=$exceptionCode errorType=$exceptionType)"
    }
}

enum class ResponseType {
    ROUTE_LIST,
    ROUTE_INFO,
    ROUTE_LINE_LIST
}

enum class ExceptionType {
    HTTP_ERROR,
    UNKNOWN_ERROR,
    BAD_REQUEST_ERROR,
    AUTHENTICATION_ERROR,
    SERVER_ERROR,
    RESOURCE_NOT_FOUND
}