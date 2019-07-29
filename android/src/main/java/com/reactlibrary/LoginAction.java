package com.reactlibrary;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import com.reactlibrary.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
    模拟原生登录页面
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText et_account, et_name;
    private Button btn_login;
    private EditText et_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ytx_activity_login);
        et_account = (EditText) findViewById(R.id.et_account);
        btn_login = (Button) findViewById(R.id.btn_login);
        et_name = (EditText) findViewById(R.id.et_name);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        btn_login.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String account = et_account.getText().toString();
            String name = et_name.getText().toString();
            // if (TextUtils.isEmpty(account) || TextUtils.isEmpty(name)) {
            //     ToastUtil.showMessage("ID和名字两者都必须填写");
            //     return;
            // }
        }
    };
}
