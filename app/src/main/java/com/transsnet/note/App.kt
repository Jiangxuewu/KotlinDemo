package com.transsnet.note

import android.app.Application
import android.util.Log
import com.squareup.leakcanary.LeakCanary

/**
 * Created by Jiangxuewu on 2018/6/26.
 */
class App : Application() {


    companion object {
        var instance : Application ? = null

//        fun getInstance():Application?{
//            return instance
//        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Log.i("App", "onCreate.")

        Thread.sleep(1000)

        if (LeakCanary.isInAnalyzerProcess(applicationContext)) {
            return
        }
        LeakCanary.install(this)
    }
}