package com.example.sqliteqlsach.dao;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

import com.example.sqliteqlsach.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "QLSACH.SQLITE";
    public static final int DB_VERSION = 1;

    Activity context;
    public static class Table implements BaseColumns{
        private static final String TABLE_NAME = "SACH";
        private static final String COL_MA = "MASACH";
        private static final String COL_TEN = "TENSACH";
        private static final String COL_TACGIA = "TACGIA";
        private static final String COL_NAMXB = "NAMXB";

    }

    public DBHelper(Activity context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + Table.TABLE_NAME +" ( " + Table.COL_MA +" INT PRIMARY KEY, "
            +Table.COL_TEN + " VARCHAR(50) , " + Table.COL_TACGIA +" VARCHAR(50), " + Table.COL_NAMXB +" INT )";

    public static final String DROP_TABLE="DROP TABLE IF EXISTS " + Table.TABLE_NAME;


        public List<Sach> getAllSach()
    {
        List<Sach> list;

        list = new ArrayList<>();


        String [] projection={
                Table.COL_MA,
                Table.COL_TEN,
                Table.COL_TACGIA,
                Table.COL_NAMXB
        };

        Cursor cursor = getReadableDatabase().query(
                Table.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );


        while(cursor.moveToNext())
        {
            Sach sach = new Sach();
            sach.setMa(cursor.getInt(cursor.getColumnIndexOrThrow(Table.COL_MA)));
            sach.setTen(cursor.getString(cursor.getColumnIndexOrThrow(Table.COL_TEN)));
            sach.setTacgia(cursor.getString(cursor.getColumnIndexOrThrow(Table.COL_TACGIA)));
            sach.setNamXB(cursor.getInt(cursor.getColumnIndexOrThrow(Table.COL_NAMXB)));
            list.add(sach);
        }
        cursor.close();
        return list;

    }

    public void remove(Sach sach)
    {
        SQLiteDatabase database = getWritableDatabase();
        String selection = Table.COL_MA  + " = ?";
        String [] selectionArgs = {sach.getMa()+""};
        database.delete(Table.TABLE_NAME, selection,selectionArgs);
    }



    public void insert(Sach sach)
    {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Table.COL_MA,sach.getMa());
        values.put(Table.COL_TEN, sach.getTen());
        values.put(Table.COL_TACGIA, sach.getTacgia());
        values.put(Table.COL_NAMXB,sach.getNamXB());

        database.insert(Table.TABLE_NAME, null, values);
    }

    public void QueryData(String sql)
    {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
