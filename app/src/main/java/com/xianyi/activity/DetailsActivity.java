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
 * ${todo}<详情页>
 *
 * @author lht
 * @data: on 15/12/3 09:38
 */
public class DetailsActivity extends BaseActivity implements View.OnClickListener{
    private static final String LTAG = DetailsActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;
    /** 返回 **/
    private ImageView mBack;
    /** 消息 **/
    private ImageView mMessage;
    /** 分享 **/
    private ImageView mShare;
    /** 置顶 **/
    private ImageView mTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mContext = this;

        initViews();
    }

    public void initViews() {
        mBack =(ImageView) findViewById(R.id.im_back);
        mMessage =(ImageView) findViewById(R.id.im_message);
        mShare =(ImageView) findViewById(R.id.im_share);
        mTop =(ImageView) findViewById(R.id.im_gotop);

        mBack.setOnClickListener(this);
        mMessage.setOnClickListener(this);
        mShare.setOnClickListener(this);
        mTop.setOnClickListener(this);

        showView();
    }

    /**
     * 显示数据
     */
    private void showView() {
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
            // 返回
            case R.id.im_back:
                finish();
                break;
            // 消息
            case R.id.im_message:

                break;
            // 分享
            case R.id.im_share:

                break;
            // 置顶
            case R.id.im_gotop:

                break;

            // 收藏
            case R.id.bt_like:

                break;
            // 转发
            case R.id.bt_turn:

                break;
            // 我要了
            case R.id.bt_itake:

                break;
            default:
                break;
        }
    }
}
