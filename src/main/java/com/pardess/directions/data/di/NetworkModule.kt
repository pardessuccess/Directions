package com.pardess.directions.data.di

import com.google.gson.GsonBuilder
import com.pardess.directions.Constants
import com.pardess.directions.Constants.BASE_URL
import com.pardess.directions.data.network.KakaoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

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

    @Provides
    @Singleton
    fun provideKakaoApiInstance(
        retrofit: Retrofit
    ): KakaoApi {
        return retrofit.create(KakaoApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttp(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)  // 요청 및 응답의 바디 내용을 로그로 출력
        }

        val headerInterceptor = Interceptor { chain ->
            val original = chain.request()

            // Authorization 헤더 추가
            val requestBuilder = original.newBuilder()
                .header("Authorization", Constants.KAKAO_MOBILITY_KEY)
                .header("Content-Type", "application/json")

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        return OkHttpClient.Builder().addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor).build()
    }


}