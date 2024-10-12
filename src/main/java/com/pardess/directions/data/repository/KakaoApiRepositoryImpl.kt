package com.pardess.directions.data.repository

import com.pardess.directions.data.ErrorType
import com.pardess.directions.data.Result
import com.pardess.directions.data.mapper.DataMapper
import com.pardess.directions.data.network.KakaoApi
import com.pardess.directions.data.response.location.LocationListDto
import com.pardess.directions.data.util.ErrorUtils.httpExceptionToError
import com.pardess.directions.domain.model.RouteInfo
import com.pardess.directions.domain.model.RouteLine
import com.pardess.directions.domain.repository.KakaoApiRepository
import retrofit2.HttpException
import javax.inject.Inject

class KakaoApiRepositoryImpl @Inject constructor(
    private val kakaoApi: KakaoApi,
) : KakaoApiRepository {
    override suspend fun getLocationList(): Result<LocationListDto> {
        val result = try {
            val response = kakaoApi.getLocations()
            Result.Success(response)
        } catch (e: Exception) {
            when (e) {
                is HttpException -> {
                    httpExceptionToError(e)
                }
                else -> {
                    Result.Error(
                        message = e.message ?: "Unknown error occurred",
                        errorCode = 0,
                        errorType = ErrorType.UNKNOWN_ERROR
                    )
                }
            }
        }
        return result
    }

    override suspend fun getRouteLines(
        origin: String,
        destination: String
    ): Result<List<RouteLine>> {
        val result = try {
            val response = DataMapper.mapToWayLine(
                kakaoApi.getRoutes(
                    origin = origin,
                    destination = destination
                )
            )
            Result.Success(response)
        } catch (e: Exception) {
            when (e) {
                is HttpException -> httpExceptionToError(e)
                else -> {
                    Result.Error(
                        message = e.message ?: "Unknown error occurred",
                        errorCode = 0,
                        errorType = ErrorType.UNKNOWN_ERROR
                    )
                }
            }
        }
        return result
    }

    override suspend fun getRouteInfo(origin: String, destination: String): Result<RouteInfo> {
        val result = try {
            val response =
                DataMapper.mapToRouteInfo(
                    kakaoApi.getDistanceTime(
                        origin = origin,
                        destination = destination
                    )
                )
            Result.Success(response)
        } catch (e: Exception) {
            when (e) {
                is HttpException -> httpExceptionToError(e)
                else -> {
                    Result.Error(
                        message = e.message ?: "Unknown error occurred",
                        errorCode = 0,
                        errorType = ErrorType.UNKNOWN_ERROR
                    )
                }
            }
        }
        return result
    }
}