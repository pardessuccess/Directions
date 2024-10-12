package com.pardess.directions.presentation.main

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
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pardess.directions.R
import com.pardess.directions.data.response.location.Location
import com.pardess.directions.domain.model.Route
import com.pardess.directions.not_use.clickWithCoroutine
import com.pardess.directions.presentation.viewmodel.DirectionViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RouteBottomSheet(
    viewModel: DirectionViewModel,
    locationList: List<Location>,
    bottomSheetState: SheetState,
    setBottomSheetState: (Boolean) -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = {
            setBottomSheetState(false)
        },
        sheetState = bottomSheetState,
        dragHandle = null,
        modifier = Modifier.statusBarsPadding(),
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
                            .height(22.dp)
                            .fillMaxWidth()
                            .background(
                                Color(0xFF454545).copy(0.4f)
                            )
                    )
                    LazyColumn(
                        modifier = Modifier.background(
                            Color(0xFF454545).copy(0.4f)
                        )
                    ) {
                        items(locationList.size) { index ->

                            val location = locationList[index]

                            DirectionComponent(
                                viewModel,
                                {
                                    println(location)
                                    viewModel.updateRouteInfo(
                                        location.origin,
                                        location.destination,
                                    )
                                    viewModel.updateRouteLineList(
                                        location.origin,
                                        location.destination,
                                    )
                                },
                                Route(
                                    locationList[index].origin,
                                    locationList[index].destination,
                                ),
                            )
//                            if (locationList.size == index + 1) {
//                                Spacer(
//                                    modifier = Modifier
//                                        .height(35.dp)
//                                        .fillMaxWidth()
//                                        .background(color = Color.Black.copy(0.5f))
//                                )
//                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DirectionComponent(
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
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 25.dp)
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