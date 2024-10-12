package com.pardess.directions.presentation.mapview

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.kakao.vectormap.MapView

@Composable
fun rememberMapViewWithLifecycle(context: Context, lifecycleOwner: LifecycleOwner): MapView {
    val mapView = remember {
        MapView(context)
    }

    DisposableEffect(lifecycleOwner) {
        val lifecycle = lifecycleOwner.lifecycle
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> {}
                Lifecycle.Event.ON_START -> {}
                Lifecycle.Event.ON_RESUME -> {
                    println("@@@@@ON RESUME")
                    mapView.resume()
                }

                Lifecycle.Event.ON_PAUSE -> {
                    mapView.pause()
                }

                Lifecycle.Event.ON_STOP -> {}
                Lifecycle.Event.ON_DESTROY -> {
                    mapView.finish()
                }

                Lifecycle.Event.ON_ANY -> {}
            }
        }

        lifecycle.addObserver(observer)

        onDispose {
            lifecycle.removeObserver(observer)
            mapView.finish()
        }
    }
    return mapView
}