package com.pardess.directions.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pardess.directions.R
import com.pardess.directions.domain.model.Route
import com.pardess.directions.not_use.clickWithCoroutine
import com.pardess.directions.presentation.viewmodel.DirectionViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RouteBottomSheet(
    viewModel: DirectionViewModel,
    routeList: List<Route>,
    bottomSheetState: SheetState,
    setBottomSheetState: (Boolean) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = {
            setBottomSheetState(false)
        },
        sheetState = bottomSheetState,
        dragHandle = null,
        modifier = Modifier
            .statusBarsPadding()
            .padding(top = 90.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column {
                    Spacer(
                        modifier = Modifier
                            .height(16.dp)
                            .fillMaxWidth()
                            .background(
                                Color(0xFFE6E6E6).copy(0.4f)
                            )
                    )
                    if (routeList.isNotEmpty()) {
                        Box {
                            LazyColumn(
                                modifier = Modifier.background(
                                    Color(0xFFE6E6E6).copy(0.4f)
                                )
                            ) {
                                items(routeList.size) { index ->
                                    RouteComponent(
                                        viewModel,
                                        { viewModel.routeSelected(index) },
                                        Route(
                                            routeList[index].origin,
                                            routeList[index].destination,
                                        ),
                                    )
                                }
                            }
                        }
                    } else {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Column(
                                modifier = Modifier.align(Alignment.Center),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "경로가 없습니다.",
                                    fontSize = 22.sp
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick = {
                                        viewModel.updateRouteList()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color.White,
                                        containerColor = Color(0xFF5284FA)
                                    )
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_refresh),
                                            contentDescription = "refresh"
                                        )
                                        Text(
                                            text = "경로 다시 조회",
                                            fontSize = 22.sp
                                        )
                                    }
                                }
                            }
                        }
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

@Composable
fun RouteComponent(
    viewModel: DirectionViewModel,
    onClick: () -> Unit,
    route: Route,
) {

    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .clickWithCoroutine(coroutineScope) {
                onClick()
            },
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_car),
                contentDescription = "icon_car",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = route.origin,
                fontSize = 20.sp,
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "right arrow")
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = route.destination,
                fontSize = 20.sp
            )
        }
    }
}