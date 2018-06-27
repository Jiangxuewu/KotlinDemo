package com.transsnet.note.common.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bb_sz.lib.database.greendao.DaoMaster;

/**
 * Created by Administrator on 2017/3/14.
 */

public class DBHelper extends DaoMaster.OpenHelper {

    private static final String TAG = "DBHelper";

    public DBHelper(Context context, String name) {
        super(context, name);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if (com.bb_sz.lib.BuildConfig.LogSwitch)
//            L.i(TAG, "onUpgrade, oldVersion = " + oldVersion + ", newVersion = " + newVersion);
        if (oldVersion < newVersion && newVersion == 3) {
            if (oldVersion == 2) {
                // update data  WHERE `_id` = 1
                String sql = "UPDATE `LOGIN_RES_BEAN` SET `OPEN_NICK`=(SELECT `NICKNAME` FROM `USER_INFO_BEAN` ORDER BY `_id` DESC LIMIT 0,1 )  WHERE  `ERR_CODE` = 0 ";
                db.execSQL(sql);
//                if (com.bb_sz.lib.BuildConfig.LogSwitch) L.i(TAG, "update db data");
            } else if (oldVersion < 2) {
                db.execSQL(DBConst.UPDATE_V_CODE_7);
//                if (com.bb_sz.lib.BuildConfig.LogSwitch) L.i(TAG, "update db");
                // update data  WHERE `_id` = 1
                String sql = "UPDATE `LOGIN_RES_BEAN` SET `OPEN_NICK`=(SELECT `NICKNAME` FROM `USER_INFO_BEAN` ORDER BY `_id` DESC LIMIT 0,1 )  WHERE  `ERR_CODE` = 0 ";
                db.execSQL(sql);
//                if (com.bb_sz.lib.BuildConfig.LogSwitch) L.i(TAG, "update db data");
            }
        } else if (oldVersion < newVersion && newVersion == 4){
            if (oldVersion == 3){
                db.execSQL(DBConst.UPDATE_V_CODE_34);
            } else if (oldVersion < 3){
                // TODO: 2017/6/18
            }
        }
    }

}