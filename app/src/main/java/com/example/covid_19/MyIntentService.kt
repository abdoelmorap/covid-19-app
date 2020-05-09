package com.example.covid_19

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyIntentService : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val title = " تذكر غسل يديك "
        val dis =
            "لحماية نفسك ضد  Covid 19  اغسل يديك من حين للاخر لمدة 20 ثانية  \n تذكر ضرورة غسل اليد بعد الرجوع الي المنزل  "
        showNotification(title, dis, context, intent)
    }


}
