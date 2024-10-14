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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pardess.directions.R
import com.pardess.directions.domain.model.route_list.Route
import com.pardess.directions.presentation.animation.LoadingAnimation
import com.pardess.directions.presentation.ui.theme.CardGray
import com.pardess.directions.presentation.ui.theme.LightBlue
import com.pardess.directions.presentation.ui.theme.LightGray
import com.pardess.directions.presentation.util.Utils.clickWithCoroutine
import com.pardess.directions.presentation.viewmodel.DirectionViewModel


// 경로 목록을 표시하는 바텀 시트를 구성하는 컴포저블 함수
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RouteBottomSheet(
    viewModel: DirectionViewModel,
    routeList: List<Route>,
    bottomSheetState: SheetState,
    isLoading: () -> Boolean,
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
                                LightGray.copy(0.4f)
                            )
                    )
                    if (routeList.isNotEmpty()) {
                        Box {
                            LazyColumn(
                                modifier = Modifier.background(
                                    LightGray.copy(0.4f)
                                )
                            ) {
                                items(routeList.size) { index ->
                                    // 경로 컴포넌트
                                    RouteComponent(
                                        { viewModel.routeSelected(index) },
                                        {
                                            Route(
                                                routeList[index].origin,
                                                routeList[index].destination,
                                            )
                                        },
                                    )
                                }
                            }
                        }
                    } else {
                        // 경로가 없을 때 경로 조회 메시지와 버튼
                        Box(modifier = Modifier.fillMaxSize()) {
                            Column(
                                modifier = Modifier.align(Alignment.Center),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = stringResource(R.string.no_route_list_text),
                                    fontSize = 22.sp
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick = {
                                        viewModel.updateRouteList()
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        contentColor = Color.White,
                                        containerColor = LightBlue
                                    )
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_refresh),
                                            contentDescription = stringResource(R.string.ic_refresh)
                                        )
                                        Text(
                                            text = stringResource(R.string.renew_route_list_button_text),
                                            fontSize = 22.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
            // 로딩 상태일 때 로딩 인디케이터 표시
            if (isLoading()) {
                LoadingAnimation(
                    loadingDelay = {
                        isLoading()
                    }
                )
            }
        }
    }
}

// 경로를 표시하는 컴포저블 카드 컴포넌트
@Composable
fun RouteComponent(
    onClick: () -> Unit,
    route: () -> Route,
) {

    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 12.dp),
        shape = RoundedCornerShape(
            22.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = CardGray,

            ),
        elevation = CardDefaults.cardElevation(3.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .clickWithCoroutine(coroutineScope) {
                onClick()
            }) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_car),
                    contentDescription = stringResource(R.string.ic_car),
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                // 출발지와 목적지를 텍스트로 표시
                Text(
                    text = route().origin + " → " + route().destination,
                    fontSize = 20.sp,
                )
            }
        }

    }
}
