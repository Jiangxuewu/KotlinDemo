package com.transsnet.note.ui.home.todo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.transsnet.note.R
import com.transsnet.note.model.structure.Task

/**
 * Created by Jiangxuewu on 2018/6/26.
 */
open class TodoAdapter() : RecyclerView.Adapter<TodoHolder>() {

    private var context: Context? = null
    private var list: List<Task>? = null
    private var callback: IAdapterCallback? = null

    private val adapterCallback: IAdapterCallback = object : IAdapterCallback {
        override fun singleClick(itemView: View?, position: Int) {
            callback?.singleClick(itemView, position)
        }

        override fun doubleClick(itemView: View?, position: Int) {
            callback?.doubleClick(itemView, position)
        }

        override fun onTextChanged(editText: EditText, s: CharSequence, start: Int, before: Int, count: Int) {
            callback?.onTextChanged(editText, s, start, before, count)
//            if (editText.tag is Int) {
//
//                if (DEBUG){
//                    Log.i("Adapter", "onTextChanged, position is ${editText.tag as Int}")
//                }
//                list?.get(editText.tag as Int)?.content = s.toString()
//
//                notifyItemChanged(editText.tag as Int)
//            }
        }
    }

    private var singleClickPosition: Int? = -1

    constructor (context: Context?, list: List<Task>?, callback: IAdapterCallback?) : this() {
        this.context = context
        this.list = list
        this.callback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        return TodoHolder(View.inflate(context, R.layout.item_todo_recycle, null))
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.initData(list?.get(position), position, adapterCallback, singleClickPosition)
    }

    fun singleClick(position: Int) {
        singleClickPosition = if (position < 0 || position > itemCount) {
            -1
        } else {
            position
        }
    }

    fun getSingleClickPosition() = singleClickPosition

    fun update(list: List<Task>) {
        this.list = null
        this.list = list
        notifyDataSetChanged()

    }


}

