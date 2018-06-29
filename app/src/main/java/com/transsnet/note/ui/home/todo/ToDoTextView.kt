package com.transsnet.note.ui.home.todo

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import com.transsnet.note.BuildConfig.DEBUG

/**
 * Created by Jiangxuewu on 2018/6/29.
 */
class ToDoTextView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : TextView(context, attrs, defStyleAttr) {


    private val mGestureListener: MyGestureListener by lazy {
        MyGestureListener()
    }

    private val mGestureDetector: GestureDetector by lazy {
        GestureDetector(context, mGestureListener)
    }

    init {
        initParam()
    }

    private fun initParam() {
        isLongClickable = true
        setOnTouchListener { _, event -> mGestureDetector.onTouchEvent(event) }

    }

    constructor(context: Context) : this(context, null, 0)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)


    class MyGestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            if (DEBUG) {
                Log.i("ToDoTextView", "onSingleTapUp, ...")
            }
            return super.onSingleTapUp(e)
        }

        override fun onDown(e: MotionEvent?): Boolean {
            if (DEBUG) {
                Log.i("ToDoTextView", "onDown, ...")
            }
            return super.onDown(e)
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            if (DEBUG) {
                Log.i("ToDoTextView", "onFling, ...")
            }
            return super.onFling(e1, e2, velocityX, velocityY)
        }

        override fun onDoubleTap(e: MotionEvent?): Boolean {
            if (DEBUG) {
                Log.e("ToDoTextView", "onDoubleTap, ...")
            }
            return true//super.onDoubleTap(e)
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            if (DEBUG) {
                Log.i("ToDoTextView", "onScroll, ...")
            }
            return super.onScroll(e1, e2, distanceX, distanceY)
        }

        override fun onContextClick(e: MotionEvent?): Boolean {
            if (DEBUG) {
                Log.i("ToDoTextView", "onContextClick, ...")
            }
            return super.onContextClick(e)
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            if (DEBUG) {
                Log.e("ToDoTextView", "onSingleTapConfirmed, ...")
            }
            return true//super.onSingleTapConfirmed(e)
        }

        override fun onShowPress(e: MotionEvent?) {
            if (DEBUG) {
                Log.i("ToDoTextView", "onShowPress, ...")
            }
            super.onShowPress(e)
        }

        override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
            if (DEBUG) {
                Log.i("ToDoTextView", "onDoubleTapEvent, ...")
            }
            return true//super.onDoubleTapEvent(e)
        }

        override fun onLongPress(e: MotionEvent?) {
            if (DEBUG) {
                Log.e("ToDoTextView", "onLongPress, ...")
            }
            super.onLongPress(e)
        }
    }
}