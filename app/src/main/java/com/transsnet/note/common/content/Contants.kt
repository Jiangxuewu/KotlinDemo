package com.transsnet.note.common.content

import com.transsnet.note.BuildConfig

/**
 * Created by Jiangxuewu on 2018/6/27.
 */
class Contants {

    companion object {


        //事件ID	事件名称	事件类型
        val E1 = "event1"//	Todo页面展示	普通事件
        val E2 = "event2"//	Done页面展示	普通事件
        val E3 = "event3"//	More页面展示	普通事件
        val E4 = "event4"//	新建任务，完成输入内容后上报	普通事件
        val E5 = "event5"//	编辑内容，完成改动后上报	普通事件
        val E6 = "event6"//	删除内容	普通事件
        val E7 = "event7"//	置顶内容	普通事件
        val E8 = "event8"//	提醒按钮	普通事件
        val E9 = "event9"//	新设置提醒内容页面	普通事件
        val E10 = "event10"//	添加提醒按钮点击次数	普通事件
        val E11 = "event11"//	访问已有提醒内容页面	普通事件
        val E12 = "event12"//	More页面登录点击	普通事件
        val E13 = "event13"//	微信登录点击次数	普通事件
        val E14 = "event14"//	Facebook登录点击次数	普通事件
        val E15 = "event15"//	Google+登录点击次数	普通事件
        val E16 = "event16"//	邮箱登录点击次数	普通事件
        val E17 = "event17"//	邮箱注册点击次数	普通事件
        val E18 = "event18"//	邮箱注册提交点击	普通事件
        val E19 = "event19"//	退出登录点击	普通事件
        val E20 = "event20"//	微信好友分享点击	普通事件
        val E21 = "event21"//	微信朋友圈分享点击	普通事件
        val E22 = "event22"//	QQ好友分享点击	普通事件
        val E23 = "event23"//	QQ空间分享点击	普通事件
        val E24 = "event24"//	新浪微博分享点击	普通事件
        val E25 = "event25"//	Facebook分享点击	普通事件
        val E26 = "event26"//	应用商店评论引导点击	普通事件
        val E27 = "event27"//	Twitter分享点击	普通事件
        val E28 = "event28"//	WhatsApp分享点击	普通事件
        val E29 = "event29"//	编辑提醒	普通事件
        val E30 = "event30"//	删除提醒	普通事件
        val E31 = "event31"//	QQ登录点击次数	普通事件


        //双击后， item往右上角移动的时长
        val ANIMATION_DURATION_DOUBLE = 400
        //item往右上角移动完后， 开始上移下个item的时长
        val ANIMATION_DURATION_DOUBLE_DEL = 300
        //左滑删除item的时长
        val ANIMATION_DURATION_DEL = 500
        //点击title， 切换到 切换页面状态的动画时长
        val ANIMATION_DURATION_MAIN_SHOW = 200
        //启动页面显示时长
        val WELCOME_SHOW_DURATION: Long = 1200
        //启动页面关闭动画的时长
        val WELCOME_HIDE_DURATION: Long = 500
        val ANIMATION_DURATION = 5000


        val OPEN_TYPE = "weixin"
        val OPEN_TYPE_EMAIL = "mail"
        val VERSION = BuildConfig.VERSION_NAME
        val VERSION_VAR = "And_V" + BuildConfig.VERSION_NAME
        val VERSION_CODE = BuildConfig.VERSION_CODE
        val LOGIN = "1"
        val LOGOUT = "2"

        val ACTION_MAIN_LOGIN = "ACTION_MAIN_LOGIN"
        val ACTION_MAIN_LOGOUT = "ACTION_MAIN_LOGOUT"
        val ACTION_LOGIN_FAILED = "ACTION_LOGIN_FAILED"
        val ACTION_LOGIN_SUCCESS = "ACTION_LOGIN_SUCCESS"
        val ACTION_LOGOUT_SUCCESS = "ACTION_LOGOUT_SUCCESS"
        val ACTION_LOGOUT_FAILED = "ACTION_LOGOUT_FAILED"
        val ACTION_DATA_UPDATE = "ACTION_DATA_UPDATE"
        val ANDROID = "android"
        val APP_FIRST_RUN = "SP_APP_FIRST_RUN"
        val ACTION_SYNC_ALL_SUCCESS = "ACTION_SYNC_ALL_SUCCESS"
        val BUGLY_ID = BuildConfig.buglyKey
        val ACTION_CLOSE_KEYBOARD = "ACTION_CLOSE_KEYBOARD"
        val ACTION_TODO_REFRESH = "ACTION_TODO_REFRESH"
        val ACTION_TIP_SUBSCRIBER = "ACTION_TIP_SUBSCRIBER"
        val ITEM_REPLACE = "[\\t\\n\\r ]"
        val KEY_TODO_REFRESH = "KEY_TODO_REFRESH"
        val KEY_DONE_REFRESH = "KEY_DONE_REFRESH"

        val google_client_id = "69476367223-ppjtpohliu778q9imikbjqc085ha11us.apps.googleusercontent.com"
        val KEY_LOGIN2_INSERT_FLAG = "KEY_LOGIN2_INSERT_FLAG"
        val STICK = "stick"
        val CANCEL = "cancel"
        val ACTION_THIRD_SHARE_QQ = "ACTION_THIRD_SHARE_QQ"
        val ACTION_THIRD_SHARE_QZONE = "ACTION_THIRD_SHARE_QZONE"
        val ACTION_THIRD_SHARE_SINA = "ACTION_THIRD_SHARE_SINA"
        val ACTION_THIRD_SHARE_FACEBOOK = "ACTION_THIRD_SHARE_FACEBOOK"
        val ACTION_THIRD_SHARE_FACEBOOK_MESSAGER = "ACTION_THIRD_SHARE_FACEBOOK_MESSAGER"
        val ACTION_THIRD_SHARE_WHATSAPP = "ACTION_THIRD_SHARE_WHATSAPP"
        val ACTION_THIRD_SHARE_TWITTER = "ACTION_THIRD_SHARE_TWITTER"
        val KEY_REMIND_UI_DATA_ID = "KEY_REMIND_UI_DATA_ID"
        val ACTION_SCREEN_DONE_TODO = "ACTION_SCREEN_DONE_TODO"
        val SP_KEY_BADGE_SWITCH = "SP_KEY_BADGE_SWITCH"
        val ACTION_APP_WIDGET_UPDATE_ALL = "com.xht.widget.UPDATE_ALL"

        interface WX {
            companion object {
                val APP_ID = BuildConfig.WXKey
                val AppSecret = BuildConfig.WXSecret
            }
        }

        interface QQ {
            companion object {
                val APP_ID = BuildConfig.QQAppId
                val APP_KEY = BuildConfig.QQAppKey
            }
        }

        interface Sina {
            companion object {
                val APP_KEY = BuildConfig.SinaAppKey
                val APP_SECRET = BuildConfig.SinaAppSecret
                val REDIRECT_URL = BuildConfig.SinaRedirectUrl
                val SCOPE = BuildConfig.SinaScope
            }
        }

        interface FaceBook {
            companion object {
                val APP_ID = BuildConfig.FBKey
            }
        }

        interface Twitter {
            companion object {
                val KEY = BuildConfig.TwitterKey
                val SECRET = BuildConfig.TwitterSecret
            }
        }

        interface Mta {
            companion object {
                val APP_ID = BuildConfig.MTAID
                val APP_KEY = BuildConfig.MTAKEY
            }
        }

    }
}