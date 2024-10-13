package com.pardess.directions.presentation.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.kakao.vectormap.MapView
import com.pardess.directions.R
import com.pardess.directions.presentation.DataState
import com.pardess.directions.presentation.component.ErrorAlertDialog
import com.pardess.directions.presentation.mapview.KakaoMapView
import com.pardess.directions.presentation.mapview.rememberMapViewWithLifecycle
import com.pardess.directions.presentation.ui.theme.DirectionsTheme
import com.pardess.directions.presentation.viewmodel.DirectionViewModel

@SuppressLint("PermissionLaunchedDuringComposition")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun DirectionApp(
    viewModel: DirectionViewModel,
    context: Context,
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    val mapView = rememberMapViewWithLifecycle(context, lifecycleOwner)

    val locationPermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
        )
    )

    var locationPermission by remember { mutableStateOf(false) }
    locationPermission = locationPermissionsState.allPermissionsGranted

    LaunchedEffect(Unit) {
        locationPermissionsState.launchMultiplePermissionRequest()
    }

    DirectionsTheme {
        Surface {
            var showBottomSheet by remember { mutableStateOf(false) }

            val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

            val straightDistance = viewModel.straightDistance

            val routeList = viewModel.routeList
            val routeInfo = viewModel.routeInfo
            val dataState = viewModel.dataState

            var showErrorDialog by remember { mutableStateOf(false) }

            when (dataState) {
                is DataState.Success -> {
                    if (viewModel.isRouteInfoSuccess && viewModel.isRouteLineListSuccess) {
                        showBottomSheet = false
                    }
                }
                is DataState.Error -> {
                    showErrorDialog = true
                }

                else -> {}
            }

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            if (!locationPermission){
                                Toast.makeText(context, "위치 권한을 허용해주세요.", Toast.LENGTH_SHORT).show()
                            }
                        },
                        shape = CircleShape,
                        containerColor = Color.White,
                        modifier = Modifier.padding(bottom = 5.dp)
                    ) {
                        if (locationPermission) {
                            Icon(
                                painter = painterResource(R.drawable.ic_location),
                                tint = Color(0xFF3D73FA),
                                contentDescription = "ic_location"
                            )
                        } else {
                            Icon(
                                painter = painterResource(R.drawable.ic_no_location),
                                tint = Color(0xFFBDBDBD).copy(0.5f),
                                contentDescription = "ic_location"
                            )
                        }
                    }
                }
            ) {
                Box(modifier = Modifier.padding(top = it.calculateTopPadding())) {
                    Column(
                        modifier = Modifier.align(Alignment.TopCenter)
                    ) {
                        SearchSection(
                            viewModel = viewModel,
                            onClick = {
                                showBottomSheet = true
                            }
                        )
                        KakaoMapView(
                            viewModel = viewModel,
                            mapView = mapView
                        )
                    }
                    RouteInfoOverlay(
                        viewModel = viewModel,
                        modifier = Modifier.align(Alignment.BottomStart),
                        straightDistance = straightDistance,
                        routeInfo = routeInfo
                    )

                    if (showErrorDialog) {
                        ErrorAlertDialog(
                            route = viewModel.route,
                            dataState = dataState as DataState.Error,
                            isRouteListSuccess = viewModel.isRouteListSuccess,
                            isRouteInfoSuccess = viewModel.isRouteInfoSuccess,
                            isRouteLineListSuccess = viewModel.isRouteLineListSuccess,
                            onDismiss = {
                                showErrorDialog = false
                            }
                        )
                    }

                    if (showBottomSheet) {
                        RouteBottomSheet(
                            viewModel = viewModel,
                            routeList = routeList,
                            bottomSheetState = bottomSheetState,
                            setBottomSheetState = {
                                showBottomSheet = false
                            }
                        )
                    }
                }
            }
            if (viewModel.isRouteListLoading || viewModel.isRouteInfoLoading || viewModel.isRouteLineListLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f)) // 배경 어둡게 처리
                        .pointerInput(Unit) {} // 터치 이벤트 차단
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = Color(0xFF5284FA)
                    )
                }
            }
        }
    }
}