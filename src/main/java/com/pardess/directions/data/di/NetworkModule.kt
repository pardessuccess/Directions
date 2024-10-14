package com.pardess.directions.data.di

import com.google.gson.GsonBuilder
import com.pardess.directions.common.Constants
import com.pardess.directions.common.Constants.BASE_URL
import com.pardess.directions.data.network.KakaoApi
import com.pardess.directions.data.interceptor.RetryInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Retrofit 사용하여 KakaoApi 제공
    @Provides
    @Singleton
    fun provideKakaoApi(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            ).build()

    // KakaoApi 인스턴스 제공
    @Provides
    @Singleton
    fun provideKakaoApiInstance(
        retrofit: Retrofit
    ): KakaoApi {
        return retrofit.create(KakaoApi::class.java)
    }

    // OkHttpClient 제공 함수
    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {

        // HTTP 요청 및 응답 내용을 로그로 출력하는 인터셉터 설정
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)  // 요청 및 응답의 바디 내용을 로그로 출력
        }

        // KakaoApi 사용을 위한 Authorization 헤더 추가 인터셉터 설정
        val headerInterceptor = Interceptor { chain ->
            val original = chain.request()
            // Authorization 헤더 추가
            val requestBuilder = original.newBuilder()
                .header("Authorization", Constants.KAKAO_MOBILITY_KEY)
            val request = requestBuilder.build()
            chain.proceed(request)
        }

        // 테스트 목적으로 지연 시간을 추가하는 인터셉터 설정
        val delayForTestInterceptor = Interceptor { chain ->
//            Thread.sleep(1000)
            chain.proceed(chain.request())
        }

        // OkHttpClient 빌더 설정 및 반환
        return OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(RetryInterceptor(3))
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(delayForTestInterceptor)
            .build()
    }


}
