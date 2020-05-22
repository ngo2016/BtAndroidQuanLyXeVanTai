package com.test.quanlyxevantai;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Tên cơ sở dữ liệu
    public static final String TEN_DATABASE = "QuanLyXeVanTai";
    // Tên bảng
    public static final String TEN_BANG_XeVanTai = "XeVanTai";
    // Bảng gồm 3 cột _id, _ten và _lop.
    public static final String COT_ID = "id";
    public static final String COT_SOPHIEU = "sophieu";
    public static final String COT_NGAY = "ngay";
    public static final String COT_XUATPHAT = "xuatphat";
    public static final String COT_TUYEN = "tuyen";
    public static final String COT_TINH = "tinh";
    public static final String COT_XE = "xe";

    private static final String TAO_BANG_XeVanTai = ""
            + "create table " + TEN_BANG_XeVanTai + " ( "
            + COT_ID + " integer primary key autoincrement ,"
            + COT_SOPHIEU + " text not null, "
            + COT_NGAY + " text not null, "
            + COT_XUATPHAT + " text not null, "
            + COT_TUYEN + " text not null, "
            + COT_TINH + " text not null, "
            + COT_XE + " text not null );";


    public DBHelper(Context context) {
        super(context, TEN_DATABASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TAO_BANG_XeVanTai);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
