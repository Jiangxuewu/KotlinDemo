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
import android.widget.TextView
import com.transsnet.note.BuildConfig
import com.transsnet.note.R
import kotlinx.android.synthetic.main.activity_main.*

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

        list.add("A1234567890")
        list.add("B1234567891")
        list.add("C234567892")
        list.add("D1234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("E234567890")
        list.add("F234567891")
        list.add("G234567892")
        list.add("H1234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("J1234567890")
        list.add("K1234567891")
        list.add("L1234567892")
        list.add("M234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("N234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("O234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("P234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("1A1234567890")
        list.add("1B1234567891")
        list.add("1C234567892")
        list.add("1D1234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("1E234567890")
        list.add("1F234567891")
        list.add("1G234567892")
        list.add("1H1234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("1J1234567890")
        list.add("1K1234567891")
        list.add("1L1234567892")
        list.add("1M234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("1N234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("1O234567893123456789312345678931234567893123456789312345678931234567893")
        list.add("1P234567893123456789312345678931234567893123456789312345678931234567893")

        return list
    }

    private fun initViews() {
        helloTV = text_hello
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
}
