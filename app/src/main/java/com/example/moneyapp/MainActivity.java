package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button btn_submit;
    private Button btn_signout;
    private EditText income_num;
    private double income_value;
    public static final String INCOME_VALUE = "income value";
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        btn_submit = findViewById(R.id.btnSubmit);
        income_num = findViewById(R.id.editTextIncome);
        btn_signout = findViewById(R.id.btnSignOut);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!income_num.getText().toString().isEmpty()) {
                    income_value = Double.parseDouble(income_num.getText().toString());
                } else {
                    income_value = 0;
                }
                Intent intent = new Intent(getApplicationContext(), IncomeDetailsActivity.class);
                intent.putExtra(INCOME_VALUE, income_value);
                startActivity(intent);
            }
        });

        btn_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}