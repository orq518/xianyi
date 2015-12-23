package com.xianyi.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.xianyi.R;
import com.xianyi.customviews.TitleView;

/**
 * ${todo}<设置页面>
 *
 * @author lht
 * @data: on 15/11/2 16:35
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener{
    private static final String LTAG = SettingActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;
    /** 顶部布局 **/
    private TitleView mTitleView;
    /** 个人资料 **/
    private RelativeLayout mLYPersonal;
    /** 分享给朋友 **/
    private RelativeLayout mLYShare;
    /** 给个好评 **/
    private RelativeLayout mLYHaoping;
    /** 意见反馈 **/
    private RelativeLayout mLYFeedback;
    /** 版本更新 **/
    private RelativeLayout mLYVersionUpdate;
    /** 关于我们 **/
    private RelativeLayout mLYAbout;
    /** 清除缓存 **/
    private RelativeLayout mLYCache;
    /** 退出登录 **/
    private Button mBTOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        mContext = this;

        initViews();
    }

    public void initViews() {
        mTitleView = (TitleView) findViewById(R.id.title);
        mLYPersonal = (RelativeLayout) findViewById(R.id.ly_personal);
        mLYShare = (RelativeLayout) findViewById(R.id.ly_share);
        mLYHaoping = (RelativeLayout) findViewById(R.id.ly_haoping);
        mLYFeedback = (RelativeLayout) findViewById(R.id.ly_feedback);
        mLYVersionUpdate = (RelativeLayout) findViewById(R.id.ly_version_update);
        mLYAbout = (RelativeLayout) findViewById(R.id.ly_about);
        mLYCache = (RelativeLayout) findViewById(R.id.ly_cache);
        mBTOut = (Button) findViewById(R.id.out);

        mLYPersonal.setOnClickListener(this);
        mLYShare.setOnClickListener(this);
        mLYHaoping.setOnClickListener(this);
        mLYFeedback.setOnClickListener(this);
        mLYVersionUpdate.setOnClickListener(this);
        mLYAbout.setOnClickListener(this);
        mLYCache.setOnClickListener(this);
        mBTOut.setOnClickListener(this);

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
            // 个人资料
            case R.id.ly_personal:

                break;
            // 分享给朋友
            case R.id.ly_share:

                break;
            // 给个好评
            case R.id.ly_haoping:

                break;
            // 意见反馈
            case R.id.ly_feedback:

                break;
            // 版本更新
            case R.id.ly_version_update:

                break;
            // 关于我们
            case R.id.ly_about:

                break;
            // 清除缓存
            case R.id.ly_cache:

                break;

            // 退出登录
            case R.id.out:

                break;

            default:
                break;
        }
    }
}
