package com.pardess.directions.domain.model.route_line_list

import com.pardess.directions.R

// 교통 상태를 정의하는 Enum 클래스 (각 상태에 대한 스타일 리소스 포함)
enum class TrafficState(val styleRes: Int) {
    UNKNOWN(R.style.UnknownRouteLineStyle), // 알 수 없는 상태
    JAM(R.style.JamRouteLineStyle), // 정체 상태
    DELAY(R.style.DelayRouteLineStyle), // 지연 상태
    SLOW(R.style.SlowRouteLineStyle), // 서행 상태
    NORMAL(R.style.NormalRouteLineStyle), // 정상 상태
    BLOCK(R.style.BlockRouteLineStyle) // 차단 상태
}