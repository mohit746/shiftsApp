package com.example.shiftsdemo.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.shiftsdemo.R;
import com.example.shiftsdemo.User;
import com.example.shiftsdemo.Utils;
import com.example.shiftsdemo.register.RegisterActivity;
import com.example.shiftsdemo.shifts.ShiftsActivity;

public class LoginActivity extends Activity implements View.OnClickListener, LoginPresenter.View {
    private final String TAG = "LoginActivity";
    private EditText mNameET;
    private EditText mPasswordET;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginPresenter = new LoginPresenter(this, this);

        mNameET = findViewById(R.id.user_name_ET);
        mPasswordET = findViewById(R.id.password_ET);
        Button lLoginButton = findViewById(R.id.login_button);
        Button lRegisterButton = findViewById(R.id.register_button);

        lLoginButton.setOnClickListener(this);
        lRegisterButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                login();
                break;
            case R.id.register_button:
                register();
                break;
            default:
                break;
        }
    }

    private void register() {
        Intent lIntent = new Intent(this, RegisterActivity.class);
        startActivity(lIntent);
    }

    private void login() {
        String userName = mNameET.getText().toString().trim();
        String password = mPasswordET.getText().toString().trim();
        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this, "Please fill username", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!userName.contains("@")) {
            mNameET.setError("Not a valid email");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please fill password", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d(TAG, "login: ");
        mLoginPresenter.loginUser(userName, password);
    }


    @Override
    public void loginResponse(boolean aResult) {
        Log.d(TAG, "loginResponse: got response");
        if (aResult) {
            finish();
            Intent lIntent = new Intent(this, ShiftsActivity.class);
            startActivity(lIntent);
        } else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        }

    }
}
