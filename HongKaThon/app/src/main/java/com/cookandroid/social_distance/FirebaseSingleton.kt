package com.cookandroid.social_distance

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object FirebaseSingleton {
    var oneStep = ArrayList<AreaGuideItem>()
    var oneDotFiveStep = ArrayList<AreaGuideItem>()
    var twoStep = ArrayList<AreaGuideItem>()
    var twoDotFiveStep = ArrayList<AreaGuideItem>()
    var threeStep = ArrayList<AreaGuideItem>()
    private var database = FirebaseDatabase.getInstance()
fun init() {
    database.getReference("1step").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
         val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                  list.add(it!!)
                }
            }
            oneStep = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

    database.getReference("1dot5step").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                    list.add(it!!)
                }
            }
            oneDotFiveStep = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

    database.getReference("2step").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                    list.add(it!!)
                }
            }
            twoStep = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

    database.getReference("2dot5step").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                    list.add(it!!)
                }
            }
            twoDotFiveStep = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

    database.getReference("3step").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                    list.add(it!!)
                }
            }
            threeStep = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

}
}