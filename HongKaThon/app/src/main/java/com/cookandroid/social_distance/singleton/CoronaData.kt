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
    private val country = Array(8) { 0 }
    private val countryJob: Job

    private const val PATIENT = 0
    private const val PATIENT_PLUS = 1
    private const val UNDER_INSPECTION = 2
    private const val UNDER_INSPECTION_PLUS = 3
    private const val QUARANTINE = 4
    private const val QUARANTINE_PLUS = 5
    private const val DEAD = 6
    private const val DEAD_PLUS = 7

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

        countryJob = CoroutineScope(Dispatchers.IO).launch {
            val document = Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%BD%94%EB%A1%9C%EB%82%98").get()
            val elements = document.getElementsByClass("status_info").first().child(0).children()
            country[PATIENT] = elements[0].child(1).text().replace(",", "").toInt()
            country[PATIENT_PLUS] = elements[0].child(2).text().replace(",", "").toInt()
            country[UNDER_INSPECTION] = elements[1].child(1).text().replace(",", "").toInt()
            country[UNDER_INSPECTION_PLUS] = elements[1].child(2).text().replace(",", "").toInt()
            country[QUARANTINE] = elements[2].child(1).text().replace(",", "").toInt()
            country[QUARANTINE_PLUS] = elements[2].child(2).text().replace(",", "").toInt()
            country[DEAD] = elements[3].child(1).text().replace(",", "").toInt()
            country[DEAD_PLUS] = elements[3].child(2).text().replace(",", "").toInt()
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

    fun getCountryPatient(): Int {
        return runBlocking {
            countryJob.join()
            country[PATIENT]
        }
    }

    fun getCountryPatientPlus(): Int {
        return runBlocking {
            countryJob.join()
            country[PATIENT_PLUS]
        }
    }

    fun getCountryUnderInspection(): Int {
        return runBlocking {
            countryJob.join()
            country[UNDER_INSPECTION]
        }
    }

    fun getCountryUnderInspectionPlus(): Int {
        return runBlocking {
            countryJob.join()
            country[UNDER_INSPECTION_PLUS]
        }
    }

    fun getCountryQuarantine(): Int {
        return runBlocking {
            countryJob.join()
            country[QUARANTINE]
        }
    }

    fun getCountryQuarantinePlus(): Int {
        return runBlocking {
            countryJob.join()
            country[QUARANTINE_PLUS]
        }
    }

    fun getCountryDead(): Int {
        return runBlocking {
            countryJob.join()
            country[DEAD]
        }
    }

    fun getCountryDeadPlus(): Int {
        return runBlocking {
            countryJob.join()
            country[DEAD_PLUS]
        }
    }
}