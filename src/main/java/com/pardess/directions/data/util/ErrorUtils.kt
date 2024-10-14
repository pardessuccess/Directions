package com.pardess.directions.data.util

import android.util.Log
import com.google.gson.Gson
import com.pardess.directions.R
import com.pardess.directions.data.entity.error.ErrorResponse
import com.pardess.directions.domain.model.common.ExceptionType
import com.pardess.directions.domain.model.common.ResponseType
import com.pardess.directions.domain.model.common.Result
import com.pardess.directions.domain.repository.AppContextRepository
import retrofit2.HttpException

// 오류 처리 유틸리티 함수 모음
object ErrorUtils {

    // HttpException을 처리하여 오류 결과를 반환하는 함수
    fun <T> HttpException.httpExceptionError(responseType: ResponseType): Result.Error<T> {
        val exceptionType = this.code().exceptionType()
        val errorBody = this.response()?.errorBody()?.string()
        var httpExceptionCode = 0
        var exceptionMessage = ""

        // 오류 응답 바디를 파싱하여 에러 메시지 및 코드 설정
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

    // 일반적인 예외를 처리하여 오류 결과를 반환하는 함수
    fun <T> exceptionError(
        appContextRepository: AppContextRepository,
        responseType: ResponseType
    ): Result.Error<T> {
        return Result.Error(
            message = appContextRepository.getStringResource(R.string.not_connected_with_internet),
            responseType = responseType,
            httpExceptionCode = 0,
            exceptionType = ExceptionType.UNKNOWN_ERROR
        )
    }

    // HTTP 오류 코드에 따른 예외 유형을 반환하는 함수
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
