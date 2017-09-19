package com.encyclopedias.util;

/**
 * Created by Frank on 2016/4/14.
 */
public interface ConstantPool {
    // PARAMS
    String PARAM_PAGE = "PARAM_PAGE";
    String PARAM_TITLE = "PARAM_TITLE";
    String PARAM_CONTENT = "PARAM_CONTENT";

    String EVENT_TYPE_LOGINSUCCESS = "EVENT_TYPE_LOGINSUCCESS";//登录界面 登录成功事件回调标志
    String EVENT_TYPE_LOGINBACK = "EVENT_TYPE_LOGINBACK";//登录界面 未登录事件回调标志

    // PREFS
    String PREF_ACCESS_TOKEN = "PREF_ACCESS_TOKEN";
    String PARAM_CURRENT_CONTENT = "PARAM_CURRENT_CONTENT";
    String PREF_REFRESH_TOKEN = "PREF_REFRESH_TOKEN";
    String PREF_USER_ID = "PREF_USER_ID";
    String PREF_USER_MOBILE = "PREF_USER_MOBILE";
    String PREF_USER_NICKNAME = "PREF_USER_NICKNAME";
    String PREF_USER_AVATAR = "PREF_USER_AVATAR";
    String PREF_UNREAD_MESSAGE_COUNT = "PREF_UNREAD_MESSAGE_COUNT";
    String PARAM_ID = "PARAM_ID";
    String PARAM_ID_1 = "PARAM_ID_1";
    String PARAM_NAME = "PARAM_NAME";
    String PARAM_GENDER = "PARAM_GENDER";
    String PARAM_AGE = "PARAM_AGE";
    String PARAM_TYPE = "PARAM_TYPE";
    String PARAM_FLAG = "PARAM_FLAG";
    String PARAM_FLAG_2 = "PARAM_FLAG_2";
    String PARAM_FLAG_ACTION = "PARAM_FLAG_ACTION";
    String PARAM_FLAG_ACTION_DATA = "PARAM_FLAG_ACTION_DATA";
    String SEARCH_HISTORY_HOSP = "SEARCH_HISTORY_HOSP";
    String SEARCH_HISTORY_DOC = "SEARCH_HISTORY_DOC";
    String PARAM_DATE = "PARAM_DATE";
    String PARAM_CONTENT_1 = "PARAM_CONTENT_1";
    String ACTION_NOTICE = "ACTION_NOTICE";
    String ACTION_RELOGIN = "ACTION_RELOGIN";
    int ACTION_DELETE_PACS = 0x1000011;


    /**
     * 版本号,如果版本更新时更新了引导图，则将"VERSION_CODE"名改变即可,没有更新则不改变；
     * 为了统一，更改策略为：
     * VERSION_CODE="VERSION_CODE_1"
     * VERSION_CODE="VERSION_CODE_2"
     * VERSION_CODE="VERSION_CODE_3"
     * 。。。。。。
     * 以此类推
     */
    String VERSION_CODE = "VERSION_CODE_1";
    String DATA_EMPTY = "EMPTY_DATA";
}