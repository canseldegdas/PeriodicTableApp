package com.example.periodictableapp.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.periodictableapp.MainActivity
import com.example.periodictableapp.R

class PeriodicTableWidgetProvider: AppWidgetProvider() {

    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?
    ) {
        for (appWidgetId in appWidgetIds!!) {
            val intent = Intent(context, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
            val views = RemoteViews(context!!.packageName, R.layout.widgetof_periodictable)
            views.setOnClickPendingIntent(R.id.img_periodictable, pendingIntent)
            appWidgetManager!!.updateAppWidget(appWidgetId, views)
        }
    }
}