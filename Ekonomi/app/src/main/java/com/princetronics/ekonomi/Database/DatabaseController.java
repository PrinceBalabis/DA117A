package com.princetronics.ekonomi.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Prince on 11/5/2014.
 */
public class DatabaseController extends SQLiteOpenHelper {

    // Database
    private static final String DB_NAME = "peopledb";
    private static final int DB_VERSION = 1;
    SQLiteDatabase database;

    public DatabaseController(Context ctx, String anvandare){
        super(ctx, DB_NAME, null, DB_VERSION);
    }

    public void open(){
        database = getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public void save(String fname, String lname){
        ContentValues values = new ContentValues();
        values.put("fname", fname);
        values.put("lname", lname);

        database.insert("peopletable", null, values);
    }

    public Cursor getAllPeople(){
        Cursor c = database.rawQuery("SELECT * from peopletable", new String[]{});
        return c;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE table peopletable (id INTEGER PRIMARY KEY, fname VARCHAR(255), lname VARCHAR(255));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

}
