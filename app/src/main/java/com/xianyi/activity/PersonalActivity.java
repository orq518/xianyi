package com.xianyi.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.xianyi.R;
import com.xianyi.customviews.TitleView;


/**
 * ${todo}<个人资料>
 *
 * @author lht
 * @data: on 15/11/3 09:38
 */
public class PersonalActivity extends BaseActivity implements View.OnClickListener{
    private static final String LTAG = PersonalActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;
    /** 返回 **/
    private ImageView mBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        mContext = this;

        initViews();
    }

    public void initViews() {
        mBack =(ImageView) findViewById(R.id.im_back);

        mBack.setOnClickListener(this);

        showView();
    }

    /**
     * 显示数据
     */
    private void showView() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            // 返回
            case R.id.im_back:
                finish();
                break;
            default:
                break;
        }
    }
}
