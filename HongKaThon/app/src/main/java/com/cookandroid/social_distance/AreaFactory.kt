package com.cookandroid.social_distance

import android.util.Log
import com.google.firebase.database.*

object AreaFactory {
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var dbArea: DatabaseReference
    var areaList = ArrayList<AreaItem>()
    init {
        // DB 테이블 연결
        dbArea = database.getReference("areaList")

        // logList에 DB데이터 연결
        dbArea.addListenerForSingleValueEvent(object : ValueEventListener {

            // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                areaList.clear()
                for (snapshot in dataSnapshot.children) { // 반복문으로 데이터 List를 추출해냄
                    val space = snapshot.getValue(AreaItem::class.java) // 만들어뒀던 객체에 데이터를 담는다.
                    areaList.add(space!!) // 담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
            }

            // 디비를 가져오던중 에러 발생 시 에러문 출력
            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("Error", databaseError.toException().toString())
            }
        })
    }
}