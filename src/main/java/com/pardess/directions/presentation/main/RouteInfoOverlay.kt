package com.pardess.directions.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pardess.directions.domain.model.RouteInfo
import com.pardess.directions.presentation.util.Utils
import com.pardess.directions.presentation.viewmodel.DirectionViewModel

@Composable
fun RouteInfoOverlay(
    viewModel: DirectionViewModel,
    modifier: Modifier,
    straightDistance: Int,
    routeInfo: RouteInfo,
) {
    var routeInfoPair by remember { mutableStateOf(Utils.setRouteInfo(routeInfo)) }

    routeInfoPair = Utils.setRouteInfo(routeInfo)

    Column(
        modifier = modifier
            .width(220.dp)
            .padding(vertical = 10.dp, horizontal = 5.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Color.run { Gray.copy(0.85f) }
            )
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = routeInfoPair.first,
                color = Color(0xFFFFD700),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = routeInfoPair.second,
            color = Color(0xFFFFD700),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = Utils.meterWithComma("직선 거리", straightDistance),
            color = Color(0xFFFFD700),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
