package com.example.covid_19

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat

fun showNotification(title: String, message: String, context: Context?, intent: Intent?) {

    val mNotificationManager =
        context!!.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel(
            "YOUR_CHANNEL_ID",
            "YOUR_CHANNEL_NAME",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = "YOUR_NOTIFICATION_CHANNEL_DESCRIPTION"
        mNotificationManager.createNotificationChannel(channel)
    }
    val mBuilder = NotificationCompat.Builder(context.applicationContext, "YOUR_CHANNEL_ID")
        .setSmallIcon(R.drawable.ic_thumbs_up_down_black_24dp) // notification icon
        .setContentTitle(title) // title for notification
        .setContentText(message)// message for notification
        .setColor(Color.parseColor("#9FA8DA"))
        .setAutoCancel(true) // clear notification after click
    val intent = Intent(context.applicationContext, MainActivity::class.java)
    val pi = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
    mBuilder.setContentIntent(pi)
    mNotificationManager.notify(0, mBuilder.build())
}