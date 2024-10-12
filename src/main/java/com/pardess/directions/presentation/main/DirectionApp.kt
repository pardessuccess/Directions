package com.pardess.directions.presentation.main

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.orhanobut.logger.Logger
import com.pardess.directions.R
import com.pardess.directions.data.response.location.Location
import com.pardess.directions.domain.model.Route
import com.pardess.directions.not_use.clickWithCoroutine
import com.pardess.directions.presentation.DataState
import com.pardess.directions.presentation.component.ErrorAlertDialog
import com.pardess.directions.presentation.mapview.KakaoMapView
import com.pardess.directions.presentation.mapview.rememberMapViewWithLifecycle
import com.pardess.directions.presentation.ui.theme.DirectionsTheme
import com.pardess.directions.presentation.viewmodel.DirectionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DirectionApp(
    viewModel: DirectionViewModel,
    context: Context,
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val mapView = rememberMapViewWithLifecycle(context, lifecycleOwner)

    DirectionsTheme {

        Surface {
            var showBottomSheet by remember { mutableStateOf(false) }

            val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

            val straightDistance = viewModel.straightDistance

            val locationList = viewModel.locationList
            val routeInfo = viewModel.routeInfo

            val dataState = viewModel.dataState

            var showErrorDialog by remember { mutableStateOf(false) }

            if (dataState is DataState.Success) {
                Logger.d("dataState$dataState")
                showBottomSheet = false
            } else if (dataState is DataState.Error) {
                showErrorDialog = true
            }

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                floatingActionButton = {
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
                        if (dataState is DataState.Error) {
                            ErrorAlertDialog(
                                errorCode = dataState.errorCode.toString(),
                                errorMessage = dataState.message,
                                route = viewModel.route,
                                onDismiss = {
                                    showErrorDialog = false
                                }
                            )
                        }
                    }

                    if (showBottomSheet) {
                        RouteBottomSheet(
                            viewModel = viewModel,
                            locationList = locationList,
                            bottomSheetState = bottomSheetState,
                            setBottomSheetState = {
                                showBottomSheet = false
                            }
                        )
                    }
                }
            }
        }
    }
}