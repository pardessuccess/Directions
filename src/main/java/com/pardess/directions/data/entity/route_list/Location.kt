package com.pardess.directions.data.entity.route_list

import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("destination") // 목적지 필드
    val destination: String,

    @SerializedName("origin") // 출발지 필드
    val origin: String

)