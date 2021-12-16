package com.example.moneyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class IncomeDetailsActivity extends AppCompatActivity {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    TextView foodValue;
    TextView foodPercentage;
    TextView transportValue;
    TextView transportPercentage;
    TextView savingsValue;
    TextView savingsPercentage;
    TextView incomeText;
    Income personBudget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_details);
        bindData();
        calculateBudget();
    }

    private void bindData() {
        incomeText = findViewById(R.id.incomeValueText);
        foodValue = findViewById(R.id.food_value);
        foodPercentage = findViewById(R.id.food_percentage);
        transportValue = findViewById(R.id.transport_value);
        transportPercentage = findViewById(R.id.transport_percentage);
        savingsValue = findViewById(R.id.savings_value);
        savingsPercentage = findViewById(R.id.savings_percentage);

        Intent intent = getIntent();
        Double income_value = intent.getDoubleExtra(MainActivity.INCOME_VALUE, 0);
        personBudget = new Income(income_value);
        incomeText.setText(getString(R.string.MYR) + " " + df.format(income_value));
    }

    private void calculateBudget() {
        foodValue.setText(getString(R.string.MYR) + " " + personBudget.getFoodValue());
        transportValue.setText(getString(R.string.MYR) + " " + personBudget.getTransportValue());
        savingsValue.setText(getString(R.string.MYR) + " " + personBudget.getSavingsValue());
        foodPercentage.setText(BudgetConfig.FOOD_BUDGET + getString(R.string.PERCENTAGE));
        transportPercentage.setText(BudgetConfig.TRANSPORT_BUDGET + getString(R.string.PERCENTAGE));
        savingsPercentage.setText(BudgetConfig.SAVINGS_BUDGET + getString(R.string.PERCENTAGE));
    }
}