package com.pardess.directions.domain.usecase.route_line_list

import com.pardess.directions.domain.model.common.Result
import com.pardess.directions.domain.model.route_line_list.RouteLine
import com.pardess.directions.domain.repository.KakaoApiRepository
import javax.inject.Inject

// 경로 라인 목록을 가져오는 유스케이스 클래스
class GetRouteLineListUseCase @Inject constructor(
    private val kakaoApiRepository: KakaoApiRepository
) {
    suspend operator fun invoke(
        origin: String,
        destination: String
    ): Result<List<RouteLine>> {
        return kakaoApiRepository.getRouteLineList(
            origin = origin,
            destination = destination
        )
    }
}