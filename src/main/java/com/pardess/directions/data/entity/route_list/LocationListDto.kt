package com.pardess.directions.data.entity.route_list

import com.google.gson.annotations.SerializedName

data class LocationListDto(

    @SerializedName("locations") // 위치 목록 필드
    val locations: List<Location>

)