package com.pardess.directions.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pardess.directions.R
import com.pardess.directions.domain.model.route_list.Route
import com.pardess.directions.domain.model.common.DataState

// 오류 발생 시 경고 다이얼로그를 표시하는 컴포저블 함수
@Composable
fun ErrorAlertDialog(
    route: Route,
    errorCode: Triple<String, String, String>,
    errorMessage: Triple<String, String, String>,
    isRouteListSuccess: Boolean,
    onDismiss: () -> Unit
) {

    // 오류 타이틀 설정
    val errorTitle = when {
        errorCode.first.isNotEmpty() -> stringResource(R.string.route_list_fail_title)
        errorCode.second.isNotEmpty() && errorCode.third.isNotEmpty() -> stringResource(R.string.route_line_list_and_route_info_fail_title)
        errorCode.second.isEmpty() && errorCode.third.isNotEmpty() -> stringResource(R.string.route_line_fail_title)
        errorCode.second.isNotEmpty() && errorCode.third.isEmpty() -> stringResource(R.string.route_info_fail_title)
        else -> ""
    }

    // 오류 메시지 설정
    val errorTextMessage = when {
        errorCode.first.isNotEmpty() -> stringResource(R.string.route_list_fail_message)
        errorCode.second.isNotEmpty() && errorCode.third.isNotEmpty() -> stringResource(R.string.route_line_and_route_info_fail_message)
        errorCode.second.isEmpty() && errorCode.third.isNotEmpty() -> stringResource(R.string.route_line_fail_message)
        errorCode.second.isNotEmpty() && errorCode.third.isEmpty() -> stringResource(R.string.route_info_fail_message)
        else -> ""
    }

    val errorCodeFirst = errorCode.first
    val errorCodeSecond = errorCode.second
    val errorCodeThird = errorCode.third // 오류 코드

    val errorMessageFirst = errorMessage.first
    val errorMessageSecond = errorMessage.second
    val errorMessageThird = errorMessage.third // 오류 메시지

    // 경고 다이얼로그 설정
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = errorTitle)
        },
        text = {
            Column {
                // 경로 정보 표시
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
                // 오류 코드 및 메시지 표시
                if (errorCodeFirst.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(stringResource(R.string.get_route_list_text), fontWeight = FontWeight.SemiBold)
                    Text(text = "error code : $errorCodeFirst")
                    Text(text = "message : $errorMessageFirst")
                }
                if (errorCodeSecond.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(stringResource(R.string.get_route_info_text), fontWeight = FontWeight.SemiBold)
                    Text(text = "error code : $errorCodeSecond")
                    Text(text = "message : $errorMessageSecond")
                }
                if (errorCodeThird.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(stringResource(R.string.get_route_line_list_text), fontWeight = FontWeight.SemiBold)
                    Text(text = "error code : $errorCodeThird")
                    Text(text = "message : $errorMessageThird")
                }
                Text(text = errorTextMessage)
            }
        },
        confirmButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(stringResource(R.string.ok_text))
            }
        }
    )
}