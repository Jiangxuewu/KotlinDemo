package com.transsnet.note.common.database

import android.content.Context
import com.bb_sz.lib.database.greendao.DaoMaster
import com.bb_sz.lib.database.greendao.DaoSession
import com.bb_sz.lib.database.greendao.TaskDao
import com.transsnet.note.model.structure.Task

/**
 * Created by Jiangxuewu on 2018/6/27.
 */
object DB {
    private var mInstance: DB? = null
    private var mDaoSession: DaoSession? = null

    fun init(context: Context, dbName: String) {
        val mHelper = DBHelper(context, dbName, null)
        val db = mHelper.writableDatabase
        val mDaoMaster = DaoMaster(db)
        mDaoSession = mDaoMaster.newSession()

    }

    fun getDaoSession() = mDaoSession

//    fun getTask(id: Long): Task? {
//
//        val daoSession = DB.mInstance?.getDaoSession() ?: return null
//
//        val dao = daoSession.taskDao ?: return null
//
//        val qBuilder = dao.queryBuilder() ?: return null
//
//        val result = qBuilder.where(TaskDao.Properties._id.eq(id)).limit(1).list()
//
//        return if (null == result || result.isEmpty()) null else result[0]
//    }
}