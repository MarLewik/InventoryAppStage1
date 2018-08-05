package com.example.android.inventoryappstage1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.inventoryappstage1.data.Contract.ItemEntry;

/**
 * Created by marcin on 08/04/2018.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "inventoryappproducts.db";

    public static final String LOG_TAG = DbHelper.class.getSimpleName();

    public DbHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ITEMS_TABLE =  "CREATE TABLE " + ItemEntry.TABLE_NAME + " ("
                + ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ItemEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + ItemEntry.COLUMN_PRICE + " INTEGER NOT NULL, "
                + ItemEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0, "
                + ItemEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL, "
                + ItemEntry.COLUMN_SUPPLIER_PHONE_NUMBER + " INTEGER NOT NULL);";
        db.execSQL(SQL_CREATE_ITEMS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}
