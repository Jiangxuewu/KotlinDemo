package com.transsnet.note.ui.home.todo.widget

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import com.bb_sz.lib.database.greendao.TaskDao
import com.transsnet.note.BuildConfig
import com.transsnet.note.R
import com.transsnet.note.common.database.DB
import com.transsnet.note.model.structure.Task
import com.transsnet.note.ui.home.todo.IAdapterCallback
import com.transsnet.note.ui.home.todo.TodoAdapter

/**
 * Created by Jiangxuewu on 2018/6/28.
 */
class TodoView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : FrameLayout(context, attrs, defStyleAttr), IAdapterCallback {

    private val titleName by lazy {
        findViewById<TextView>(R.id.todo_title)
    }

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.todo_recycler_view)
    }

    private var adapter: TodoAdapter? = null

    init {
        initParam()
    }

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)


    private fun initParam() {
        View.inflate(context, R.layout.todo_page_view, this)

        titleName.setText(R.string.todo)

        updateTodoList()
    }

    fun onStart() {
    }

    fun onResume() {
    }

    fun onPause() {
    }

    fun onStop() {
    }

    fun onDestroy() {
    }

    private fun updateTodoList() {
        val list: List<Task> = getTodoList()
        if (null == adapter) {
            adapter = TodoAdapter(context, list, this)
            recyclerView.layoutManager = LinearLayoutManager(context)

            recyclerView.adapter = adapter
            if (BuildConfig.DEBUG) {
                Log.i("Main", "updateTodoList, set adapter list is ${list.size}")
            }
        } else {
            adapter?.update(list)
            if (BuildConfig.DEBUG) {
                Log.i("Main", "updateTodoList, update list is ${list.size}")
            }
        }
    }

    private fun getTodoList(): List<Task> {
        val list: ArrayList<Task> = ArrayList<Task>()

        DB.getDaoSession()?.taskDao?.queryBuilder()?.where(TaskDao.Properties.State.eq(0), TaskDao.Properties.Content.isNotNull)?.orderDesc(TaskDao.Properties.Stick_time)?.orderAsc(TaskDao.Properties.Create_time)?.list()?.let {
            return it
        }

        return list
    }

    override fun singleClick(itemView: View?, position: Int) {
    }

    override fun doubleClick(itemView: View?, position: Int) {
    }

    override fun onTextChanged(editText: EditText, s: CharSequence, start: Int, before: Int, count: Int) {
    }
}