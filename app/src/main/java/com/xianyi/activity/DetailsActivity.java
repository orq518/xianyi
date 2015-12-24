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
 * ${todo}<详情页>
 *
 * @author lht
 * @data: on 15/12/3 09:38
 */
public class DetailsActivity extends BaseActivity implements View.OnClickListener{
    private static final String LTAG = DetailsActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mContext = this;

        initViews();
    }

    public void initViews() {

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
