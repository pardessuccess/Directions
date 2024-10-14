package com.pardess.directions.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.pardess.directions.presentation.main.DirectionApp
import com.pardess.directions.presentation.viewmodel.DirectionViewModel
import dagger.hilt.android.AndroidEntryPoint

// 메인 액티비티 - 애플리케이션의 진입점
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    // DirectionViewModel 인스턴스 생성
    private val viewModel by viewModels<DirectionViewModel>()

    // 액티비티가 생성될 때 호출되는 함수
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        // 스플래시 스크린 설정
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = {
                // 로딩 상태에 따라 스플래시 스크린 표시 여부 결정
                viewModel.isRouteListLoading
            })
        }
        setContent {
            // DirectionApp 컴포저블 호출하여 화면 구성
            DirectionApp(
                viewModel = viewModel,
                context = applicationContext,
            )
        }
    }
}
