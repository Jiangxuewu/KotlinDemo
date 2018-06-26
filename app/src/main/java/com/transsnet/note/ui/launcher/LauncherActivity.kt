package com.transsnet.note.ui.launcher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.transsnet.note.ui.home.todo.MainActivity

class LauncherActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }
}
