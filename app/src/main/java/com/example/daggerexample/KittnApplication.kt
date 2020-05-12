package com.example.daggerexample

import android.app.Application
import android.util.Log
import com.example.comment.CommentrInitializr

class KittnApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "onCreate")

        appComponent = DaggerAppComponent.builder()
            // HOW can I set commentComponent if I can't create it until AFTER creating appcomponent
//            .commentComponent()
            .build()

        CommentrInitializr.init(appComponent)
        val commentComponent = CommentrInitializr.getCommentComponent()
    }
}