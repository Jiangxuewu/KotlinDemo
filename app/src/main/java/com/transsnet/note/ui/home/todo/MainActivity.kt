package com.transsnet.note.ui.home.todo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.transsnet.note.BuildConfig
import com.transsnet.note.R
import com.transsnet.note.common.database.DB

class MainActivity : AppCompatActivity(), IAdapterCallback {


    private val TAG = "MainActivity"

    //初始化和延迟加载
    //lazy只适用于val对象，对于var对象，需要使用lateinit，原理是类似的
    private val recyclerView: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.recycler_view)
    }


    private var helloTV: TextView? = null


    private var adapter: TodoAdapter? = null

    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initData()
    }

    private fun initData() {

        adapter = TodoAdapter(this, getTodoList(), this)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter

    }

    private fun getTodoList(): List<String> {
        val list: ArrayList<String> = ArrayList<String>()

        DB.getDaoSession()?.taskDao?.queryBuilder()?.list()?.let {
            for (item in it){
                list.add(item.content)
            }
        }

        return list
    }

    private fun initViews() {
        helloTV = this.findViewById<TextView>(R.id.text_hello)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        Process.killProcess(Process.myPid())
    }


    override fun singleClick(itemView: View?, position: Int) {

        val curPosition = adapter?.getSingleClickPosition()

        if (position == curPosition) {
            return
        }

        handler.post {
            if (BuildConfig.DEBUG) {
                Log.i(TAG, "singleClick, position is $position")
            }
            adapter?.singleClick(position)
//            adapter?.notifyItemChanged(position)
            adapter?.notifyDataSetChanged()
        }
    }

    override fun doubleClick(itemView: View?, position: Int) {
    }

    override fun onTextChanged(editText: EditText, s: CharSequence, start: Int, before: Int, count: Int) {

    }
}
