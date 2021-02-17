package com.example.mygym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    Button btnsubmit, btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnsubmit = findViewById(R.id.btnsubmit);
        btnsignup = findViewById(R.id.btnsignup);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ValUsername = edtUsername.getText().toString();
                String ValPassword = edtPassword.getText().toString();

                if (!Patterns.EMAIL_ADDRESS.matcher(ValUsername).matches()) {
                    Toast.makeText(LogIn.this, "Email format is invalid", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (ValUsername.equals("admin@gmail.com") && ValPassword.equals("admin")) {

                    Intent intent = new Intent(LogIn.this, MainActivity.class);
                    intent.putExtra("Username", ValUsername);
                    startActivity(intent);
                    Toast.makeText(LogIn.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(LogIn.this, "Username or Password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}