package com.pardess.directions.data.network

import com.pardess.directions.data.response.distance_time.RouteInfoDto
import com.pardess.directions.data.response.location.LocationListDto
import com.pardess.directions.data.response.route.RouteListDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoApi {

//    @Headers(
//        "Authorization: ${Constants.KAKAO_MOBILITY_KEY}"
//    )

    @GET("api/v1/coding-assignment/locations")
    suspend fun getLocations(
//        @Header("Authorization") authToken: String = KAKAO_MOBILITY_KEY
    ): LocationListDto

    @GET("api/v1/coding-assignment/routes")
    suspend fun getRoutes(
//        @Header("Authorization") authToken: String = KAKAO_MOBILITY_KEY,
        @Header("Content-Type") contentType: String = "application/json",
        @Query("origin") origin: String,
        @Query("destination") destination: String
    ): RouteListDto

    @GET("api/v1/coding-assignment/distance-time")
    suspend fun getDistanceTime(
//        @Header("Authorization") authToken: String = KAKAO_MOBILITY_KEY,
        @Header("Content-Type") contentType: String = "application/json",
        @Query("origin") origin: String,
        @Query("destination") destination: String
    ): RouteInfoDto

}