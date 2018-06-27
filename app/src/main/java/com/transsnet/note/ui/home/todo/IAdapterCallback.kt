package com.transsnet.note.ui.home.todo

import android.view.View
import android.widget.EditText

/**
 * Created by Jiangxuewu on 2018/6/26.
 */
interface IAdapterCallback {
    fun singleClick(itemView: View?, position: Int)
    fun doubleClick(itemView: View?, position: Int)
    fun onTextChanged(editText: EditText,s: CharSequence, start: Int, before: Int, count: Int)
}