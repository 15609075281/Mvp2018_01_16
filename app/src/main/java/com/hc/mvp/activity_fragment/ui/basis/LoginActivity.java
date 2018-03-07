package com.hc.mvp.activity_fragment.ui.basis;


import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.hc.mvp.R;
import com.hc.mvp.activity_fragment.Manager.BaseActivity;
import com.hc.mvp.activity_fragment.mvp.persenter.LoginPersenter;
import com.hc.mvp.activity_fragment.mvp.view.LoginView;
import com.jingewenku.abrahamcaijin.commonutil.AppToastMgr;

/**
 * Created by Administrator on 2018/1/17.
 */
public class LoginActivity extends BaseActivity implements LoginView {
    public static final String TAG = "LoginActivity";

    EditText name;
    EditText pwd;

    TextView login1;
    TextView register;

    LoginPersenter loginPersenter;

    @Override
    public int inti() {
        loginPersenter = new LoginPersenter(this);
        return R.layout.loginactivity_xml;
    }

    @Override
    public void findview() {
        login1 = (TextView) this.findViewById(R.id.login1);
        register = (TextView) this.findViewById(R.id.register);
        name = (EditText) this.findViewById(R.id.name);
        pwd = (EditText) this.findViewById(R.id.pwd);
        login1.setOnClickListener(lister);
        register.setOnClickListener(lister);
    }

    android.view.View.OnClickListener lister = new android.view.View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.login1:
                    Log.e(TAG, "开始请求登录");
                    loginPersenter.start_Login();
                    break;
                case R.id.register:
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                    break;

                default:
            }

        }
    };

    @Override
    public String getUsername() {
        return name.getText().toString();
    }

    @Override
    public String getPassword() {
        return pwd.getText().toString();
    }

    @Override
    public void onLoginSuccess(String Success) {
        AppToastMgr.Toast(LoginActivity.this, Success);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(com.hc.mvp.activity_fragment.ui.basis.LoginActivity.this, com.hc.mvp.activity_fragment.ui.mainbody.MainActivity.class));
    }

    @Override
    public void onLoginError(String Error) {
        AppToastMgr.Toast(LoginActivity.this, Error);
    }

}
