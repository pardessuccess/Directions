package com.pardess.directions.data.network

import com.pardess.directions.data.entity.route_info.RouteInfoDto
import com.pardess.directions.data.entity.route_list.LocationListDto
import com.pardess.directions.data.entity.route_line_list.RouteListDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

// KakaoApi 인터페이스 정의: Kakao API 호출을 위한 Retrofit 서비스 인터페이스
interface KakaoApi {

    // 출발지,목적지 목록을 가져오는 GET 요청
    @GET("api/v1/coding-assignment/locations")
    suspend fun getLocations(): LocationListDto

    // 출발지와 목적지 사이의 경로를 가져오는 GET 요청
    @GET("api/v1/coding-assignment/routes")
    suspend fun getRoutes(
        @Header("Content-Type") contentType: String = "application/json",
        @Query("origin") origin: String,
        @Query("destination") destination: String
    ): RouteListDto

    // 출발지와 목적지 사이의 거리 및 시간을 가져오는 GET 요청
    @GET("api/v1/coding-assignment/distance-time")
    suspend fun getDistanceTime(
        @Header("Content-Type") contentType: String = "application/json",
        @Query("origin") origin: String,
        @Query("destination") destination: String
    ): RouteInfoDto
}