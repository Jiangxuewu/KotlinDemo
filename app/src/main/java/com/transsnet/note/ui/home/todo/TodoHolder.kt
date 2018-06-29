package com.transsnet.note.ui.home.todo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.bb_sz.lib.view.listener.ViewDoubleSingleClickListener
import com.transsnet.note.App
import com.transsnet.note.BuildConfig
import com.transsnet.note.R
import com.transsnet.note.model.structure.Task

/**
 * Created by Jiangxuewu on 2018/6/26.
 */
class TodoHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    private var callback: IAdapterCallback? = null

    private val selectionMap: HashMap<Long, Int?> = HashMap<Long, Int?>()

    private val inputEditText: EditText? by lazy {
        itemView?.findViewById<EditText>(R.id.todo_input)
    }
    private val inputTextTV: ToDoTextView? by lazy {
        itemView?.findViewById<ToDoTextView>(R.id.todo_input_tv)
    }

    private var editNeedShowInput: Boolean = false

    init {
        inputEditText?.let {
            it.viewTreeObserver.addOnGlobalLayoutListener {
                if (editNeedShowInput) {
                    val imm = App.instance?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.showSoftInput(it, 0)
                    editNeedShowInput = false
                }
            }

            it.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                    if (it.visibility == View.VISIBLE) {
                        if (BuildConfig.DEBUG) {
                            Log.i("Holder", "beforeTextChanged....")
                        }
                    }
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    if (isInputEditText(it)) {

                        if (selectionMap.containsKey(it.tag as Long)) {
                            selectionMap.remove(it.tag as Long)
                        }

                        selectionMap[it.tag as Long] = start + count

//                        callback?.onTextChanged(it, s, start, before, count)


                        if (BuildConfig.DEBUG) {
                            Log.i("Holder", "onTextChanged....start is $start, before is $before, count is $count")
                        }
                    }
                }

                override fun afterTextChanged(s: Editable) {
                    if (it.visibility == View.VISIBLE) {
                        if (BuildConfig.DEBUG) {
                            Log.i("Holder", "afterTextChanged....")
                        }
                    }

                    if (isInputEditText(it)) {
                        callback?.onTextChanged(it, s, 0, 0, 0)
                    }
                }
            })
        }
    }

    private fun isInputEditText(it: EditText): Boolean {

        return it.visibility == View.VISIBLE && it.tag is Long && it.tag as Long != -1L
    }

    fun initData(itemTask: Task?, position: Int, callback: IAdapterCallback?, singleClickPosition: Int?) {

        if (this.callback != callback) {
            this.callback = callback
        }

        if (isInput(position, singleClickPosition)) {
            inputTextTV?.let {
                it.visibility = View.GONE
                it.text = ""
            }

            inputEditText?.let {
                it.tag = itemTask?._id ?: -1L
                it.setText(itemTask?.content ?: "")
                val res = it.requestFocus()
                it.isCursorVisible = true
                it.visibility = View.VISIBLE

                if (res && null != App.instance) {
                    val imm = App.instance?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    editNeedShowInput = !imm.showSoftInput(it, 0)
                } else {
                    editNeedShowInput = true
                }

                //set selection
                var selection: Int? = it.text?.length ?: 0

                if (it.tag is Long) {
                    if (selectionMap.containsKey(it.tag as Long)) {
                        selection = selectionMap[it.tag as Long]
                    }
                }

                it.setSelection(selection ?: 0)
            }
        } else {

            inputTextTV?.let {
//                it.setOnClickListener(ItemClickListener(it, position, callback))
                it.visibility = View.VISIBLE
                it.text = itemTask?.content ?: ""
            }

            inputEditText?.let {
                it.tag = -1L
                it.setText("")
                it.clearFocus()
                it.isCursorVisible = false
                it.visibility = View.GONE
            }
        }
    }

    private fun isInput(position: Int, singleClickPosition: Int?): Boolean {
        return position == singleClickPosition && singleClickPosition >= 0
    }


    class ItemClickListener(itemView: View?, position: Int) : ViewDoubleSingleClickListener(itemView, position) {

        private var callback: IAdapterCallback? = null

        constructor(itemView: View?, position: Int, callback: IAdapterCallback?) : this(itemView, position) {
            this.callback = callback
        }

        override fun singleClick(itemView: View?, position: Int) {
            super.singleClick(itemView, position)
            callback?.singleClick(itemView, position)
        }

        override fun doubleClick(itemView: View?, position: Int) {
            super.doubleClick(itemView, position)
            callback?.doubleClick(itemView, position)
        }
    }
}