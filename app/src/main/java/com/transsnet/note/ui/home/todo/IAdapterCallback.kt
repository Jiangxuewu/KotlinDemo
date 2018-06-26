package com.transsnet.note.ui.home.todo

import android.view.View

/**
 * Created by Jiangxuewu on 2018/6/26.
 */
interface IAdapterCallback {
    fun singleClick(itemView: View?, position: Int)
    fun doubleClick(itemView: View?, position: Int)
}