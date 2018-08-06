package com.example.android.inventoryappstage1.data;

import android.provider.BaseColumns;

/**
 * Created by marcin on 08/04/2018.
 */

public final class Contract {
    private Contract(){}
    public static abstract class ProductEntry implements BaseColumns{
        public static final String TABLE_NAME = "products";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER_NAME = "supplierName";
        public static final String COLUMN_SUPPLIER_PHONE_NUMBER = "supplierPhoneNumber";
    }
}