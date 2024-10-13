package com.pardess.directions.domain.usecase.location

import com.pardess.directions.data.Result
import com.pardess.directions.data.response.location.LocationListDto
import com.pardess.directions.domain.model.Route
import com.pardess.directions.domain.repository.KakaoApiRepository
import javax.inject.Inject


class GetRouteListUseCase @Inject constructor(
    private val kakaoApiRepository: KakaoApiRepository
) {
    suspend operator fun invoke(): Result<List<Route>> {
        return kakaoApiRepository.getRouteList()
    }
}