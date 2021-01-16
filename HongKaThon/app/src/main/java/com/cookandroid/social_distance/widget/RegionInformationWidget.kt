package com.cookandroid.social_distance.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.Toast
import com.cookandroid.social_distance.R
import com.cookandroid.social_distance.gps.GpsTracker
import com.cookandroid.social_distance.gps.Region
import com.cookandroid.social_distance.singleton.CoronaData

class RegionInformationWidget : AppWidgetProvider() {
    companion object {
        const val ACTION_REFRESH = "action_refresh"
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        when(intent.action) {
            ACTION_REFRESH -> {
                val ids = AppWidgetManager.getInstance(context).getAppWidgetIds(ComponentName(context, RegionInformationWidget::class.java))
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
        val intent = Intent(context, RegionInformationWidget::class.java).setAction(ACTION_REFRESH)
        val pending = PendingIntent.getBroadcast(context, 0, intent, 0)
        val index = context.getSharedPreferences("Widget", Context.MODE_PRIVATE).getInt(id.toString(), -1)

        return RemoteViews(context.packageName, R.layout.widget_region_information).apply {
            if (index == -1) {
                setTextViewText(R.id.region, "새로고침을 해주세요")
            } else {
                val region = Region.values()[index]

                setTextViewText(R.id.region, region.korean)
                setTextViewText(R.id.total, "${CoronaData.getTotalInfection(region)}명")
                setTextViewText(R.id.plus, "+${CoronaData.getPlusInfection(region)}명")
                setTextViewText(R.id.level, "${CoronaData.getLevel(region)}단계")
            }

            setOnClickPendingIntent(R.id.refresh, pending)

        }
    }
}