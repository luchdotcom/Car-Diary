package com.F95230.cardiary;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.F95230.cardaiary.R;

public class AddNewCar  extends Activity {
    EditText etCar,etModel,etFuel,etDataOfManufacture,etReg;
    Button insertButton;
    String carSaveStr,modelSaveStr,fuelSaveStr,dataOfManufactureSaveStr,regSaveStr;

    MyDataBaseHelper dbHelper;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_car_activity);

        // инициираме MyDataBaseHelper в onCreate метода на MainActivity.java
        dbHelper = new MyDataBaseHelper(this);

        // отваряме БД за четене и запис
        database = dbHelper.getWritableDatabase();

        etCar = findViewById(R.id.etCar);
        etFuel = findViewById(R.id.etFuel);
        etModel = findViewById(R.id.etModel);
        etDataOfManufacture = findViewById(R.id.etDataOfManufacture);
        etReg = findViewById(R.id.etReg);


        insertButton = findViewById(R.id.saveCar);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carSaveStr = etCar.getText().toString().trim();
                modelSaveStr = etModel.getText().toString().trim();
                fuelSaveStr = etFuel.getText().toString().trim();
                dataOfManufactureSaveStr = etDataOfManufacture.getText().toString().trim();
                regSaveStr = etReg.getText().toString().trim();

                if (etCar.length() != 0 &&modelSaveStr.length()!=0 &&fuelSaveStr.length()!=0
                                                          &&dataOfManufactureSaveStr.length()!=0 &&regSaveStr.length()!=0) {

                    // добавяне на запис
                    String insertQuery = "INSERT INTO " +
                            MyDataBaseHelper.TABLE_NAME + " ("
                            + MyDataBaseHelper.COLUMN_USER_NAME + ") VALUES ('"
                            + carSaveStr + "')";

                    database.execSQL(insertQuery);

//                    ContentValues values = new ContentValues();
//                    values.put(MyDataBaseHelper.COLUMN_USER_NAME, nameSaveStr);
//                    database.insert(MyDataBaseHelper.TABLE_NAME, null, values);

                    Intent intent = new Intent(AddNewCar.this, DataActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(AddNewCar.this, getString(R.string.full_fields), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        // затваряме връзката с БД
        database.close();
        dbHelper.close();
        super.onDestroy();
    }
}