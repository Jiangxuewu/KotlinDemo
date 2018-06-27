package com.transsnet.note.common.database

/**
 * Created by Jiangxuewu on 2018/6/27.
 */
class DBConst {

    companion object {
        const val DB_NAME = "en_db"
        const val UPDATE_V_CODE_7 = "ALTER TABLE `LOGIN_RES_BEAN` ADD COLUMN `OPEN_NICK` text "// NULL AFTER `T.UPGRADE_URL`
        const val UPDATE_V_CODE_34 = "ALTER TABLE `ADD_DATA` ADD COLUMN `STICK_TIME` text "
    }
}