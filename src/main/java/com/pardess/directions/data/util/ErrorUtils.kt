package com.pardess.directions.data.util

import android.util.Log
import com.google.gson.Gson
import com.pardess.directions.data.ErrorType
import com.pardess.directions.data.Result
import com.pardess.directions.data.response.error.ErrorResponse
import retrofit2.HttpException

object ErrorUtils {

    fun <T> httpExceptionToError(e: HttpException): Result.Error<T> {
        val errorType = e.code().toErrorType()
        val errorBody = e.response()?.errorBody()?.string()
        var errorCode = 0
        var errorMessage = ""

        errorBody?.let {
            try {
                val errorResponse = Gson().fromJson(it, ErrorResponse::class.java)
                errorCode = errorResponse.code
                errorMessage = errorResponse.message
                Log.e("API Error", "Code: $errorCode, Message: $errorMessage")
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
            message = errorMessage,
            errorCode = errorCode,
            errorType = errorType
        )
    }


    private fun Int.toErrorType(): ErrorType {
        return when (this) {
            400 -> ErrorType.BAD_REQUEST_ERROR
            401 -> ErrorType.AUTHENTICATION_ERROR
            404 -> ErrorType.RESOURCE_NOT_FOUND
            500 -> ErrorType.SERVER_ERROR
            else -> ErrorType.HTTP_ERROR
        }
    }
}
