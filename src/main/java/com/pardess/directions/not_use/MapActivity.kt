package com.pardess.directions.not_use

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.MapView
import com.kakao.vectormap.label.LabelLayer
import com.kakao.vectormap.route.RouteLine
import com.kakao.vectormap.route.RouteLineLayer
import com.pardess.directions.data.response.distance_time.RouteInfoDto
import com.pardess.directions.databinding.ActivityMainBinding


//@AndroidEntryPoint
class MapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mapView: MapView
    private lateinit var kakaoMap: KakaoMap
    private lateinit var layer: RouteLineLayer
    private lateinit var multiStyleLine: RouteLine
    private lateinit var labelLayer: LabelLayer
    private val duration = 500

    private var routeInfo = RouteInfoDto(-1, -1)

    private var second = 32652L
    private var distance = 24427L

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
//
////        routeInfo = intent.getParcelableExtra("route_info", RouteInfoDto::class.java)!!
////        routeList = intent.getStringExtra("path_list")!!
//
//        println("@@@@$routeInfo")
//
//        initView()
//    }
//
//    private fun meterWithComma(number: Long): String {
//        val distanceString = StringBuilder("거리 : ")
//        distanceString.append(String.format("%,d", number))
//        distanceString.append("m")
//
//        return distanceString.toString().trim()
//    }
//
//    private fun secondsToTime(seconds: Long): String {
//        val hours = seconds / 3600
//        val minutes = (seconds % 3600) / 60
//        val remainingSeconds = seconds % 60
//
//        val timeString = StringBuilder("소요 시간 : ")
//
//        if (hours > 0) {
//            timeString.append(String.format("%d시간 ", hours))
//        }
//
//        if (minutes > 0) {
//            timeString.append(String.format("%1d분 ", minutes))
//        }
//
//        timeString.append(String.format("%1d초", remainingSeconds))
//
//        return timeString.toString().trim()
//    }
//
//    private fun initView() = with(binding) {
//
//        timeTextView.text = secondsToTime(second)
//        distanceTextView.text = meterWithComma(distance)
//
//        mapView = kakaoMapView
//        mapView.start(object : MapLifeCycleCallback() {
//            override fun onMapDestroy() {
//                // 지도 API 가 정상적으로 종료될 때 호출됨
//            }
//
//            override fun onMapError(error: Exception) {
//                // 인증 실패 및 지도 사용 중 에러가 발생할 때 호출됨
//            }
//        }, object : KakaoMapReadyCallback() {
//            override fun onMapReady(map: KakaoMap) {
//                // 인증 후 API 가 정상적으로 실행될 때 호출됨
//                kakaoMap = map
//                labelLayer = kakaoMap.labelManager!!.layer!!
//                layer = kakaoMap.routeLineManager!!.layer
//
//                val routeSegmentList = mutableListOf<RouteLineSegment>()
//
//                Route.SampleBigData.forEach {
//                    var style = -1
//                    when (it.trafficState) {
//                        "UNKNOWN" -> {
//                            style = R.style.UnknownRouteLineStyle
//                        }
//
//                        "JAM" -> {
//                            style = R.style.JamRouteLineStyle
//                        }
//
//                        "DELAY" -> {
//                            style = R.style.DelayRouteLineStyle
//                        }
//
//                        "SLOW" -> {
//                            style = R.style.SlowRouteLineStyle
//                        }
//
//                        "NORMAL" -> {
//                            style = R.style.NormalRouteLineStyle
//                        }
//
//                        "BLOCK" -> {
//                            style = R.style.BlockRouteLineStyle
//                        }
//
//                    }
//                    val routeLineStyle = RouteLineStyle.from(
//                        baseContext,
//                        style
//                    )
//                    routeSegmentList.add(
//                        RouteLineSegment.from(it.wayList, routeLineStyle)
//                    )
//                }
//
//                val options = RouteLineOptions.from(
//                    routeSegmentList
//                )
//
//                multiStyleLine = layer.addRouteLine(options)
//
//                //
//
//                setLabelWithText(
//                    "start_label",
//                    "출발",
//                    routeSegmentList[0].lats[0],
//                    routeSegmentList[0].lngs[0]
//                )
//
//                setLabelWithText(
//                    "end_label",
//                    "도착",
//                    routeSegmentList.last().lats.last(),
//                    routeSegmentList.last().lngs.last()
//                )
//
//                kakaoMap.moveCamera(
//                    CameraUpdateFactory.newCenterPosition(
//                        LatLng.from(37.55595957732287, 126.97227318174524), 16
//                    )
//                )
//            }
//        })
//    }
//
//    private fun setLabelWithText(labelId: String, text: String, lat: Double, lng: Double) {
//
//        val pos = LatLng.from(lat, lng)
//
//        val (markerIcon, textStyle) = when (text) {
//            "출발" -> {
//                R.style.labelTextStyle_1
//            }
//
//            "도착" -> {
//                R.drawable.blue_marker
//                R.style.labelTextStyle_2
//            }
//
//            else -> {
//                R.drawable.green_marker
//                R.style.labelTextStyle_1
//            }
//        }
//
//        println(markerIcon)
//        println(textStyle)
//
//        val styles = kakaoMap.labelManager
//            ?.addLabelStyles(
//                LabelStyles.from(
//                    LabelStyle.from(
//
//                        R.drawable.pink_marker
//                    ).setTextStyles(
//                        LabelTextStyle.from(baseContext, R.style.labelTextStyle_1),
//                        LabelTextStyle.from(baseContext, R.style.labelTextStyle_2)
//                    )
//                        .setIconTransition(LabelTransition.from(Transition.None, Transition.None))
//                )
//            )
//
//        labelLayer.addLabel(
//            LabelOptions.from(labelId, pos).setStyles(styles)
//                .setTexts(
//                    LabelTextBuilder().setTexts(
//                        text, "123-4567",
//                        "(\uD83C\uDF08\uD83D\uDC25\uD83C\uDF7B\uD83C\uDF57)"
//                    )
//                )
//        )
//        kakaoMap.moveCamera(
//            CameraUpdateFactory.newCenterPosition(pos, 15),
//            CameraAnimation.from(duration)
//        )
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        mapView.finish()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        mapView.resume()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        mapView.pause()
//    }
}

