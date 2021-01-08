package com.cookandroid.social_distance

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object FirebaseSingleton {
    var academy = ArrayList<AreaGuideItem>()
    var adultEntertainment = ArrayList<AreaGuideItem>()
    var amusement = ArrayList<AreaGuideItem>()
    var bath = ArrayList<AreaGuideItem>()
    var beauty = ArrayList<AreaGuideItem>()
    var funeral = ArrayList<AreaGuideItem>()
    var innerstadium = ArrayList<AreaGuideItem>()
    var movie = ArrayList<AreaGuideItem>()
    var multiroom = ArrayList<AreaGuideItem>()
    var other = ArrayList<AreaGuideItem>()
    var pc = ArrayList<AreaGuideItem>()
    var physical = ArrayList<AreaGuideItem>()
    var restaurant = ArrayList<AreaGuideItem>()
    var sale = ArrayList<AreaGuideItem>()
    var singingRoom = ArrayList<AreaGuideItem>()
    var stadium = ArrayList<AreaGuideItem>()
    var store = ArrayList<AreaGuideItem>()
    var studyCafe = ArrayList<AreaGuideItem>()
    var wedding = ArrayList<AreaGuideItem>()
    private var database = FirebaseDatabase.getInstance()
   init {
    database.getReference("academy").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
         val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                  list.add(it!!)
                }
            }
            academy = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

    database.getReference("adultentertainment").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                    list.add(it!!)
                }
            }
            adultEntertainment = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

    database.getReference("amusement").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                    list.add(it!!)
                }
            }
            amusement = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

    database.getReference("bath").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                    list.add(it!!)
                }
            }
            bath = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

    database.getReference("beauty").addListenerForSingleValueEvent(object: ValueEventListener{
        override fun onDataChange(snapshot: DataSnapshot) {
            val list = ArrayList<AreaGuideItem>()
            for(data in snapshot.children) {
                data.getValue(AreaGuideItem::class.java).let {
                    list.add(it!!)
                }
            }
            beauty = list
        }

        override fun onCancelled(error: DatabaseError) {
        }

    })

       database.getReference("funeral").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               funeral = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })
       database.getReference("innerstadium").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               innerstadium = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })
       database.getReference("movie").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               movie = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })

       database.getReference("multiroom").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               multiroom = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })

       database.getReference("other").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               other = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })

       database.getReference("pc").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               pc = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })

       database.getReference("physical").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               physical = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })

       database.getReference("restaurant").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               restaurant = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })

       database.getReference("sale").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               sale = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })
       database.getReference("singingroom").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               singingRoom = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })
       database.getReference("stadium").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               stadium = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })
       database.getReference("store").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               store = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })
       database.getReference("studycafe").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               studyCafe = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })
       database.getReference("wedding").addListenerForSingleValueEvent(object: ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               val list = ArrayList<AreaGuideItem>()
               for(data in snapshot.children) {
                   data.getValue(AreaGuideItem::class.java).let {
                       list.add(it!!)
                   }
               }
               wedding = list
           }

           override fun onCancelled(error: DatabaseError) {
           }

       })

}
}