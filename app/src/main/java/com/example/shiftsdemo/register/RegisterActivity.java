package com.example.shiftsdemo.register;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.shiftsdemo.R;

public class RegisterActivity extends Activity implements View.OnClickListener, RegisterPresenter.View {

    private final String TAG = "RegisterActivity";
    RegisterPresenter mRegisterPresenter;
    EditText mNameET;
    EditText mAgeET;
    EditText mEmailET;
    EditText mPasswordET;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mNameET = findViewById(R.id.name_ET);
        mAgeET = findViewById(R.id.age_ET);
        mEmailET = findViewById(R.id.email_ET);
        mPasswordET = findViewById(R.id.password_ET);

        mRegisterPresenter = new RegisterPresenter(this, this);

        Button lBackButton = findViewById(R.id.back_button);
        Button lSaveButton = findViewById(R.id.save_button);
        lBackButton.setOnClickListener(this);
        lSaveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.save_button:
                register();
                break;
            default:
                break;
        }
    }

    private void register() {
        Log.d(TAG, "register: inside method");
        String name = mNameET.getText().toString().trim();
        String age = mAgeET.getText().toString().trim();
        String email = mEmailET.getText().toString().trim();
        String password = mPasswordET.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Please fill name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(age)) {
            Toast.makeText(this, "Please fill age", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please fill email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please fill password", Toast.LENGTH_SHORT).show();
            return;
        }
        mRegisterPresenter.registerUser(name, age, email, password);
    }

    @Override
    public void registerResponse(boolean aResult) {
        Log.d(TAG, "registerResponse: inside method... " + aResult);
        if (aResult) {
            finish();
        }
    }
}
