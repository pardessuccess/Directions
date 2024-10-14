카카오 길잡이

카카오 길잡이 애플리케이션은 Kakao Map SDK를 활용하여 내비게이션 기능을 제공하는 Android 애플리케이션입니다. 
사용자는 경로 정보, 거리 및 예상 소요 시간을 간편하게 확인할 수 있습니다. 
이 애플리케이션은 MVVM 아키텍처 패턴을 따르며 Jetpack Compose, Hilt 의존성 주입, Retrofit 등을 활용하여 개발되었습니다.

외부 라이브러리 : KakaoMap, Hilt, Retrofit, OkHttp3, Splash Api, Logger

주요 기능

1. 클린 아키텍쳐

Data 레이어: 네트워크 요청 등을 관리합니다. Retrofit을 사용하여 데이터를 가져오고, Gson과 DataMapper를 사용해 데이터를 파싱합니다.

Domain 레이어: 비즈니스 로직에서 사용되는 모델과 유스 케이스를 담고 있으며, 앱의 비즈니스 로직을 처리합니다.

Presentation 레이어: UI 구성 요소 및 뷰 모델을 포함합니다. MainActivity가 앱의 진입점이며, Jetpack Compose로 UI를 구성합니다.

2. Http 통신

서버와의 통신을 위해 Retrofit을 사용하였으며, OkHttp3를 통해 효율적으로 REST API 통신을 구현했습니다.

Interceptor를 활용하여 "Authorization" 헤더를 자동으로 주입하고, 네트워크 지연 테스트, 재시도(Retry), 로깅 및 연결 타임아웃(connectTimeout)을 설정했습니다.

서버에서 받은 데이터를 Coroutine으로 비동기 수신하고, Gson을 활용해 Json 데이터를 파싱하여 성공(Success) 및 오류(Error) 처리를 했습니다.

Entity 데이터를 비즈니스 로직에서 사용할 모델로 변환하기 위해 DataMapper를 사용했습니다.

3. 의존성 주입

Dagger 기반의 경량 프레임워크인 Hilt를 활용하여 자동으로 의존성을 주입했습니다. 
Retrofit, OkHttp3, Repository, KakaoApi 등을 Hilt로 주입하여 객체 간의 결합도를 낮추었습니다.

4. Jetpack Compose, MVVM
Jetpack Compose를 활용하여, MVVM 을 구현하였습니다.
Model(Repository) <-> ViewModel <-> UI(Jetpack Compose UI)

- UI와 로직을 분리하여 유지보수성을 높였습니다.
- 데이터 변화에 따른 UI를 자동으로 갱신하며, remember와 State를 통해 간편하게 상태를 관리했습니다.

5. Kakao Map 설계

Kakao Map을 활용하여 지도를 표시하고 경로를 그려주었습니다.

MapView는 MainActivity의 컨텍스트와 라이프사이클을 고려해 생성하였으며, rememberMapViewWithLifecycle을 사용해 라이프사이클 이벤트(onResume, onPause, onDestroy)를 처리했습니다.

서버에서 받은 데이터를 바탕으로 DrawRouteLineUseCase와 SetLabelWithTextUseCase를 통해 맵에 경로(RouteLine)와 라벨(Label)을 그렸습니다.

6. Utils, DataMapper

여러 코틀린 함수를 사용해 데이터를 처리하여, 비즈니스 로직에서 간단히 값만 가져와 사용할 수 있도록 하였습니다.
haversine: 두 지점 사이의 직선 거리를 계산하는 함수로, 하버사인 공식을 사용합니다.

7. Constants, BuildConfig

Constants 객체에 API 키와 기본 URL 등 애플리케이션 전체에서 사용되는 상수를 관리했습니다.

API 키는 local.properties 파일에 기록하고, 빌드 과정에서 BuildConfig에서만 참조할 수 있도록 했습니다.

8. Result, DataState

sealed 클래스를 활용하여 상태를 Success, Error, Ready(DataState)로 나누어 앱의 상태를 구분하였습니다.

Ready: 시스템이 네트워크 호출 준비가 되었음을 나타냅니다.
Success: 응답 타입을 포함하는 성공적인 네트워크 응답을 나타냅니다.
Error: 오류 메시지, 응답 타입, HTTP 예외 코드, 예외 타입을 포함하는 네트워크 호출의 오류를 나타냅니다.

시작하기

리포지토리 클론: 프로젝트를 로컬 환경으로 클론합니다.

API 키 설정: local.properties 파일을 생성하고 Kakao Map 및 Mobility API 키를 추가합니다.

빌드 및 실행: Android Studio에서 프로젝트를 열고, 에뮬레이터나 실제 기기에서 앱을 빌드하고 실행합니다.

사용 방법

앱 실행: Android 기기에서 Directions 앱을 엽니다.

지도 보기: 메인 화면에서 Kakao 지도가 표시됩니다.

경로 정보 확인: 앱과 상호작용하여 경로 정보(거리 및 예상 소요 시간 등)를 확인할 수 있습니다.

