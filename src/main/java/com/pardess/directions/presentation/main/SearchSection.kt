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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pardess.directions.R
import com.pardess.directions.presentation.viewmodel.DirectionViewModel

@Composable
fun SearchSection(
    viewModel: DirectionViewModel,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color(0xFF3D73FA)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = modifier
                .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 10.dp)
                .fillMaxWidth(0.7f)
        ) {
            Column(
                modifier = Modifier
                    .background(Color(0xFF5284FA), shape = RoundedCornerShape(5.dp))

            ) {
                var origin = viewModel.route.origin
                var destination = viewModel.route.destination

                val isEmpty = viewModel.route.origin.isEmpty()

                var textColor = Color(0xFFFFFFFF)

                if (isEmpty) {
                    origin = "출발지"
                    destination = "도착지"
                    textColor = Color(0xFFFFFFFF).copy(0.7f)
                }

                Text(
                    text = origin, color = textColor,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                    fontSize = 17.sp,
                )
                Spacer(
                    modifier = Modifier
                        .height(1.5.dp)
                        .fillMaxWidth()
                        .background(Color(0xFF3D73FA))
                )
                Text(
                    text = destination, color = textColor,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                    fontSize = 17.sp,
                )
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onClick()
                }
                .background(
                    Color(0xFF5284FA),
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(7.dp),
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Icon(
                    painter = painterResource(R.drawable.ic_direction),
                    contentDescription = "ic_direction",
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
                Spacer(Modifier.height(2.dp))
                Text(
                    text = "길찾기",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
        Spacer(
            modifier = Modifier.width(16.dp)
        )
    }
}
