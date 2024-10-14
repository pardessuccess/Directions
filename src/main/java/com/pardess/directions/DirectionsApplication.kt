package com.pardess.directions

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.kakao.vectormap.KakaoMapSdk
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.pardess.directions.common.Constants
import dagger.hilt.android.HiltAndroidApp

// Directions 애플리케이션 클래스 - 애플리케이션의 전역 설정을 담당
@HiltAndroidApp
class DirectionsApplication : Application() {

    // 애플리케이션이 생성될 때 호출되는 함수
    override fun onCreate() {
        super.onCreate()
        // Kakao Map SDK 초기화
        KakaoMapSdk.init(this, Constants.KAKAO_MAP_KEY)
        // 다크 모드 비활성화
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // 디버그 모드일 경우 Logger를 설정
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(AndroidLogAdapter())
        }
    }
}