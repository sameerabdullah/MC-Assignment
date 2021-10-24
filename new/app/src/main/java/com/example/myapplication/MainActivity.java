package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton radioSilver = findViewById(R.id.RadioButtonSilver);
        radioSilver.setChecked(true);
    }
    public void ResetOnClick(View view){
        TextInputEditText t1 = findViewById(R.id.CashInBank);
        TextInputEditText t2 = findViewById(R.id.CashForFuture);
        TextInputEditText t3 = findViewById(R.id.GivenOutLoans);
        TextInputEditText t4 = findViewById(R.id.InvestmentNShares);
        TextInputEditText t5 = findViewById(R.id.ValueOfGold);
        TextInputEditText t6 = findViewById(R.id.ValueOfSilver);
        TextInputEditText t7 = findViewById(R.id.ValueOfStock);
        TextInputEditText t8 = findViewById(R.id.BorrowedMoney);
        TextInputEditText t9 = findViewById(R.id.WagesEmployees);
        TextInputEditText t10 = findViewById(R.id.TaxesNBills);

        t1.setText(null);
        t2.setText(null);
        t3.setText(null);
        t4.setText(null);
        t5.setText(null);
        t6.setText(null);
        t7.setText(null);
        t8.setText(null);
        t9.setText(null);
        t10.setText(null);


        RadioButton radioGold = findViewById(R.id.RadioButtonGold);
        RadioButton radioSilver = findViewById(R.id.RadioButtonSilver);

        radioGold.setChecked(false);
        radioSilver.setChecked(true);
    }

    public void CalculateZakat(View view){
        TextInputEditText t1 = findViewById(R.id.CashInBank);
        TextInputEditText t2 = findViewById(R.id.CashForFuture);
        TextInputEditText t3 = findViewById(R.id.GivenOutLoans);
        TextInputEditText t4 = findViewById(R.id.InvestmentNShares);
        TextInputEditText t5 = findViewById(R.id.ValueOfGold);
        TextInputEditText t6 = findViewById(R.id.ValueOfSilver);
        TextInputEditText t7 = findViewById(R.id.ValueOfStock);
        TextInputEditText t8 = findViewById(R.id.BorrowedMoney);
        TextInputEditText t9 = findViewById(R.id.WagesEmployees);
        TextInputEditText t10 = findViewById(R.id.TaxesNBills);

        RadioButton radioGold = findViewById(R.id.RadioButtonGold);
        RadioButton radioSilver = findViewById(R.id.RadioButtonSilver);

        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);


        if(String.valueOf(t1.getText()).trim().equals("") || String.valueOf(t2.getText()).trim().equals("") || String.valueOf(t3.getText()).trim().equals("") ||
                String.valueOf(t4.getText()).trim().equals("") || String.valueOf(t5.getText()).trim().equals("") ||
                String.valueOf(t6.getText()).trim().equals("") || String.valueOf(t7.getText()).trim().equals("") ||
                String.valueOf(t8.getText()).trim().equals("") || String.valueOf(t9.getText()).trim().equals("") || String.valueOf(t10.getText()).trim().equals("")
        ){
            builder1.setMessage("Some of the fields is empty, please fill all field\nIf something is zero, then write '0' there.");
        }
        else{
            int cash = Integer.parseInt(String.valueOf(t1.getText()));
            int deposited = Integer.parseInt(String.valueOf(t2.getText()));
            int givenLoan = Integer.parseInt(String.valueOf(t3.getText()));
            int investment = Integer.parseInt(String.valueOf(t4.getText()));
            int goldValue = Integer.parseInt(String.valueOf(t5.getText()));
            int silverValue = Integer.parseInt(String.valueOf(t6.getText()));
            int stockValue = Integer.parseInt(String.valueOf(t7.getText()));
            int borrow = Integer.parseInt(String.valueOf(t8.getText()));
            int wages = Integer.parseInt(String.valueOf(t9.getText()));
            int rent = Integer.parseInt(String.valueOf(t10.getText()));

            double total = cash+deposited+givenLoan+investment+goldValue+silverValue+stockValue-borrow-wages-rent;



            if (radioGold.isChecked())
            {
                if (total>=747954)
                {
                    double zakat = total /40;
                    builder1.setMessage("Net Worth: Rs. "+  total + "\nZakat Payable: Rs. "+ zakat );
                }
                else
                {
                    builder1.setMessage("Zakat Payable: Rs. 0 (Net Worth: Rs. "+total+")" + "\nAccording to gold threshold, you should have min assets of Rs. 747954 (7.5 Tola of Gold)");
                }
            }
            else if(radioSilver.isChecked())
            {
                if (total>=80933)
                {
                    double zakat = total /40;
                    builder1.setMessage("Net Worth: Rs. "+  total + "\nZakat Payable: Rs. "+ zakat );
                }
                else
                {
                    builder1.setMessage("Zakat Payable: Rs. 0 (Net Worth: Rs. "+total+")" + "\nAccording to silver threshold, you should have min assets of Rs. 80933 (52.5 Tola of Silver)");
                }
            }
            else{
                builder1.setMessage("Please select one of the given Nisab Threshold");
            }
        }


        builder1.setCancelable(true);

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }
}