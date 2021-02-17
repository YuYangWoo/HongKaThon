package com.cookandroid.social_distance.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import android.widget.Toast
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.gps.Region
import com.cookandroid.social_distance.singleton.CoronaData

class CountryInformationWidget : AppWidgetProvider() {
    companion object {
        const val ACTION_COUNTRY_INFORMATION_WIDGET_UPDATE =
            "ACTION_COUNTRY_INFORMATION_WIDGET_UPDATE"
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        when (intent.action) {
            ACTION_COUNTRY_INFORMATION_WIDGET_UPDATE -> {
                val ids = AppWidgetManager.getInstance(context).getAppWidgetIds(ComponentName(context, CountryInformationWidget::class.java))
                CoronaData.refreshCountry()
                update(context, AppWidgetManager.getInstance(context), ids)
                Toast.makeText(context, "새로고침", Toast.LENGTH_LONG).show()
            }
            else -> {
                val ids = AppWidgetManager.getInstance(context).getAppWidgetIds(ComponentName(context, CountryInformationWidget::class.java))
                CoronaData.refreshCountry()
                update(context, AppWidgetManager.getInstance(context), ids)
            }
        }
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        update(context, appWidgetManager, appWidgetIds)
    }

    private fun update(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        appWidgetIds.forEach {
            update(context, appWidgetManager, it)
        }
    }

    private fun update(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        appWidgetManager.updateAppWidget(appWidgetId, getUpdatedView(context, appWidgetId))
    }

    private fun getUpdatedView(context: Context, id: Int): RemoteViews {
        val intent = Intent(context, CountryInformationWidget::class.java).setAction(ACTION_COUNTRY_INFORMATION_WIDGET_UPDATE)
        val pending = PendingIntent.getBroadcast(context, 0, intent, 0)
        return RemoteViews(context.packageName, R.layout.widget_country_information).apply {
            setTextViewText(R.id.patient, CoronaData.getCountryPatient().toString())
            setTextViewText(R.id.patientPlus, "+" + CoronaData.getCountryPatientPlus().toString())
            setTextViewText(R.id.underInspection, CoronaData.getCountryUnderInspection().toString())
            setTextViewText(R.id.underInspectionPlus, "+" + CoronaData.getCountryUnderInspectionPlus().toString())
            setTextViewText(R.id.quarantine, CoronaData.getCountryQuarantine().toString())
            setTextViewText(R.id.quarantinePlus, "+" + CoronaData.getCountryQuarantinePlus().toString())
            setTextViewText(R.id.dead, CoronaData.getCountryDead().toString())
            setTextViewText(R.id.deadPlus, "+" + CoronaData.getCountryDeadPlus().toString())
            setOnClickPendingIntent(R.id.refresh, pending)
        }
    }
}