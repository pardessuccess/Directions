package com.pardess.directions.domain.usecase.mapview

import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.label.LabelLayer
import com.kakao.vectormap.label.LabelOptions
import com.kakao.vectormap.label.LabelStyle
import com.kakao.vectormap.label.LabelStyles
import com.kakao.vectormap.label.LabelTextBuilder
import com.kakao.vectormap.label.LabelTransition
import com.kakao.vectormap.label.Transition
import com.pardess.directions.R
import com.pardess.directions.domain.repository.AppContextRepository
import javax.inject.Inject

// 라벨과 텍스트를 설정하고 추가하는 유스케이스 클래스
class SetLabelWithTextUseCase @Inject constructor(
    private val appContextRepository: AppContextRepository,
) {
    operator fun invoke(
        kakaoMap: KakaoMap,
        labelLayer: LabelLayer,
        labelId: String,
        labelText: String,
        routeName: String,
        latLng: LatLng,
    ) {
        // 라벨 텍스트에 따른 마커 및 스타일 설정
        val marker = when (labelText) {
            appContextRepository.getStringResource(R.string.origin_label_text) -> {
                Triple(
                    R.drawable.img_blue_marker,
                    appContextRepository.setLabelStyle(R.style.labelTextStyleBlack),
                    appContextRepository.setLabelStyle(R.style.labelTextStyleBlue),
                )
            }

            appContextRepository.getStringResource(R.string.destination_label_text) -> {
                Triple(
                    R.drawable.img_red_marker,
                    appContextRepository.setLabelStyle(R.style.labelTextStyleBlack),
                    appContextRepository.setLabelStyle(R.style.labelTextStyleRed),
                )
            }

            else -> {
                Triple(
                    R.drawable.img_green_marker,
                    appContextRepository.setLabelStyle(R.style.labelTextStyleBlack),
                    appContextRepository.setLabelStyle(R.style.labelTextStyleRed),
                )
            }
        }

        // 라벨 스타일 설정 및 추가
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
            LabelOptions.from(labelId, latLng).setStyles(styles)
                .setTexts(
                    LabelTextBuilder().setTexts(
                        labelText,
                        routeName,
                    )
                )
        )
    }
}