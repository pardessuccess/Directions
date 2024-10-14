package com.pardess.directions.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

// 요청을 재시도하는 인터셉터 클래스
class RetryInterceptor(private val maxRetry: Int) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request() // 원래의 요청 객체
        var response: Response? = null
        var tryCount = 0 // 재시도 횟수 초기화

        // 응답이 성공적으로 올 때까지 재시도하거나 최대 재시도 횟수에 도달할 때까지 반복
        while (response == null && tryCount < maxRetry) {
            try {
                response = chain.proceed(request) // 요청 실행
            } catch (e: IOException) {
                tryCount++ // 재시도 횟수 증가
                if (tryCount >= maxRetry) {
                    throw e // 최대 재시도 횟수에 도달하면 예외 발생
                }
            }
        }
        return response!! // 응답 반환 (null이 될 수 없음 보장)
    }
}
