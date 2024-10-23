package com.example.entidadbancaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText inputDNI, inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputDNI = findViewById(R.id.input_dni);
        inputPassword = findViewById(R.id.input_password);

        findViewById(R.id.enter_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dni = inputDNI.getText().toString();
                String pass = inputPassword.getText().toString();

                if (!dni.isEmpty() && !pass.isEmpty()) {
                    Intent intent = new Intent(LoginActivity.this, DataActivity.class);
                    intent.putExtra("dni", dni);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Denied Access", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.exit_app).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Bank.class));
            }
        });
    }
}
