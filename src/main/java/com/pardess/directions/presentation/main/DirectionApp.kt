package com.pardess.directions.presentation.main

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.pardess.directions.presentation.component.ErrorAlertDialog
import com.pardess.directions.presentation.mapview.KakaoMapView
import com.pardess.directions.presentation.mapview.rememberMapViewWithLifecycle
import com.pardess.directions.presentation.ui.theme.DirectionsTheme
import com.pardess.directions.presentation.viewmodel.DirectionViewModel


// Direction 앱의 메인 화면을 구성하는 컴포저블 함수
@SuppressLint("PermissionLaunchedDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DirectionApp(
    viewModel: DirectionViewModel,
    context: Context,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val mapView = rememberMapViewWithLifecycle(context, lifecycleOwner)

    // 로딩 상태 설정
    var isLoading by remember { mutableStateOf(false) }
    isLoading =
        viewModel.isRouteListLoading || viewModel.isRouteInfoLoading || viewModel.isRouteLineListLoading

    DirectionsTheme {
        Surface {

            var showBottomSheet by remember { mutableStateOf(false) }
            var showErrorDialog by remember { mutableStateOf(false) }

            val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

            val straightDistance = viewModel.straightDistance

            val routeList = viewModel.routeList
            val routeInfo = viewModel.routeInfo

            var errorCheck by remember { mutableStateOf(false) }

            errorCheck =
                viewModel.errorCodeResult.first.isNotEmpty() || viewModel.errorCodeResult.second.isNotEmpty() || viewModel.errorCodeResult.third.isNotEmpty()

            if (errorCheck) {
                if (!showErrorDialog) {
                    showErrorDialog = true
                }
            }

            if (viewModel.isRouteListSuccess && viewModel.isRouteLineListSuccess && viewModel.isRouteInfoSuccess) {
                showBottomSheet = false
            }

            Scaffold(
                modifier = Modifier.fillMaxSize(),
            ) {
                Box(
                    modifier = Modifier.padding(
                        top = it.calculateTopPadding(),
                        bottom = it.calculateBottomPadding()
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .fillMaxSize()
                    ) {
                        // 검색 섹션
                        SearchSection(
                            viewModel = viewModel,
                            onClick = {
                                showBottomSheet = true
                            }
                        )
                        // Kakao 지도 뷰
                        KakaoMapView(
                            viewModel = viewModel,
                            mapView = mapView
                        )
                    }
                    // 경로 정보 오버레이 표시
                    RouteInfoOverlay(
                        modifier = Modifier.align(Alignment.BottomStart),
                        straightDistance = straightDistance,
                        routeInfo = routeInfo
                    )

                    // 오류 다이얼로그 표시
                    if (showErrorDialog) {
                        ErrorAlertDialog(
                            route = viewModel.route,
                            errorCode = viewModel.errorCodeResult,
                            errorMessage = viewModel.errorMessageResult,
                            isRouteListSuccess = viewModel.isRouteListSuccess,
                            onDismiss = {
                                showErrorDialog = false
                                viewModel.errorCodeResult = Triple("", "", "")
                                viewModel.errorMessageResult = Triple("", "", "")
                            }
                        )
                    }

                    // 바텀 시트 표시
                    if (showBottomSheet) {
                        RouteBottomSheet(
                            viewModel = viewModel,
                            routeList = routeList,
                            bottomSheetState = bottomSheetState,
                            isLoading = { isLoading },
                            setBottomSheetState = {
                                showBottomSheet = false
                            }
                        )
                    }
                }
            }
            if (isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Color.White.copy(0.5f)
                        )
                        .pointerInput(Unit) {}
                )
            }
        }
    }
}