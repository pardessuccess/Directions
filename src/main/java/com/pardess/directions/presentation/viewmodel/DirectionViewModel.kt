package com.pardess.directions.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orhanobut.logger.Logger
import com.pardess.directions.data.Result
import com.pardess.directions.data.response.location.Location
import com.pardess.directions.domain.model.Route
import com.pardess.directions.domain.model.RouteInfo
import com.pardess.directions.domain.model.RouteLine
import com.pardess.directions.domain.usecase.distance_time.GetRouteInfoUseCase
import com.pardess.directions.domain.usecase.location.GetRouteListUseCase
import com.pardess.directions.domain.usecase.route.GetRouteLineListUseCase
import com.pardess.directions.presentation.DataState
import com.pardess.directions.presentation.SuccessType
import com.pardess.directions.presentation.util.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DirectionViewModel @Inject constructor(
    private val getRouteListUseCase: GetRouteListUseCase,
    private val getRouteLineListUseCase: GetRouteLineListUseCase,
    private val getRouteInfoUseCase: GetRouteInfoUseCase
) : ViewModel() {

    var dataState by mutableStateOf<DataState>(DataState.Ready())
        set

    init {
        updateRouteList()
        dataState = DataState.Loading()
    }

    var straightDistance by mutableIntStateOf(0)
        set

    var route by mutableStateOf(Route("", ""))
        set

    var locationList by mutableStateOf<List<Location>>(emptyList())
        private set

    private fun updateRouteList() = viewModelScope.launch {
        val data = getRouteListUseCase()
        Logger.d(data.data.toString())
        if (data is Result.Success) {
            locationList = data.data!!.locations
            dataState = DataState.Success(
                successType = SuccessType.ROUTE_LIST
            )
        } else {
            locationList = emptyList()
            dataState =
                DataState.Error(data.message.toString(), data.errorCode, data.errorType)
        }
    }

    var routeInfo by mutableStateOf(RouteInfo(0, 0, 0, 0))
        private set

    fun updateRouteInfo(origin: String, destination: String) = viewModelScope.launch {
        dataState = DataState.Loading()
        val data = getRouteInfoUseCase(origin = origin, destination = destination)
        Logger.d(data.toString())
        route = Route(origin, destination)
        if (data is Result.Success) {
            routeInfo = data.data!!
            dataState = DataState.Success(
                successType = SuccessType.ROUTE_INFO
            )
        } else {
            straightDistance = 0
            routeLineList = emptyList()
            routeInfo = RouteInfo(0, 0, 0, 0)
            dataState = DataState.Error(data.message.toString(), data.errorCode, data.errorType)
        }
    }

    var routeLineList by mutableStateOf<List<RouteLine>>(emptyList())
        private set

    fun updateRouteLineList(origin: String, destination: String) = viewModelScope.launch {
        dataState = DataState.Loading()
        val data = getRouteLineListUseCase(origin = origin, destination = destination)
        Logger.d(data.toString())
        println("@@@@@@@@@ updateRouteLineList")
        if (data is Result.Success) {
            routeLineList = data.data!!
            straightDistance = Utils.haversine(
                data.data.first().wayList.first(),
                data.data.last().wayList.last()
            )
            dataState = DataState.Success(
                successType = SuccessType.ROUTE_LINE_LIST
            )
        } else {
            straightDistance = 0
            routeLineList = emptyList()
            routeInfo = RouteInfo(0, 0, 0, 0)
            dataState = DataState.Error(data.message.toString(), data.errorCode, data.errorType)
        }
    }
}