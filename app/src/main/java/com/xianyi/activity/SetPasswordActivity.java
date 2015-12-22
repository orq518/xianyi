package com.xianyi.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xianyi.R;
import com.xianyi.customviews.TitleView;


/**
 * ${todo}<设置密码>
 *
 * @author lht
 * @data: on 15/11/3 09:38
 */
public class SetPasswordActivity extends BaseActivity implements View.OnClickListener{
    private static final String LTAG = SetPasswordActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;
    /** 顶部布局 **/
    private TitleView mTitleView;
    /** 手机号 **/
    private EditText mETPhone;
    /** 验证码 **/
    private EditText mETSmsCode;
    /** 密码 **/
    private EditText mETPassword;
    /** 确认密码 **/
    private EditText mETConfirmPassword;
    /** 重获验证码 **/
    private TextView mTVCodeAgain;
    /** 确认 **/
    private Button mBTConfirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);
        mContext = this;

        initViews();
    }

    public void initViews() {
        mTitleView = (TitleView) findViewById(R.id.title);

        mETPhone = (EditText) findViewById(R.id.et_user_phone);
        mETSmsCode = (EditText) findViewById(R.id.et_sms_code_resetpw);
        mETPassword = (EditText) findViewById(R.id.et_password_resetpw);
        mETConfirmPassword = (EditText) findViewById(R.id.et_confirm_password_resetpw);
        mTVCodeAgain = (TextView) findViewById(R.id.tv_get_verify_code_again_resetpw);
        mBTConfirm = (Button) findViewById(R.id.btn_confirm);

        mTVCodeAgain.setOnClickListener(this);
        mBTConfirm.setOnClickListener(this);

        // 设置登录按钮
        setNextBtnState(true);

        showView();
    }

    /**
     * 显示数据
     */
    private void showView() {
        // 设置顶部标题布局
        mTitleView.setTitle("账号密码设置");
        mTitleView.setLeftClickListener(new TitleLeftOnClickListener());
    }

    /**
     * 顶部布局--按钮事件监听
     */
    public class TitleLeftOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            // 获取验证码
            case R.id.tv_get_verify_code_again_resetpw:

                break;
            // 提交
            case R.id.btn_confirm:

                break;
            default:
                break;
        }
    }

    /**
     * 去除EditText的空格
     *
     * @param et
     * @return
     */
    public String getData(EditText et) {
        String s = et.getText().toString();
        return s.replaceAll(" ", "");
    }

    /**
     * 设置下一步按钮
     *
     * @param flag
     */
    private void setNextBtnState(boolean flag) {
        if (mBTConfirm == null)
            return;
        mBTConfirm.setEnabled(flag);
        mBTConfirm.setClickable(flag);
    }
}
