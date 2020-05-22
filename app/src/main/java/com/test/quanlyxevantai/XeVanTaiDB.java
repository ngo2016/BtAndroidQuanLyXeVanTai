package com.test.quanlyxevantai;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class XeVanTaiDB {
    static SQLiteDatabase database;
    DBHelper dbHelper;

    public XeVanTaiDB(Context context) {
        dbHelper = new DBHelper(context);
        try {
            database = dbHelper.getWritableDatabase();
        } catch (SQLiteException ex) {
            database = dbHelper.getReadableDatabase();
        }

    }

    public void close() {
        dbHelper.close();

    }

    public static Cursor layTatCaDuLieu() {
        // Biến cot là khai báo danh sách các cột cần lấy.
        String[] cot = {DBHelper.COT_ID,
                DBHelper.COT_SOPHIEU,
                DBHelper.COT_NGAY,
                DBHelper.COT_XUATPHAT,
                DBHelper.COT_TUYEN,
                DBHelper.COT_TINH,
                DBHelper.COT_XE};
        Cursor cursor = null;
        cursor = database.query(DBHelper.
                        TEN_BANG_XeVanTai, cot, null, null, null, null,
                DBHelper.COT_ID + " DESC");
        return cursor;
    }

    public static long them(PhieuPhanCong phieuPhanCong) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_SOPHIEU,
                phieuPhanCong.getSoPhieu());
        values.put(DBHelper.COT_NGAY,
                phieuPhanCong.getNgay());
        values.put(DBHelper.COT_XUATPHAT,
                phieuPhanCong.getXuatPhat());
        values.put(DBHelper.COT_TUYEN,
                phieuPhanCong.getTuyen());
        values.put(DBHelper.COT_TINH,
                phieuPhanCong.getTinh());
        values.put(DBHelper.COT_XE,
                phieuPhanCong.getXe());
        return database.insert(DBHelper.
                TEN_BANG_XeVanTai, null, values);
    }

    public static long xoa(PhieuPhanCong phieuPhanCong) {
        return database.delete(DBHelper
                .TEN_BANG_XeVanTai, DBHelper
                .COT_SOPHIEU + " = " + "'" +
                phieuPhanCong.getSoPhieu() + "'", null);
    }

    public static long sua(PhieuPhanCong phieuPhanCong) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_SOPHIEU,
                phieuPhanCong.getSoPhieu());
        values.put(DBHelper.COT_NGAY,
                phieuPhanCong.getNgay());
        values.put(DBHelper.COT_XUATPHAT,
                phieuPhanCong.getXuatPhat());
        values.put(DBHelper.COT_TUYEN,
                phieuPhanCong.getTuyen());
        values.put(DBHelper.COT_TINH,
                phieuPhanCong.getTinh());
        values.put(DBHelper.COT_XE,
                phieuPhanCong.getXe());
        return database.update(DBHelper
                        .TEN_BANG_XeVanTai, values,
                DBHelper.COT_SOPHIEU + " = "
                        + phieuPhanCong.getSoPhieu(), null);
    }
}
