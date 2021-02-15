package com.cookandroid.social_distance.singleton

import android.util.Log
import com.cookandroid.social_distance.item.AreaItem
import com.google.firebase.database.*

object AreaFactory {
    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    var areaList = ArrayList<AreaItem>()

    init {

        // DB데이터 연결
        database.getReference("areaList")
            .addListenerForSingleValueEvent(object : ValueEventListener {

                // 파이어베이스 데이터베이스의 데이터를 받아오는 곳
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    areaList.clear()
                    val list = ArrayList<AreaItem>()
                    for (snapshot in dataSnapshot.children) { // 반복문으로 데이터 List를 추출해냄
                        snapshot.getValue(AreaItem::class.java)
                            ?.let { list.add(it) } // 만들어뒀던 객체에 데이터를 담는다.
                    }
                    areaList = list
                }

                // 디비를 가져오던중 에러 발생 시 에러문 출력
                override fun onCancelled(databaseError: DatabaseError) {
                    Log.e("Error", databaseError.toException().toString())
                }
            })
    }
}