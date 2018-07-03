
package com.example.hp.solite;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText email,password;
    Button loginBtn,registrationBtn,deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailtx);
        password = findViewById(R.id.pswdtx);
        loginBtn = findViewById(R.id.button5);
        registrationBtn = findViewById(R.id.button6);
        deleteBtn = findViewById(R.id.button7);




        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(email.getText().toString())){
                    email.setError("Field is Failed");
                    return;
                }

                if (TextUtils.isEmpty(password.getText().toString())){
                    password.setError("Field is Failed");
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("submit continue");
                builder.setMessage("Are you sure to continue");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,SecondActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        finish();
                    }
                });

                }

        });


        registrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,EditActivity.class);
                startActivity(intent);
            }
        });




    }
}
