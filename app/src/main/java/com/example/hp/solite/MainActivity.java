package com.example.hp.solite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText name,password,phoneNo,type;
     Button button;
    private  DBClass dbClass;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.nametx);
        password = findViewById(R.id.pswdtx);
        type = findViewById(R.id.textView3);
        phoneNo = findViewById(R.id.numbertx);
        button = findViewById(R.id.btn);

        dbClass = new DBClass(this);

        dbClass.onAddData("name","password","type","No");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String userName = name.getText().toString();
                String userPswd = password.getText().toString();
                String userType = type.getText().toString();
                String userPNo = phoneNo.getText().toString();

               boolean isSuccesfull = dbClass.onAddData(userName,userPswd,userType,userPNo);

               if (isSuccesfull){
                   Toast.makeText(MainActivity.this, "Succesful add", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                   startActivity(intent);

               }else {
                   Toast.makeText(MainActivity.this, "Unsuccesful", Toast.LENGTH_SHORT).show();
               }

            }
        });

        }
}
