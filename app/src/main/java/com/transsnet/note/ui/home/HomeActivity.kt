package com.transsnet.note.ui.home

import android.app.Activity
import android.os.Bundle
import com.transsnet.note.ui.home.widget.HomeView

class HomeActivity : Activity() {

    private val homeView: HomeView by lazy {
        HomeView(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(homeView)
    }

    override fun onStart() {
        super.onStart()
        homeView.onStart()
    }

    override fun onResume() {
        super.onResume()
        homeView.onResume()
    }

    override fun onPause() {
        super.onPause()
        homeView.onPause()
    }

    override fun onStop() {
        super.onStop()
        homeView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        homeView.onDestroy()
    }


}

