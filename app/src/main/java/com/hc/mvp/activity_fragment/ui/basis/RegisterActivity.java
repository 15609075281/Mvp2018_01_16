package com.hc.mvp.activity_fragment.ui.basis;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.coorchice.library.SuperTextView;
import com.hc.mvp.R;
import com.hc.mvp.activity_fragment.Manager.BaseActivity;
import com.hc.mvp.activity_fragment.mvp.persenter.LoginPersenter;
import com.hc.mvp.activity_fragment.mvp.view.LoginView;
import com.jingewenku.abrahamcaijin.commonutil.AppToastMgr;

/**
 * Created by Administrator on 2018/2/27.
 */
public class RegisterActivity extends BaseActivity implements LoginView {

    SuperTextView back;
    TextView register;
    EditText name;
    EditText password;

    LoginPersenter loginPersenter;

    Context context = RegisterActivity.this;

    @Override
    public int inti() {
        loginPersenter = new LoginPersenter(this);
        return R.layout.registeractivity_xml;
    }

    @Override
    public void findview() {
        back = (SuperTextView) findViewById(R.id.back1);
        register = (TextView) findViewById(R.id.register);
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.pwd);
        back.setOnClickListener(listener);
        register.setOnClickListener(listener);
    }

    android.view.View.OnClickListener listener = new android.view.View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.back1:
                    finish();
                    break;

                case R.id.register:
                    loginPersenter.start_Register();
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
        return password.getText().toString();
    }

    @Override
    public void onLoginSuccess(String success) {
        AppToastMgr.Toast(context, success);
        finish();
    }

    @Override
    public void onLoginError(String error) {
        AppToastMgr.Toast(context, error);
    }
}
