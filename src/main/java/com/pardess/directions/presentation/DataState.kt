package com.pardess.directions.presentation

import com.pardess.directions.data.ExceptionType
import com.pardess.directions.data.ResponseType

sealed class DataState {

    data object Ready : DataState()

    data class Success(val responseType: ResponseType) : DataState()

    data class Error(
        val message: String,
        val responseType: ResponseType,
        val httpExceptionCode: Int? = 0,
        val exceptionType: ExceptionType
    ) :
        DataState()
}

enum class SuccessType {
    ROUTE_LINE_LIST,
    ROUTE_LIST,
    ROUTE_INFO
}