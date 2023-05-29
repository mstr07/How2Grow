package com.example.how2grow;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ManageData {
    private SQLiteDatabase db;

    private static final String DB_NAME = "weight_journal_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "weight_log";

    public static final String TABLE_ROW_ID = "id";
    public static final String TABLE_ROW_DATE = "date";
    public static final String TABLE_ROW_WEIGHT = "weight";

    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper{

        public CustomSQLiteOpenHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String newTableQueryString = "create table "
                    + TABLE_NAME + " ("
                    + TABLE_ROW_ID
                    + " integer primary key autoincrement not null,"
                    + TABLE_ROW_DATE
                    + " text not null,"
                    + TABLE_ROW_WEIGHT
                    + " real not null);";
            db.execSQL(newTableQueryString);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public ManageData(Context context){
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
        db = helper.getWritableDatabase();
    }
    public void insert(String date, double weight){
        String query = "INSERT INTO " + TABLE_NAME + " (" +
                TABLE_ROW_DATE + ", " + TABLE_ROW_WEIGHT + ") " +
                "VALUES (" +
                "'" + date + "'" + ", " + "'" + weight + "');";
        Log.i("insert() = ", query);
        db.execSQL(query);
    }
    public void delete(String date){
        String query = "DELETE FROM " + TABLE_NAME +
                " WHERE " + TABLE_ROW_DATE +
                " = " + date + "';";
        Log.i("delete() = ", query);
    }
    public Cursor selectAll(){
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return c;
    }
}

