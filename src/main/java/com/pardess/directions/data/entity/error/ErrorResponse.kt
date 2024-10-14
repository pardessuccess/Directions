package com.pardess.directions.data.entity.error

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("code") // 서버 에러 응답에서의 코드 필드
    val code: Int,

    @SerializedName("message") // 서버 에러 응답에서의 메시지 필드
    val message: String
)