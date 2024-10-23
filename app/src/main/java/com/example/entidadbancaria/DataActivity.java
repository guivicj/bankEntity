package com.example.entidadbancaria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DataActivity extends AppCompatActivity {
    private TextView txtBalance;
    private EditText editBalance;
    private double balance = 1000.00;

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_data);

        txtBalance = findViewById(R.id.txtBalance);
        editBalance = findViewById(R.id.editBalance);

        String dni = getIntent().getStringExtra("dni");
        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText("Welcome, " + dni);

        findViewById(R.id.btnDeposit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidad = Integer.parseInt(editBalance.getText().toString());
                balance += cantidad;
                updateBalance();
            }
        });

        findViewById(R.id.btnWithdraw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int amount = Integer.parseInt(editBalance.getText().toString());
                if (balance >= amount) {
                    balance -= amount;
                    updateBalance();
                } else {
                    Toast.makeText(DataActivity.this, "Not Enough Balance", Toast.LENGTH_SHORT).show();
                }
            }

        });

        findViewById(R.id.btnExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DataActivity.this, Bank.class));
            }
        });

    }

    private void updateBalance() {
        txtBalance.setText("Balance: " + balance + "€");
    }
}
