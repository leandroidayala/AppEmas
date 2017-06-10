package com.example.leo_i019213.appemas.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class HelperUser extends SQLiteOpenHelper {

    private static final String LOGTAG = "LOGTAG";
    public static final String DATABASE_NAME = "emas.sqlite";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_STATUS = "status";

    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_EMAIL + " TEXT," +
                    COLUMN_USERNAME + " TEXT," +
                    COLUMN_PASSWORD + " TEXT," +
                    COLUMN_STATUS + " TEXT" +
                    ")";

    public static final String TABLE_CARS = "cars";
    public static final String COLUMN_ROUTE = "route";
    public static final String COLUMN_NEIGHBORHOD = "neighborhood";

    public static final String TABLE_CREATE_CARS =
            "CREATE TABLE " + TABLE_CARS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ROUTE + " TEXT, " +
                    COLUMN_NEIGHBORHOD + " TEXT" +
                    ")";

    public static final String TABLE_FAVORITES_CARS_USERS="favoritesCarsUsers";
    public static final String COLUMN_ID_USER = "idUser";
    public static final String COLUMN_ID_CAR = "idcar";

    public static final String TABLE_CREATE_FAVORITES =
            "CREATE TABLE " + TABLE_FAVORITES_CARS_USERS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ID_USER + " INTEGER, " +
                    COLUMN_ID_CAR + " INTEGER" +
                    ")";


    public HelperUser(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_CARS);
        db.execSQL(TABLE_CREATE_FAVORITES);
        Log.i(LOGTAG, "Tabla de usuarios creada correctamente.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CARS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FAVORITES_CARS_USERS);
        onCreate(db);
    }
}
