package com.cookandroid.social_distance

enum class Region(val korean: String) {

    Incheon("인천"), Seoul("서울"), Gyeonggi("경기도"), Gangwon("강원도"), Busan("부산"), Daegu("대구"), Gwanju("광주"), Daejeon("대전"), Ulsan("울산"),
    Chungcheongbuk("충북"), Chungcheongnam("충남"), Jeollabuk("전북"), Jeollanam("전남"), Gyeongsangbuk("경북"), Gyeongsangnam("경남"), Jeju("제주도"), Sejong("세종"), Quarantine("검역소");

    companion object {
        fun getRegion(name: String): Region {
            return when(name) {
                "서울" -> {
                    Seoul
                }
                "인천" -> {
                    Incheon
                }
                "경기" -> {
                    Gyeonggi
                }
                "강원" -> {
                    Gangwon
                }
                "세종" -> {
                    Sejong
                }
                "충북" -> {
                    Chungcheongbuk
                }
                "충남" -> {
                    Chungcheongnam
                }
                "대전" -> {
                    Daejeon
                }
                "경북" -> {
                    Gyeongsangbuk
                }
                "전북" -> {
                    Jeollabuk
                }
                "대구" -> {
                    Daegu
                }
                "전남" -> {
                    Jeollanam
                }
                "광주" -> {
                    Gwanju
                }
                "경남" -> {
                    Gyeongsangnam
                }
                "울산" -> {
                    Ulsan
                }
                "부산" -> {
                    Busan
                }
                "제주" -> {
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