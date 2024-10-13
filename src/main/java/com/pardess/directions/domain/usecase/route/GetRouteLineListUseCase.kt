package com.pardess.directions.domain.usecase.route

import com.pardess.directions.data.Result
import com.pardess.directions.domain.model.RouteLine
import com.pardess.directions.domain.repository.KakaoApiRepository
import javax.inject.Inject

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