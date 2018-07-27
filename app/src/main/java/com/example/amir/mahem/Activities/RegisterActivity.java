package com.example.amir.mahem.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.amir.mahem.R;

public class RegisterActivity extends AppCompatActivity {

    EditText etUserName, etPhone;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPhone.getText().toString().equals("")) {
                    etPhone.setError("لطفا شماره تلفن خود را وارد کنید");
                    return;
                } else if (etPhone.getText().toString().length() != 11) {
                    etPhone.setError("لطفا شماره تلفن معتبر وارد کنید");
                    return;
                }
                if (etUserName.getText().toString().equals("")) {
                    etUserName.setError("لطفا ام کاربری خود را وارد کنید");
                    return;
                } else if (etUserName.getText().toString().length() > 12 || etUserName.getText().toString().length() < 3) {
                    etUserName.setError("لطفا نام کاربری معتبر وارد کنید");
                    return;
                }
                reg(etUserName.getText().toString(), etPhone.getText().toString());

                Intent i = new Intent(RegisterActivity.this, CodeVerificationActivity.class);
                startActivity(i);

            }
        });
    }

    private void init() {
        etUserName = (EditText) findViewById(R.id.et_name);
        etPhone = (EditText) findViewById(R.id.et_phone);
        btnRegister = (Button) findViewById(R.id.btn_register);
    }

    void reg(String username, String phone) {

    }
}
