package com.pardess.directions.data.entity.route_line_list

import com.google.gson.annotations.SerializedName

data class RouteListDtoItem(
    @SerializedName("points") // 경로의 좌표 정보 필드
    val points: String,
    @SerializedName("traffic_state") // 교통 상태 정보 필드
    val trafficState: String
)