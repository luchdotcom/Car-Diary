package com.F95230.cardiary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.F95230.cardaiary.R;

public class CarActivity extends Activity {

    Button btnAddCar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_activity);
        String userName = getIntent().getStringExtra("user");
        Toast.makeText(this, "welcome "+ userName, Toast.LENGTH_SHORT).show();

        btnAddCar = findViewById(R.id.addCar);

        btnAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CarActivity.this,AddNewCar.class);
                startActivity(intent);
            }
        });
    }

    public void addRepairs(View view) {

    }

    public void addTaxes(View view) {
    }

    public void addTrips(View view) {
    }
}


