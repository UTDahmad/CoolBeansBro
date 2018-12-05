package com.coolbeansbro.contactsmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Database class that will eventually be used to store contacts
 *
 * @author Ahmed Khan
 * @version 0.1
 */
public class DatabaseController extends SQLiteOpenHelper {

//intialize contacts database name
public static final String DB_NAME = "contactDB";


    //Set up database controller constructor
    public DatabaseController(Context context) {

        super(context, DB_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
