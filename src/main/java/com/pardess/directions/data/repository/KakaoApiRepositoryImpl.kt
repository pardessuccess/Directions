package com.pardess.directions.data.repository

import com.pardess.directions.data.ResponseType
import com.pardess.directions.data.ExceptionType
import com.pardess.directions.data.Result
import com.pardess.directions.data.mapper.DataMapper.mapToRoute
import com.pardess.directions.data.mapper.DataMapper.mapToRouteInfo
import com.pardess.directions.data.mapper.DataMapper.mapToRouteLine
import com.pardess.directions.data.network.KakaoApi
import com.pardess.directions.data.util.ErrorUtils.httpExceptionError
import com.pardess.directions.domain.model.Route
import com.pardess.directions.domain.model.RouteInfo
import com.pardess.directions.domain.model.RouteLine
import com.pardess.directions.domain.repository.KakaoApiRepository
import retrofit2.HttpException
import javax.inject.Inject

class KakaoApiRepositoryImpl @Inject constructor(
    private val kakaoApi: KakaoApi,
) : KakaoApiRepository {

    override suspend fun getRouteList(): Result<List<Route>> {
        val result = try {
            val response = kakaoApi.getLocations().mapToRoute()
            Result.Success(response, ResponseType.ROUTE_LIST)
        } catch (e: Exception) {
            when (e) {
                is HttpException -> {
                    e.httpExceptionError(ResponseType.ROUTE_LIST)
                }

                else -> {
                    println("@@@@@@$e + ${e.message} + ${e.localizedMessage}")
                    Result.Error(
                        message = "인터넷에 연결되어 있지 않습니다.",
                        responseType = ResponseType.ROUTE_LIST,
                        httpExceptionCode = 0,
                        exceptionType = ExceptionType.UNKNOWN_ERROR
                    )
                }
            }
        }
        return result
    }

    override suspend fun getRouteLineList(
        origin: String,
        destination: String
    ): Result<List<RouteLine>> {
        val result = try {
            val response = kakaoApi.getRoutes(
                origin = origin,
                destination = destination
            ).mapToRouteLine()
            Result.Success(response, ResponseType.ROUTE_LINE_LIST)
        } catch (e: Exception) {
            when (e) {
                is HttpException -> e.httpExceptionError(ResponseType.ROUTE_LINE_LIST)
                else -> {
                    println("@@@@@@${e.toString()} + ${e.message} + ${e.localizedMessage}")
                    Result.Error(
                        message = "인터넷에 연결되어 있지 않습니다.",
                        responseType = ResponseType.ROUTE_LINE_LIST,
                        httpExceptionCode = 0,
                        exceptionType = ExceptionType.UNKNOWN_ERROR
                    )
                }
            }
        }
        return result
    }

    override suspend fun getRouteInfo(origin: String, destination: String): Result<RouteInfo> {
        val result = try {
            val response =
                kakaoApi.getDistanceTime(
                    origin = origin,
                    destination = destination
                ).mapToRouteInfo()
            Result.Success(response, ResponseType.ROUTE_INFO)
        } catch (e: Exception) {
            when (e) {
                is HttpException -> e.httpExceptionError(ResponseType.ROUTE_INFO)
                else -> {
                    Result.Error(
                        message = "인터넷에 연결되어 있지 않습니다.",
                        responseType = ResponseType.ROUTE_INFO,
                        httpExceptionCode = 0,
                        exceptionType = ExceptionType.UNKNOWN_ERROR
                    )
                }
            }
        }
        return result
    }
}