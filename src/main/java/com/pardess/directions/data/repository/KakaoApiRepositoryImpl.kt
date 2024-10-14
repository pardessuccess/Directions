package com.pardess.directions.data.repository

import com.pardess.directions.domain.model.common.Result
import com.pardess.directions.data.mapper.DataMapper.mapToRoute
import com.pardess.directions.data.mapper.DataMapper.mapToRouteInfo
import com.pardess.directions.data.mapper.DataMapper.mapToRouteLine
import com.pardess.directions.data.network.KakaoApi
import com.pardess.directions.data.util.ErrorUtils.exceptionError
import com.pardess.directions.data.util.ErrorUtils.httpExceptionError
import com.pardess.directions.domain.model.common.ResponseType
import com.pardess.directions.domain.model.route_list.Route
import com.pardess.directions.domain.model.route_info.RouteInfo
import com.pardess.directions.domain.model.route_line_list.RouteLine
import com.pardess.directions.domain.repository.AppContextRepository
import com.pardess.directions.domain.repository.KakaoApiRepository
import retrofit2.HttpException
import javax.inject.Inject

// Kakao API와의 데이터 처리 구현체
class KakaoApiRepositoryImpl @Inject constructor(
    private val kakaoApi: KakaoApi,
    private val appContextRepository: AppContextRepository
) : KakaoApiRepository {

    // 경로 목록을 가져오는 함수
    override suspend fun getRouteList(): Result<List<Route>> {
        val result = try {
            val response = kakaoApi.getLocations().mapToRoute()
            Result.Success(response, ResponseType.ROUTE_LIST)
        } catch (exception: Exception) {
            when (exception) {
                is HttpException -> exception.httpExceptionError(ResponseType.ROUTE_LIST)
                else ->
                    exceptionError(
                        appContextRepository = appContextRepository,
                        responseType = ResponseType.ROUTE_LIST
                    )
            }
        }
        return result
    }

    // 경로 라인 목록을 가져오는 함수
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
        } catch (exception: Exception) {
            when (exception) {
                is HttpException -> exception.httpExceptionError(ResponseType.ROUTE_LINE_LIST)
                else ->
                    exceptionError(
                        appContextRepository = appContextRepository,
                        responseType = ResponseType.ROUTE_LINE_LIST
                    )
            }
        }
        return result
    }

    // 경로 정보 (거리 및 시간)를 가져오는 함수
    override suspend fun getRouteInfo(origin: String, destination: String): Result<RouteInfo> {
        val result = try {
            val response =
                kakaoApi.getDistanceTime(
                    origin = origin,
                    destination = destination
                ).mapToRouteInfo()
            Result.Success(response, ResponseType.ROUTE_INFO)
        } catch (exception: Exception) {
            when (exception) {
                is HttpException -> exception.httpExceptionError(ResponseType.ROUTE_INFO)
                else ->
                    exceptionError(
                        appContextRepository = appContextRepository,
                        responseType = ResponseType.ROUTE_INFO
                    )
            }
        }
        return result
    }
}