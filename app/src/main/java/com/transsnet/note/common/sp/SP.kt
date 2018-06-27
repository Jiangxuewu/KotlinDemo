package com.transsnet.note.common.sp

import android.content.Context
import android.content.SharedPreferences
import com.transsnet.note.common.content.Contants

/**
 * Created by Jiangxuewu on 2018/6/27.
 */
object SP {

    private val TAG = "Skysp"
    private val FILE_NAME = "easynote_sp"

    private var sp: SharedPreferences? = null

    fun init(context: Context) {
        sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    }

    fun isFirstApp(): Boolean {
        val res: Boolean = sp?.getBoolean(Contants.APP_FIRST_RUN, true) ?: false
        if (res) {
            sp?.edit()?.putBoolean(Contants.APP_FIRST_RUN, false)?.commit()
        }
        return res
    }
}