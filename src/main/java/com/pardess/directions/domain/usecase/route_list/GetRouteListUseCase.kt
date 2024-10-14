package com.pardess.directions.domain.usecase.route_list

import com.pardess.directions.domain.model.common.Result
import com.pardess.directions.domain.model.route_list.Route
import com.pardess.directions.domain.repository.KakaoApiRepository
import javax.inject.Inject


// 경로 목록을 가져오는 유스케이스 클래스
class GetRouteListUseCase @Inject constructor(
    private val kakaoApiRepository: KakaoApiRepository
) {
    suspend operator fun invoke(): Result<List<Route>> {
        return kakaoApiRepository.getRouteList()
    }
}
