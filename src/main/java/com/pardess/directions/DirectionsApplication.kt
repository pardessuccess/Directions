package com.pardess.directions

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.kakao.vectormap.KakaoMapSdk
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DirectionsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        KakaoMapSdk.init(this, Constants.KAKAO_MAP_KEY)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(AndroidLogAdapter())
        }
    }
}