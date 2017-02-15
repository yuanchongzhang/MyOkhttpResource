package com.zhangyu.myophttpopen.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zhangyu.myophttpopen.R;
import com.zhangyu.myophttpopen.mvpmodel.LoginPresenter;
import com.zhangyu.myophttpopen.mvpmodel.LoginPresenterImpl;
import com.zhangyu.myophttpopen.mvpmodel.LoginView;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {


    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError("登陆失败");
    }

    @Override
    public void setPasswordError() {
        //password.setError(getString("密码错误"));
        password.setError("登陆失败");
    }

    @Override
    public void navigateToHome() {
// TODO       startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
        hideProgress();
//        finish();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }


}
