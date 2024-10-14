package com.pardess.directions.domain.repository

import com.kakao.vectormap.label.LabelTextStyle
import com.kakao.vectormap.route.RouteLineStyle

// 앱 컨텍스트 관련 기능을 제공하는 인터페이스
interface AppContextRepository {

    // 문자열 리소스를 가져오는 함수
    fun getStringResource(id: Int): String

    // 라벨 스타일을 설정하는 함수
    fun setLabelStyle(id: Int): LabelTextStyle

    // 경로 라인 스타일을 설정하는 함수
    fun setRouteLineStyle(id: Int): RouteLineStyle

}
