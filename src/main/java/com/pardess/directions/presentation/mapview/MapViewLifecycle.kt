package com.pardess.directions.presentation.mapview

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.kakao.vectormap.MapView
import com.kakao.vectormap.graphics.IMapSurfaceView

// 라이프사이클을 고려하여 제작한 MapView 컴포저블 함수
@Composable
fun rememberMapViewWithLifecycle(context: Context, lifecycleOwner: LifecycleOwner): MapView {
    val mapView = remember { MapView(context) }

    DisposableEffect(lifecycleOwner) {
        val lifecycle = lifecycleOwner.lifecycle
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> {
                }

                Lifecycle.Event.ON_START -> {}
                Lifecycle.Event.ON_RESUME -> {
                    if (mapView.surfaceView != null) {
                        mapView.resume() // MapView 재개
                    }
                }
                Lifecycle.Event.ON_PAUSE -> {
                    mapView.pause() // MapView 일시 정지
                }
                Lifecycle.Event.ON_STOP -> {}
                Lifecycle.Event.ON_DESTROY -> {
                    mapView.finish() // MapView 종료
                }
                Lifecycle.Event.ON_ANY -> {}
            }
        }

        lifecycle.addObserver(observer)

        onDispose {
            lifecycle.removeObserver(observer)
            mapView.finish() // 컴포저블이 제거될 때 MapView 종료
        }
    }
    return mapView
}