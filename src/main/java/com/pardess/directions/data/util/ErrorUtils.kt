package com.pardess.directions.data.util

import android.util.Log
import com.google.gson.Gson
import com.pardess.directions.data.ResponseType
import com.pardess.directions.data.ExceptionType
import com.pardess.directions.data.Result
import com.pardess.directions.data.response.error.ErrorResponse
import retrofit2.HttpException

object ErrorUtils {

    fun <T> HttpException.httpExceptionError(responseType: ResponseType): Result.Error<T> {
        val exceptionType = this.code().exceptionType()
        val errorBody = this.response()?.errorBody()?.string()
        var httpExceptionCode = 0
        var exceptionMessage = ""

        errorBody?.let {
            try {
                val errorResponse = Gson().fromJson(it, ErrorResponse::class.java)
                httpExceptionCode = errorResponse.code
                exceptionMessage = errorResponse.message
                Log.e("API Error", "Code: $httpExceptionCode, Message: $exceptionMessage")
            } catch (jsonException: Exception) {
                Log.e(
                    "API Error",
                    "Error parsing error response: ${jsonException.message}"
                )
            }
        } ?: run {
            Log.e("API Error", "Error body is null")
        }

        return Result.Error(
            message = exceptionMessage,
            responseType = responseType,
            httpExceptionCode = httpExceptionCode,
            exceptionType = exceptionType
        )
    }

    private fun Int.exceptionType(): ExceptionType {
        return when (this) {
            400 -> ExceptionType.BAD_REQUEST_ERROR
            401 -> ExceptionType.AUTHENTICATION_ERROR
            404 -> ExceptionType.RESOURCE_NOT_FOUND
            500 -> ExceptionType.SERVER_ERROR
            else -> ExceptionType.HTTP_ERROR
        }
    }
}
