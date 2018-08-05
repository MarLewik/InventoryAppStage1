package com.example.android.inventoryappstage1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import com.example.android.inventoryappstage1.data.Contract.ItemEntry;
import com.example.android.inventoryappstage1.data.DbHelper;

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mPriceEditText;
    private EditText mQuantityEditText;
    private EditText mSupplierNameEditText;
    private EditText mNumberEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        mNameEditText = (EditText) findViewById(R.id.edit_product_name);
        mPriceEditText = (EditText) findViewById(R.id.edit_product_price);
        mQuantityEditText = (EditText) findViewById(R.id.edit_product_quantity);
        mSupplierNameEditText = (EditText) findViewById(R.id.edit_product_supplier_name);
        mNumberEditText = (EditText) findViewById(R.id.edit_product_supplier_phone);
    }

    /**
     * Get user input from editor and save new to database.
     */
    private void insertItem() {
        String nameString = mNameEditText.getText().toString().trim();
        String priceSring = mPriceEditText.getText().toString().trim();
        int price = Integer.parseInt(priceSring);
        String quantityString = mQuantityEditText.getText().toString().trim();
        int quantity = Integer.parseInt(quantityString);
        String supplierNameString = mSupplierNameEditText.getText().toString().trim();
        String supplierNumberString = mNumberEditText.getText().toString().trim();
        int supplierNumber = Integer.parseInt(supplierNumberString);
        DbHelper mDbHelper = new DbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ItemEntry.COLUMN_PRODUCT_NAME, nameString);
        values.put(ItemEntry.COLUMN_PRICE, price);
        values.put(ItemEntry.COLUMN_QUANTITY, quantity);
        values.put(ItemEntry.COLUMN_SUPPLIER_NAME, supplierNameString);
        values.put(ItemEntry.COLUMN_SUPPLIER_PHONE_NUMBER, supplierNumber);
        long newRowId = db.insert(ItemEntry.TABLE_NAME, null, values);
        if (newRowId == -1) {
            Toast.makeText(this, "Product saving error", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Product saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editor_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                insertItem();
                finish();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
