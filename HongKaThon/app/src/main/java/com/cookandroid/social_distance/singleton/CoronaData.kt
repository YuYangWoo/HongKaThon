package com.cookandroid.social_distance.singleton

import kotlinx.coroutines.*
import org.jsoup.Jsoup

object CoronaData {
    private val job: Job
    private val level = HashMap<String, String>()
    private val infection = HashMap<String, Pair<Int, Int>>()

    init {
        job = CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.IO) {
                val document = Jsoup.connect("http://ncov.mohw.go.kr/regSocdisBoardView.do?brdId=6&brdGubun=68&ncvContSeq=495").get()
                val element = document.getElementById("main_maplayout")
                val data = element.getElementsByTag("button")

                for (entry in data) {
                    level[entry.child(0).text()] = entry.child(1).text()
                }
            }

            withContext(Dispatchers.IO) {
                val document = Jsoup.connect("http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=").get()
                val element = document.getElementById("main_maplayout")
                val data = element.getElementsByTag("button")

                for (entry in data) {
                    val total = entry.child(1).text().replace(",", "").toInt()
                    val plus = entry.child(2).text().replace(",", "").replace("(", "").replace("+", "").replace(")", "").toInt()
                    infection[entry.child(0).text()] = Pair(total, plus)
                }
            }
        }
    }

    fun getLevel(region: String): String {
        return runBlocking {
            job.join()
            level[region] ?: ""
        }
    }

    fun getTotalInfection(region: String): Int {
        return runBlocking {
            job.join()
            infection[region]?.first ?: 0
        }
    }

    fun getPlusInfection(region: String): Int {
        return runBlocking {
            job.join()
            infection[region]?.second ?: 0
        }
    }
}