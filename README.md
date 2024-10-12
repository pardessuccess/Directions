Clean Architecture 패턴으로 구성되어 있습니다.

data

- di
1. ApiModule
KakaoApiRespository에 의존성 주입
2. NetworkModule
KakaoApi, KakaoApiInstance, okHttp3 등 네트워크 관련 클래스 의존성 주입

- mapper
data entity -> domain model 로 데이터를 변환하여, 매핑
1. DataMapper
fun mapToWayLine()
경로 좌표들을 받아와, Latitude, Longitude로 변환한 뒤, 리스트로 매핑해줍니다. 또한
String 값으로 넘어온 도로 상태를 Enum Class TrafficState를 통기 분기하여 매핑합니다.

fun mapToRouteInfo()
초 단위로 받아온 소요 시간, m 단위로 받아온 거리를 시간, 분, 초 단위로 분기하여 매핑합니다.

- network
KakaoApi
모든 함수들의 @Header에는 Authorization ("KAKAO_MOBILITY_KEY")이 자동으로 달려있습니다.
OkHttp를 통해 설정해주었습니다.

- repository
KakaoApiRepositoryImpl 구현체가 있습니다.
suspend를 통해 코루틴으로 값을 받아오고, Result 에 Success, Error로 분기하여 매핑해줍니다.
Http 에러 종류에 따라 다른 값을 에러에 넣고 저장합니다.

- response
Https 통신을 통해 받아온 Dto 및 데이터를 저장하는 곳 입니다.
  
- util
다양한 종류의 Exception을 분기해 Result.Error 로 리턴합니다.

- Result.kt
Success, Error

domain

- model
- repository
- usecase

presentation

Kakaoapi에서

총 세 가지의 함수를 호출하고 받아옵니다.

출발지 / 도착지 리스트 호출
경로를 담은 데이터 (경로 리스트, 도로 상황) 호출
경로 거리, 소요 시간 호출
받아온 값을 Resource 클래스를 통해, Success, Error 로 분기한 뒤, DataMapper로 dto -> domain 모델들과 매핑합니다.

출발지 / 도착지 리스트
경로를 담은 데이터 (경로 리스트, 도로 상황)
경로 거리, 소요 시간
를 모두 DirectionViewModel에 담고, mutableStateOf에서 변화하는 값들을 관찰하여 대응합니다.

NewActivity를 메인으로 한 One Activity 구조입니다. 모든 데이터들은 DirectionViewModel에서 다루고 있습니다.

KakaoMapView에서는 Compose로 구현된 카카오맵이 있습니다.

drawRouteLine 함수를 통해, 지도에 목적지, 도착지의 라벨과 경로를 그려줍니다.

DirectionApp 에서 NavigateInfoOverlay에서는 경로 거리, 소요 시간, 직선 거리를 적어줍니다. BottomSheetSection에서는 ModalBottomSheet 이 있고, 출발지 / 도착지 리스트를 나타냅니다.

사용기술 : Kakaomap, Retrofit, Okhttp3, Coroutine, Clean Architecture, Hilt, MVVM

*사용하지 않는 코드들은 not_use 패키지에 넣어져 있습니다.
