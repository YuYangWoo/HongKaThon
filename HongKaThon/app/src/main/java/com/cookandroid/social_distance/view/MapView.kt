package com.cookandroid.social_distance.view

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup

class MapView : WebView {
    private var type = Type.NONE

    private val socialDistanceLevel by lazy {
        val document = runBlocking(Dispatchers.IO) {
            Jsoup.connect("http://ncov.mohw.go.kr/regSocdisBoardView.do?brdId=6&brdGubun=68&ncvContSeq=495").get()
        }

        val graph = document.body().getElementById("reg_Map").toString()
        val scripts = document.body().getElementsByTag("script").toString()

        "<!DOCTYPE html><html lang=\"ko\">${document.head()}$graph$scripts</html>".replace("/static", "http://ncov.mohw.go.kr/static")
    }

    private val socialInfection by lazy {
        val document = runBlocking(Dispatchers.IO) {
            Jsoup.connect("http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=13&ncvContSeq=&contSeq=&board_id=&gubun=").get()
        }
        val graph = document.body().getElementsByClass("regional_patient_status_A")
        val scripts = document.body().getElementsByTag("script")

        "<!DOCTYPE html><html lang=\"ko\">${document.head()}$graph$scripts</html>".replace("/static", "http://ncov.mohw.go.kr/static")
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        settings.javaScriptEnabled = true
        webChromeClient = WebChromeClient()
        webViewClient = WebViewClient()
        settings.domStorageEnabled = true

        setSocialDistanceLevel()
    }

    fun setSocialDistanceLevel() {
        if (type != Type.LEVEL) {
            type = Type.LEVEL
            loadDataWithBaseURL(null, socialDistanceLevel, "text/html; charset=utf-8", "UTF-8", null)
        }
    }

    fun setSocialInfection() {
        if (type != Type.INFECTION) {
            type = Type.INFECTION
            loadDataWithBaseURL(null, socialInfection, "text/html; charset=utf-8", "UTF-8", null)
        }
    }

    private enum class Type {
        NONE, INFECTION, LEVEL
    }
}