package com.example.moneyapp;

import java.text.DecimalFormat;

public class Income {

    private double income_value;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Income(double income_value) {
        this.income_value = income_value;
    }

    public String getFoodValue() {
        double food_value = income_value * BudgetConfig.FOOD_BUDGET/100;
        return df.format(food_value);
    }

    public String getTransportValue() {
        double transport_value = income_value * BudgetConfig.TRANSPORT_BUDGET/100;
        return df.format(transport_value);
    }

    public String getSavingsValue() {
        double savings_value = income_value * BudgetConfig.SAVINGS_BUDGET/100;
        return df.format(savings_value);
    }
}
