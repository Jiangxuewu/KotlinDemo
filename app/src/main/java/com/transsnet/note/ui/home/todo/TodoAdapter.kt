package com.transsnet.note.ui.home.todo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.transsnet.note.R

/**
 * Created by Jiangxuewu on 2018/6/26.
 */
open class TodoAdapter() : RecyclerView.Adapter<TodoHolder>() {

    private var context: Context? = null
    private var list: List<String>? = null
    private var callback: IAdapterCallback? = null

    private var singleClickPosition: Int? = -1

    constructor (context: Context?, list: List<String>?, callback: IAdapterCallback?) : this() {
        this.context = context
        this.list = list
        this.callback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        return TodoHolder(viewType, View.inflate(context, R.layout.item_todo_recycle, null))
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.initData(list?.get(position), position, callback, singleClickPosition)
    }

    fun singleClick(position: Int) {
        singleClickPosition = if (position < 0 || position > itemCount) {
            -1
        } else {
            position
        }
    }

    fun getSingleClickPosition() = singleClickPosition


}

