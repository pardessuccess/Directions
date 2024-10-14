package com.pardess.directions.data.entity.route_info

import com.google.gson.annotations.SerializedName

data class RouteInfoDto(

    @SerializedName("distance") // 거리 정보 필드
    val distance: Int,

    @SerializedName("time") // 시간 정보 필드
    val time: Int

)
