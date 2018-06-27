package com.transsnet.note

import android.app.Application
import android.util.Log
import com.squareup.leakcanary.LeakCanary
import com.transsnet.note.common.database.DB
import com.transsnet.note.common.database.DBConst
import com.transsnet.note.common.sp.SP

/**
 * Created by Jiangxuewu on 2018/6/26.
 */
class App : Application() {

    companion object {
        var instance: App? = null
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("App", "onCreate.")

        instance = this

        initCommon()

        if (LeakCanary.isInAnalyzerProcess(applicationContext)) {
            return
        }
        LeakCanary.install(this)
    }


    private fun initCommon() {
        SP.init(applicationContext)
        DB.init(applicationContext, DBConst.DB_NAME)
    }

    fun isFirstStartApp() = SP.isFirstApp()
}