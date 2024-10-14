package com.pardess.directions.presentation.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pardess.directions.R
import kotlinx.coroutines.delay

// 로딩 애니메이션 컴포저블 함수
@Composable
fun LoadingAnimation(loadingDelay: () -> Boolean) {

    // 3개의 춘식이 애니메이션을 위한 Animatable 객체 리스트 생성
    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    // 각 원의 애니메이션 값을 가져오는 리스트
    val circleValues = circles.map { it.value }
    val distance = with(LocalDensity.current) { 15.dp.toPx() } // 애니메이션 이동 거리 설정
    val lastCircle = circleValues.size - 1

    // 로딩 상태가 true일 때 애니메이션 실행
    if (loadingDelay()) {
        circles.forEachIndexed { index, animatable ->
            LaunchedEffect(key1 = animatable) {
                delay(index * 200L) // 각 원의 애니메이션 시작 시간 지연
                animatable.animateTo(
                    targetValue = 1f,
                    animationSpec = infiniteRepeatable(
                        animation = keyframes {
                            durationMillis = 1200
                            0.0f at 0 using LinearOutSlowInEasing
                            1.0f at 300 using LinearOutSlowInEasing
                            0.0f at 600 using LinearOutSlowInEasing
                            0.0f at 1200 using LinearOutSlowInEasing
                        },
                        repeatMode = RepeatMode.Restart // 애니메이션을 반복하여 재시작
                    )
                )
            }
        }

        // 반투명한 배경을 가진 박스를 생성하여 로딩 애니메이션을 중앙에 배치
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White.copy(0.5f) // 반투명 흰색 배경 설정
                )
                .pointerInput(Unit) {} // 사용자 입력을 막기 위한 빈 pointerInput 설정
        ) {
            Row(modifier = Modifier.align(Alignment.Center)) {
                circleValues.forEachIndexed { index, value ->
                    Image(
                        painterResource(id = R.drawable.img_choonsik), // 원 대신 춘식이 사용
                        modifier = Modifier
                            .size(25.dp)
                            .graphicsLayer {
                                translationY = -value * distance // 애니메이션 값에 따라 Y축 이동
                            },
                        contentDescription = "loading item" // 접근성 설명 추가
                    )
                    if (index != lastCircle) {
                        Spacer(modifier = Modifier.width(5.dp)) // 원들 사이에 간격 추가
                    }
                }
            }
        }
    }
}