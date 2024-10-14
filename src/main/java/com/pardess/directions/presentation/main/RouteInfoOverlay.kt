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
import com.pardess.directions.domain.model.route_info.RouteInfo
import com.pardess.directions.presentation.ui.theme.KakaoYellow
import com.pardess.directions.presentation.util.Utils
import com.pardess.directions.presentation.viewmodel.DirectionViewModel

// 경로 정보를 오버레이로 표시하는 컴포저블 함수
@Composable
fun RouteInfoOverlay(
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
                color = KakaoYellow,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = routeInfoPair.second,
            color = KakaoYellow,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = Utils.meterWithComma("직선 거리", straightDistance),
            color = KakaoYellow,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
