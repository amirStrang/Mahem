package com.example.amir.mahem.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.amir.mahem.R;

public class CodeVerificationActivity extends AppCompatActivity {

    EditText etCode;
    Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_verification);

        init();

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etCode.getText().toString().equals("")) {
                    etCode.setError("کد را وارد کنید");
                    return;
                }
                save(etCode.getText().toString());
            }
        });
    }

    private void init() {

        etCode = (EditText) findViewById(R.id.et_code);
        btnVerify = (Button) findViewById(R.id.btn_verify);
    }

    private void save(String code) {
        //
    }
}
