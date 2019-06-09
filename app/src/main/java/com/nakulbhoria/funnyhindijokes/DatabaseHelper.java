package com.nakulbhoria.funnyhindijokes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "LikedJokes";

    // Table columns
    public static final String _ID = "_id";
    public static final String JOKE = "joke";

    // Database Information
    static final String DB_NAME = "likedJokes.DB";

    // database version
    static final int DB_VERSION = 1;

    private SQLiteDatabase database;

    // Creating table query
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + JOKE + " TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void open() throws SQLException {
        database = this.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void add(String joke) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(JOKE, joke);

        DB.insert(TABLE_NAME, null, contentValues);

    }

    public int update(long _id, String joke) {
        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(JOKE, joke);

        int count = database.update(TABLE_NAME, contentValues, this._ID + " = " + _id, null);
        return count;
    }
    public void delete(String joke)
    {
        SQLiteDatabase DB = this.getWritableDatabase();

        DB.delete(TABLE_NAME, JOKE + "='" + joke +"'", null);
    }
    public Cursor getAllJokes()
    {

        SQLiteDatabase DB = this.getWritableDatabase();
        String rawQuery = "delete from " + TABLE_NAME + " where " + _ID +" not in (select min(" + _ID+") from " + TABLE_NAME +
                " group by " + JOKE + ");";
        DB.execSQL(rawQuery);
        String[] projection = {
                _ID, JOKE,
        };

        Cursor cursor = DB.query(TABLE_NAME, projection, null, null, null, null, null);

        return cursor;
    }


    public Cursor getJoke(String jokePassedIn)
    {
        SQLiteDatabase DB = this.getWritableDatabase();

Cursor cursor = DB.rawQuery("SELECT " + _ID + " FROM " + TABLE_NAME + " WHERE " + JOKE + "='" + jokePassedIn + "'", null);

        return cursor;

    }
}
