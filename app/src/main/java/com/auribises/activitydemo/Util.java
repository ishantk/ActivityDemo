package com.auribises.activitydemo;

import android.net.Uri;

/**
 * Created by ishantkumar on 04/12/17.
 */

public class Util {

    // DB Related Info
    public static final String DB_NAME = "users.db";
    public static final int DB_VERSION = 1;


    // Table Related Info
    public static final String TAB_NAME = "USER";

    public static final String COL_ID = "_ID";
    public static final String COL_NAME = "NAME";
    public static final String COL_PHONE = "PHONE";
    public static final String COL_PASSWORD = "PASSWORD";

    public static final String CREATE_TAB_QUERY = "create table USER(" +
            "_ID integer primary key autoincrement," +
            "NAME varchar(256)," +
            "PHONE varchar(16)," +
            "PASSWORD varchar(256)" +
            ")";

    // URI for Table
    public static final Uri uri = Uri.parse("content://com.auribises.mycp/"+TAB_NAME);

}
