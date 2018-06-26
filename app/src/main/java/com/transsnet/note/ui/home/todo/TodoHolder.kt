package com.transsnet.note.ui.home.todo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.bb_sz.lib.view.listener.ViewDoubleSingleClickListener
import com.transsnet.note.App
import com.transsnet.note.R
import org.w3c.dom.Text

/**
 * Created by Jiangxuewu on 2018/6/26.
 */
class TodoHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    private var inputText: EditText? = null
    private var inputTextTV: TextView? = null
    private var editNeedShowInput: Boolean = false

    constructor(viewType: Int, itemView: View?) : this(itemView) {
        inputText = itemView?.findViewById(R.id.todo_input)
        inputTextTV = itemView?.findViewById(R.id.todo_input_tv)

        inputText?.let {
            it.viewTreeObserver.addOnGlobalLayoutListener({
                if (editNeedShowInput) {
                    val imm = App.instance?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.showSoftInput(it, 0)
                    editNeedShowInput = false
                }
            })

            it.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    
                }

                override fun afterTextChanged(s: Editable) {

                }
            })
        }
    }

    fun initData(itemValue: String?, position: Int, callback: IAdapterCallback?, singleClickPosition: Int?) {


        if (isInput(position, singleClickPosition)) {
            inputTextTV?.let {
                it.visibility = View.GONE
                it.text = ""
            }

            inputText?.let {
                it.setText(itemValue ?: "")
                val res = it.requestFocus()
                it.isCursorVisible = true
                it.visibility = View.VISIBLE

                if (res && null != App.instance) {
                    val imm = App.instance?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    editNeedShowInput = !imm.showSoftInput(it, 0)
                } else {
                    editNeedShowInput = true
                }

                it.text?.length?.let { inputText?.setSelection(it) }
            }
        } else {

            inputTextTV?.let {
                it.setOnClickListener(ItemClickListener(it, position, callback))
                it.visibility = View.VISIBLE
                it.text = itemValue ?: ""
            }

            inputText?.let {
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