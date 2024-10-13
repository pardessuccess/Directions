package com.pardess.directions.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pardess.directions.domain.model.Route
import com.pardess.directions.presentation.DataState

@Composable
fun ErrorAlertDialog(
    route: Route,
    dataState: DataState.Error,
    isRouteListSuccess: Boolean,
    isRouteInfoSuccess: Boolean,
    isRouteLineListSuccess: Boolean,
    onDismiss: () -> Unit
) {

    val errorTitle = when {
        !isRouteListSuccess -> "경로 리스트 조회 실패"
        !isRouteInfoSuccess && !isRouteLineListSuccess -> "경로, 정보 조회 실패"
        isRouteInfoSuccess && !isRouteLineListSuccess -> "경로 조회 실패"
        !isRouteInfoSuccess && isRouteLineListSuccess -> "정보 조회에 실패"
        else -> ""
    }

    val errorTextMessage = when {
        !isRouteListSuccess -> "경로 리스트 조회 실패했습니다."
        !isRouteInfoSuccess && !isRouteLineListSuccess -> "경로, 정보 조회에 실패했습니다."
        isRouteInfoSuccess && !isRouteLineListSuccess -> "경로 조회에 실패했습니다."
        !isRouteInfoSuccess && isRouteLineListSuccess -> "정보 조회에 실패했습니다."
        else -> ""
    }

    val errorCode = dataState.httpExceptionCode.toString()
    val errorMessage = dataState.message

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = errorTitle)
        },
        text = {
            Column {
                if (isRouteListSuccess) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(route.origin, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowForward,
                            tint = Color.Black,
                            contentDescription = "Arrow Forward",
                        )
                        Text(route.destination, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                    }
                }
                if (errorCode != "0") {
                    Text(text = "error code : $errorCode")
                }
                Text(text = "message : $errorMessage")
                Text(text = errorTextMessage)
            }
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text("확인")
            }
        }
    )
}