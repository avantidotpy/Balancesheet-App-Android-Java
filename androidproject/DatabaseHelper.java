package com.example.gayatri.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Avantika Mahalingam on 30/06/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "incomendexpense.db";
    public static final String TABLE_NAME = "income_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MONTH";
    public static final String COL_3 = "YEAR";
    public static final String COL_4 = "TYPE";
    public static final String COL_5 = "AMOUNT";
    public static final String COL_6 = "DESCRIPTION";
    public static final String COL_7 = "DATE";


    public static final String TABLE_NAME1 = "expense_table";
    public static final String COL_11 = "ID";
    public static final String COL_21 = "MONTH";
    public static final String COL_31 = "YEAR";
    public static final String COL_41 = "TYPE";
    public static final String COL_51 = "AMOUNT";
    public static final String COL_61 = "DESCRIPTION";
    public static final String COL_71 = "DATE";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase db = this.getWritableDatabase();
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,MONTH TEXT,YEAR INTEGER,TYPE TEXT," +
                "AMOUNT INTEGER,DESCRIPTION TEXT,DATE TEXT)");
        db.execSQL("create table " + TABLE_NAME1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,MONTH TEXT,YEAR INTEGER,TYPE TEXT," +
                "AMOUNT INTEGER,DESCRIPTION TEXT,DATE TEXT)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);

    }

    public boolean insertData(String month, String year, String type,String amount,String description,String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, month);
        contentValues.put(COL_3, year);
        contentValues.put(COL_4, type);
        contentValues.put(COL_5, amount);
        contentValues.put(COL_6, description);
        contentValues.put(COL_7, date);
        long result = db.insert(TABLE_NAME, null, contentValues);//we store this in the result because the insert function returns -1 in case of not inserted and the newly inserted column value in case it is not returned
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData1(String month, String year, String type,String amount,String description,String date) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_21, month);
        contentValues.put(COL_31, year);
        contentValues.put(COL_41, type);
        contentValues.put(COL_51, amount);
        contentValues.put(COL_61, description);
        contentValues.put(COL_71, date);
        long result = db1.insert(TABLE_NAME1, null, contentValues);//we store this in the result because the insert function returns -1 in case of not inserted and the newly inserted column value in case it is not returned
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COL_2, COL_3, COL_4,COL_5,COL_6,COL_7}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor;
        } else {
            return null;
        }

    }

    public Cursor getAll0() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.query(TABLE_NAME1, new String[]{COL_21, COL_31, COL_41,COL_51,COL_61,COL_71}, null, null, null, null, null);
        if (cursor1 != null) {
            cursor1.moveToFirst();
            return cursor1;
        } else {
            return null;
        }
    }
}
