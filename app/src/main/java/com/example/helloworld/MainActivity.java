package com.example.helloworld;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button toSecond = findViewById(R.id.btnToSecond);
        toSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
        Button dialog = findViewById(R.id.btnDialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                View checkBoxLayout = View.inflate(MainActivity.this, R.layout.checkbox, null);
                CheckBox checkBoxAntra = checkBoxLayout.findViewById(R.id.checkboxAntra);
                CheckBox checkBoxKristers = checkBoxLayout.findViewById(R.id.checkboxKristers);
                CheckBox checkBoxJustine = checkBoxLayout.findViewById(R.id.checkboxJustine);
                setListener(checkBoxAntra);
                setListener(checkBoxKristers);
                setListener(checkBoxJustine);
                final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("5. Group's Dialog")
                        .setView(checkBoxLayout)
                        .setPositiveButton("OK", null)
                        .setNegativeButton("Close", null).show();
                Button okButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                okButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "You clicked OK", Toast.LENGTH_SHORT).show();
                    }
                });
                Button closeButton = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "You closed dialog", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });
            }
        });
    }

    public void setListener (CheckBox checkBox){
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                click(checkBox, isChecked);
            }
        });
    }

    public void click(CheckBox checkBox, boolean isChecked) {
        if (isChecked){
            Toast.makeText(MainActivity.this, checkBox.getText().toString()+" checked",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, checkBox.getText().toString()+" unchecked",
                    Toast.LENGTH_SHORT).show();
        }
    }
}