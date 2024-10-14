package com.pardess.directions.data.repository

import android.content.Context
import com.kakao.vectormap.label.LabelTextStyle
import com.kakao.vectormap.route.RouteLineStyle
import com.pardess.directions.domain.repository.AppContextRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

// 앱 컨텍스트에 접근하는 구현체
class AppContextRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : AppContextRepository {

    // 문자열 리소스를 가져오는 함수
    override fun getStringResource(id: Int): String {
        return context.getString(id)
    }

    // 라벨 스타일을 설정하는 함수
    override fun setLabelStyle(id: Int): LabelTextStyle {
        return LabelTextStyle.from(context, id)
    }

    // 경로 라인 스타일을 설정하는 함수
    override fun setRouteLineStyle(id: Int): RouteLineStyle {
        return RouteLineStyle.from(context, id)
    }
}