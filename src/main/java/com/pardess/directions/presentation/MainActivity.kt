package com.pardess.directions.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.pardess.directions.presentation.main.DirectionApp
import com.pardess.directions.presentation.viewmodel.DirectionViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<DirectionViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DirectionApp(
                viewModel = viewModel,
                context = this@MainActivity
            )
        }
    }
}