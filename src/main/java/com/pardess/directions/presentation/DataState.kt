package com.pardess.directions.presentation

import com.pardess.directions.data.ErrorType

sealed class DataState {

    class Ready : DataState()

    class Loading : DataState()

    data class Success(val successType: SuccessType) : DataState()

    data class Error(val message: String, val errorCode: Int? = 0, val errorType: ErrorType) :
        DataState()
}

enum class SuccessType {
    ROUTE_LINE_LIST,
    ROUTE_LIST,
    ROUTE_INFO
}