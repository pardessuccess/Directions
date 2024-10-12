Clean Architecture 패턴으로 구성되어 있습니다.

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
