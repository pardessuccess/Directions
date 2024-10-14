package com.pardess.directions.domain.usecase.route_info

import com.pardess.directions.domain.model.common.Result
import com.pardess.directions.domain.model.route_info.RouteInfo
import com.pardess.directions.domain.repository.KakaoApiRepository
import javax.inject.Inject

// 경로 정보를 가져오는 유스케이스 클래스
class GetRouteInfoUseCase @Inject constructor(
    private val kakaoApiRepository: KakaoApiRepository
) {
    suspend operator fun invoke(
        origin: String,
        destination: String
    ): Result<RouteInfo> {
        return kakaoApiRepository.getRouteInfo(
            origin = origin,
            destination = destination
        )
    }
}