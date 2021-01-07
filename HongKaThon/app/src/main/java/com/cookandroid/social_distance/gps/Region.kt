package com.cookandroid.social_distance.gps

enum class Region(val korean: String) {

    Incheon("인천"), Seoul("서울"), Gyeonggi("경기도"), Gangwon("강원도"), Busan("부산"), Daegu("대구"), Gwanju("광주"), Daejeon("대전"), Ulsan("울산"),
    Chungcheongbuk("충북"), Chungcheongnam("충남"), Jeollabuk("전북"), Jeollanam("전남"), Gyeongsangbuk("경북"), Gyeongsangnam("경남"), Jeju("제주도"), Sejong("세종"), Quarantine("검역소");

    companion object {
        fun getRegion(name: String): Region {
            return when(name) {
                "서울","서울특별시" -> {
                    Seoul
                }
                "인천","인천광역시" -> {
                    Incheon
                }
                "경기","경기도" -> {
                    Gyeonggi
                }
                "강원","강원도" -> {
                    Gangwon
                }
                "세종","세종특별시" -> {
                    Sejong
                }
                "충북","충청북도" -> {
                    Chungcheongbuk
                }
                "충남","충청남도" -> {
                    Chungcheongnam
                }
                "대전","대전광역시" -> {
                    Daejeon
                }
                "경북","경상북도" -> {
                    Gyeongsangbuk
                }
                "전북","전라북도" -> {
                    Jeollabuk
                }
                "대구","대구광역시" -> {
                    Daegu
                }
                "전남","전라남도" -> {
                    Jeollanam
                }
                "광주","광주광역시" -> {
                    Gwanju
                }
                "경남","경상남도" -> {
                    Gyeongsangnam
                }
                "울산","울산광역시" -> {
                    Ulsan
                }
                "부산","부산광역시" -> {
                    Busan
                }
                "제주","제주특별자치도" -> {
                    Jeju
                }
                "검역" -> {
                    Quarantine
                }
                else -> {
                    throw IllegalStateException("존재하지 않는 지역 : $name")
                }
            }
        }
    }
}