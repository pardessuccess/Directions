package com.pardess.directions.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pardess.directions.R
import com.pardess.directions.presentation.ui.theme.KakaoBlue
import com.pardess.directions.presentation.ui.theme.LightBlue
import com.pardess.directions.presentation.ui.theme.White
import com.pardess.directions.presentation.viewmodel.DirectionViewModel

// 검색 섹션을 구성하는 컴포저블 함수
@Composable
fun SearchSection(
    viewModel: DirectionViewModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(KakaoBlue),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = modifier
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 10.dp)
                .fillMaxWidth(0.7f)
        ) {
            Column(
                modifier = Modifier
                    .background(LightBlue, shape = RoundedCornerShape(5.dp))
            ) {
                var origin = viewModel.route.origin
                var destination = viewModel.route.destination
                val isEmpty = viewModel.route.origin.isEmpty()

                var textColor = White

                if (isEmpty) {
                    origin = stringResource(R.string.hint_origin_text)
                    destination = stringResource(R.string.hint_destination_text)
                    textColor = White.copy(0.65f)
                }
                // 출발지 텍스트
                Text(
                    text = origin, color = textColor,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                    fontSize = 17.sp,
                )
                Spacer(
                    modifier = Modifier
                        .height(1.5.dp)
                        .fillMaxWidth()
                        .background(KakaoBlue)
                )
                // 도착지 텍스트
                Text(
                    text = destination, color = textColor,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                    fontSize = 17.sp,
                )
            }
        }
        // 길찾기 버튼
        Box(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onClick()
                }
                .background(
                    LightBlue,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(7.dp),
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(1.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_direction),
                    contentDescription = stringResource(R.string.ic_direction_text),
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
                Text(
                    text = stringResource(R.string.find_route_button_text),
                    color = Color.White,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(1.dp))
            }
        }
        Spacer(
            modifier = Modifier.width(16.dp)
        )
    }
}
