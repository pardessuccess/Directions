package com.pardess.directions.data.network

import com.pardess.directions.data.response.distance_time.RouteInfoDto
import com.pardess.directions.data.response.location.LocationListDto
import com.pardess.directions.data.response.route.RouteListDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoApi {


    @GET("api/v1/coding-assignment/locations")
    suspend fun getLocations(
    ): LocationListDto

    @GET("api/v1/coding-assignment/routes")
    suspend fun getRoutes(
        @Header("Content-Type") contentType: String = "application/json",
        @Query("origin") origin: String,
        @Query("destination") destination: String
    ): RouteListDto

    @GET("api/v1/coding-assignment/distance-time")
    suspend fun getDistanceTime(
        @Header("Content-Type") contentType: String = "application/json",
        @Query("origin") origin: String,
        @Query("destination") destination: String
    ): RouteInfoDto

}