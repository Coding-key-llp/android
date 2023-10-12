package com.example.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;
import android.service.autofill.FieldClassification;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class signin extends AppCompatActivity {
    EditText username,password;
    Button signInBtn;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username = findViewById(R.id.signin_uid);
        password= findViewById(R.id.signin_pid);
        signInBtn = findViewById(R.id.signin);
        Bundle bundle = getIntent().getExtras();
        String uname = bundle.getString("username");
        String pwd = bundle.getString("password");

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals(uname) && pass.equals(pwd))

                { //Toast.makeText(signin.this, "Success",
                        //Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(signin.this, success.class);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                else {
                    count++;
                    if (count >= 3) {
                        signInBtn.setEnabled(false);
                    }

                    else {
                        Toast.makeText(signin.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}