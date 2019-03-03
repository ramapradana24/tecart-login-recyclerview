package com.laksita.ramapradana.loginbasic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private final static String NAME_USER = "Technology Artisan";
    private final static String USERNAME_USER = "tecart";
    private final static String PASSWORD_USER = "tecart2019";
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private String usernameInput, passwordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        initialize variable to layout
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

//        on button login click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameInput = etUsername.getText().toString();
                passwordInput = etPassword.getText().toString();

                boolean anyError = false;
                if(usernameInput.equals("")){
                    etUsername.setError("username tidak boleh kosong");
                    anyError = true;
                }

                if(passwordInput.equals("")){
                    etPassword.setError("password tidak boleh kosong");
                    anyError = true;
                }

                if(!anyError){
                    if(usernameInput.equals(USERNAME_USER) && passwordInput.equals(PASSWORD_USER)){
//                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
//                        Insert data to shared preferences
                        SharedPreferences profile = getSharedPreferences("profile", Context.MODE_PRIVATE);
                        SharedPreferences.Editor profileEditor = profile.edit();
                        profileEditor.putString("nama", NAME_USER);
                        profileEditor.putString("username", USERNAME_USER);
                        profileEditor.apply();

//                        intent to Main Activity
                        Intent toMainActivity = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(toMainActivity);
                        finish();

                    }else{
                        etUsername.setError("Username atau password salah");
                        etUsername.requestFocus();
                        etPassword.setText("");
                    }
                }
            }
        });
    }
}
