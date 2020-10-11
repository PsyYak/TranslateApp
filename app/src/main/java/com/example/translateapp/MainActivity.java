package com.example.translateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mannan.translateapi.Language;
import com.mannan.translateapi.TranslateAPI;

public class MainActivity extends AppCompatActivity {
    int i;
    EditText etInput;
    TextView tvResult;
    Button btnTranslate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setVars();

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TranslateAPI translateAPI = new TranslateAPI(
                        Language.AUTO_DETECT,   //Source Language
                        Language.ENGLISH,         //Target Language
                        etInput.getText().toString());           //Query Text


                translateAPI.setTranslateListener(new TranslateAPI.TranslateListener() {
                    @Override
                    public void onSuccess(String translatedText) {
                        tvResult.setText(translatedText);
                    }

                    @Override
                    public void onFailure(String translatedText) {

                    }
                });
                }

        });

    } // onCreate ends




    private void setVars(){

        etInput = findViewById(R.id.etInput);
        tvResult = findViewById(R.id.tvResult);
        btnTranslate = findViewById(R.id.btnTranslate);


    }
}