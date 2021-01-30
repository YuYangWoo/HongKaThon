# HongKaThon
# ✌ Topic 
: 코로나에 따른 정보제공, 단계별 지역별 시설 이용수칙
# ⚡ Key Features
- 단계별 주요시설 이용 시 이용수칙 제공
- 단계별 일반시설 이용 시 이용수칙 제공
- 공유하기 기능으로 유의사항 공유 제공
- 전국의 거리두기 단계 세부확인 기능 제공
- 전국의 확진자 현황 세부확인 기능 제공
- 선택한 지역의 확진자 현황과 거리두기 단계 위젯 제공
- 전국의 확진자 현황 위젯 제공
# 😊 Introduction
코로나 사회적 거리두기 단계별 유의사항과 확진자 현황을 앱&위젯으로 제공합니다.
![1](https://user-images.githubusercontent.com/59405161/105698338-16850600-5f49-11eb-9113-1e25cec6cc7f.png)
![2](https://user-images.githubusercontent.com/59405161/105698384-269ce580-5f49-11eb-8394-ae4d83361477.png)
# 👊 Package
### - adapter : 리사이클러뷰를 위한 Adapter Package
  - AreaAdapter : 각종 시설들을 RecyclerView로 뿌려주는 Adapter
  - InformationAdapter : 위젯 지역 선택시 나타나는 지역을 RecyclerView로 뿌려주는 Adapter
  - OptionAdapter : 환경설정 List를 RecyclerView로 뿌려주는 Adapter
### - base : 보일러 플레이트 코드를 없애기 위해 상속으로 코드를 줄인 Base Package
  - BaseActivity : Activity 상속을 위해 필요한 BaseActivity
  - BaseFragment : Fragment 상속을 위해 필요한 BaseFragment
  - BaseDialog : Dialog 상속을 위해 필요한 BaseDialog
  - BaseAdapter : Adapter 상속을 위해 필요한 BaseAdapter
  - BaseHolder : Holder 상속을 위해 필요한 BaseHolder
### - binding : Binding Adapter 사용을 위한 binding Package
  - BindingConversions : Binding Adapter를 사용해 Glide함수 구현
### - dialog : Dialog를 위한 Dialog Package
  - OptionDialog : 환경설정 List 클릭시 나타나는 Dialog
### - fragment : 각종 View를 나타내기위한 Fragment Package
  - InformationFragment : MainFragment의 View 클릭시 해당하는 시설의 사진과 해당하는 단계의 이용수칙을 보여주고 1~3단계까지 ViewPager로 이동가능하다. 공유하기로 친구들과 공유 가능
  - MainFragment : 각종 시설의 사진과 이름을 RecyclerView로 뿌려주고 현재 자신의 위치를 기반으로 몇 단계의 사회적 거리두기 지침을 준수해야하는지 가르쳐준다.
  - MapFragment : 지역별 사회적 거리두기 단계 확인 기능과 지역변 확진자 현황을 확인할 수 있다.
  - OptionFragment : 앱 버전, 오픈소스 라이선스, 위치정보 서비스 약관, 앱 설명 및 사용방법등을 확인 할 수 있다.
### - gps : 사용자 위치를 얻고 주소로 가공하는 GpsTracker와 enum class로 지역을 얻을 수 있는 Region Gps Package
  - GpsTracker :  사용자의 위치를 받아 지오코더로 현재 주소로 변환해준다
  - Region : 서울, 서울특별시와 같이 지역 이름을 여러 형식으로 표현할 수 있는데, 하나의 형식으로 표현하기 위한 enum classd이다.
### - item : Data Class를 저장한 Item Package
  - AreaItem : 각종 시설의 정보를 가지는 Data Class이다.
  - OptionItem : 환경설정의 정보를 가지는 Data Class이다.
### - singleton : 싱글턴 패턴 사용을 위한 Singleton Package
  - AreaFactory : 파이어베이스의 데이터를 가져오는 싱글턴 AreaFactory
  - CoronaData : 보건복지부에서 Data를 받아오는 object이다. Jsoup를 이용하여 보건복지부에서 Data를 받아오고 Coroutine을 통해 앱 시작시 백그라운드로 Data를 받아오고 Data를 사용할 때 비동기처리된 함수를 사용하여 쉽게 사용할 수 있다.
  - view : Jsoup을 사용해 확진자 현황과 전국 거리두기 단계를 파싱하는 View Package
  - MapView : WebView를 상속받은 View로 보건복지부에서 CoronaMap만 받아와서 보여준다. 거리두기 단계표시와 감염자 현황을 보여주는 2개의 함수를 제공한다.
### - widget : 지역의 확진자현황과 단계, 전국의 확진자현황 위젯을 만드는 Widget Package
  - CountryInformationWidget : 대한민국 코로나 현황을 알려주는 위젯
  - RegionInformationWidget : 지역별 코로나 현황을 알려주는 위젯
### - root : Activity와 CubePageTransformer
  - SplashActivity : Splash화면으로 사용자에게 위치정보 사용 권한을 요청한다.
  - MainActivity : Navigation Drawer를 구현하였고 NavController를 사용해 Activity에 Fragment를 붙였다.
  - WidgetActivity : RegionInformationWidget을 생성시 설정하는 Activity. 지역을 선택할 수 있다.
  - CubePageTransformer
## 🐔  Languages & IDE
- App : Kotlin & Android Studio
- DB : Firebase
## 🐖  Environment
-   Operating System : Window10 64bit
-   CPU : I5-8265U
-   RAM : 8GB
# Team 
- 팀명 : Carry
- 팀원 : 유양우, 강태종


