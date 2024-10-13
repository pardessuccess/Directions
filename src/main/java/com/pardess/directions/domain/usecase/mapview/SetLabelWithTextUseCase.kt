package com.pardess.directions.domain.usecase.mapview

import android.content.Context
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.camera.CameraAnimation
import com.kakao.vectormap.camera.CameraUpdateFactory
import com.kakao.vectormap.label.LabelLayer
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.label.LabelStyle
import com.kakao.vectormap.label.LabelStyles
import com.kakao.vectormap.label.LabelTextBuilder
import com.kakao.vectormap.label.LabelTextStyle
import com.kakao.vectormap.label.LabelTransition
import com.kakao.vectormap.label.Transition
import com.pardess.directions.R

class SetLabelWithTextUseCase(
    private val kakaoMap: KakaoMap,
    private val labelLayer: LabelLayer
) {
    private val duration = 500

    fun execute(
        context: Context,
        labelId: String,
        text: String,
        locationName: String,
        lat: Double,
        lng: Double
    ) {

        val pos = LatLng.from(lat, lng)

        val marker = when (text) {
            context.getString(R.string.origin_label_text) -> {
                Triple(
                    R.drawable.blue_marker,
                    LabelTextStyle.from(context, R.style.labelTextStyleBlack),
                    LabelTextStyle.from(context, R.style.labelTextStyleBlue)
                )
            }

            context.getString(R.string.destination_label_text) -> {
                Triple(
                    R.drawable.pink_marker,
                    LabelTextStyle.from(context, R.style.labelTextStyleBlack),
                    LabelTextStyle.from(context, R.style.labelTextStyleRed)
                )
            }

            else -> {
                Triple(
                    R.drawable.green_marker,
                    LabelTextStyle.from(context, R.style.labelTextStyleBlack),
                    LabelTextStyle.from(context, R.style.labelTextStyleBlue)
                )
            }
        }

        val styles = kakaoMap.labelManager
            ?.addLabelStyles(
                LabelStyles.from(
                    LabelStyle.from(
                        marker.first
                    ).setTextStyles(
                        marker.second,
                        marker.third
                    )
                        .setIconTransition(LabelTransition.from(Transition.None, Transition.None))
                )
            )
        labelLayer.addLabel(
            LabelOptions.from(labelId, pos).setStyles(styles)
                .setTexts(
                    LabelTextBuilder().setTexts(
                        text,
                        locationName,
                    )
                )
        )
        kakaoMap.moveCamera(
            CameraUpdateFactory.newCenterPosition(pos, 15),
            CameraAnimation.from(duration)
        )
    }
}