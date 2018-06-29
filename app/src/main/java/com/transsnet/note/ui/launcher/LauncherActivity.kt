package com.transsnet.note.ui.launcher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.transsnet.note.App
import com.transsnet.note.BuildConfig
import com.transsnet.note.common.database.DB
import com.transsnet.note.model.structure.Task
import com.transsnet.note.ui.home.HomeActivity
import com.transsnet.note.ui.home.todo.MainActivity

class LauncherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initGuideTask()

        startActivity(Intent(applicationContext, HomeActivity::class.java))
        finish()
    }

    private fun initGuideTask() {
        if (BuildConfig.DEBUG) {
            Log.i("SkyTest", "initGuideTask")
        }

        if (App.instance?.isFirstStartApp() == true) {
            DB.getDaoSession()?.taskDao?.let {
                val resList = ArrayList<Task>()

                for (i in 1..4) {

                    val item = Task()

                    item.content = "content_$i"

                    resList.add(item)
                }
                it.insertInTx(resList)

                if (BuildConfig.DEBUG) {
                    Log.e("SkyTest", "initGuideTask success")
                }
            }
        } else {
            if (BuildConfig.DEBUG) {
                Log.e("SkyTest", "initGuideTask exist")
            }
        }

    }
}
