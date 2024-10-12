package com.pardess.directions.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pardess.directions.domain.model.Route

@Composable
fun ErrorAlertDialog(errorMessage: String, errorCode: String, route: Route, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(text = "경로 조회 실패")
        },
        text = {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(route.origin)
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowForward,
                        tint = Color.Black,
                        contentDescription = "Arrow Forward",
                    )
                    Text(route.destination)
                }
                Text(text = errorCode)
                Text(text = errorMessage)
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