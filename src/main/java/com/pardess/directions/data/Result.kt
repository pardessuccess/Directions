package com.pardess.directions.data

sealed class Result<T>(
    val data: T? = null,
    val message: String? = null,
    val errorCode: Int? = null,
    val errorType: ErrorType = ErrorType.UNKNOWN_ERROR
) {

    class Success<T>(data: T) : Result<T>(data)

    class Error<T>(message: String, errorCode: Int, errorType: ErrorType) :
        Result<T>(message = message, errorCode = errorCode, errorType = errorType)

    override fun toString(): String {
        return "Resource(data=$data, message=$message, errorCode=$errorCode errorType=$errorType)"
    }
}

enum class ErrorType {
    HTTP_ERROR,
    UNKNOWN_ERROR,
    BAD_REQUEST_ERROR,
    AUTHENTICATION_ERROR,
    SERVER_ERROR,
    RESOURCE_NOT_FOUND
}