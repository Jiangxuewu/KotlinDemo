package com.transsnet.note.ui.home.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.transsnet.note.ui.home.todo.TodoAdapter
import com.transsnet.note.ui.home.todo.widget.TodoView

/**
 * Created by Jiangxuewu on 2018/6/28.
 */
class HomeView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr) {

    private val todoView: TodoView by lazy {
        TodoView(context)
    }


    init {
        initParam()
    }

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)


    private fun initParam() {
        addView(todoView)
    }

    fun onStart() {
        todoView.onStart()
    }

    fun onResume() {
        todoView.onResume()
    }

    fun onPause() {
        todoView.onPause()
    }

    fun onStop() {
        todoView.onStop()
    }

    fun onDestroy() {
        todoView.onDestroy()
    }


}