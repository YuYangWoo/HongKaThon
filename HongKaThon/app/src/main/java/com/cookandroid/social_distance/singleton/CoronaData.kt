package com.cookandroid.social_distance.singleton

import android.util.Log
import com.cookandroid.social_distance.gps.GpsTracker
import com.cookandroid.social_distance.gps.Region
import kotlinx.coroutines.*
import org.jsoup.Jsoup

object CoronaData {
    private val levelJob: Job
    private val infectionJob: Job
    private val level = HashMap<Region, String>()
    private val infection = HashMap<Region, Pair<Int, Int>>()

    init {
        levelJob = CoroutineScope(Dispatchers.IO).launch {
            val document = Jsoup.connect("http://ncov.mohw.go.kr/regSocdisBoardView.do?brdId=6&brdGubun=68&ncvContSeq=495").get()
            val element = document.getElementById("main_maplayout")
            val buttons = element.getElementsByTag("button")
            for (id in buttons) {
                val key = id.attr("data-city")
                val data = document.getElementById(key)

                level[Region.getRegion(data.getElementsByClass("rssd_title_1").first().text())] = data.getElementsByClass("rssd_title_2").first().text().substringBefore("단계")
            }
        }

        infectionJob = CoroutineScope(Dispatchers.IO).launch {
            val document = Jsoup.connect("http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=").get()
            val element = document.getElementById("main_maplayout")
            val data = element.getElementsByTag("button")

            for (entry in data) {
                val total = entry.child(1).text().replace(",", "").toInt()
                val plus = entry.child(2).text().replace(",", "").replace("(", "").replace("+", "").replace(")", "").toInt()
                infection[Region.getRegion(entry.child(0).text())] = Pair(total, plus)
            }
        }
    }

    fun getLevel(region: Region): String {
        return runBlocking {
            levelJob.join()
            level[region] ?: ""
        }
    }

    fun getTotalInfection(region: Region): Int {
        return runBlocking {
            infectionJob.join()
            infection[region]?.first ?: 0
        }
    }

    fun getPlusInfection(region: Region): Int {
        return runBlocking {
            infectionJob.join()
            infection[region]?.second ?: 0
        }
    }
}