package com.F95230.cardiary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.F95230.cardaiary.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText etUser,etPass;
    Button btnLog;
    TextView infoLogin;
    private  int  counter = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUser =findViewById(R.id.etUsername);
        etPass = findViewById(R.id.etPass);

        btnLog = findViewById(R.id.btnLog);
        infoLogin = findViewById(R.id.tvInfo);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validations(etUser.getText().toString(),etPass.getText().toString());
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void validations(String userName, String userPass){

        if (userName.equals("user")&& userPass.equals("1234")){
            Intent intent = new Intent(MainActivity.this,CarActivity.class);
            startActivity(intent);
        }else {
            counter--;
            infoLogin.setText(" No of attempts "+ counter);
            if (counter == 0) {
                btnLog.setEnabled(false);
            }
        }
    }
}