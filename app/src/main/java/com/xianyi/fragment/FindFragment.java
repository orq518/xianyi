package com.xianyi.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xianyi.R;
import com.xianyi.customviews.TitleView;
import com.xianyi.utils.LogUtil;


/**
 * Created by ouruiqiang on 2015/9/16. 钱包的fragment
 * File for what:
 * ps:
 */
public class FindFragment extends BaseFragment implements  View.OnClickListener{

    private String tag = "FindFragment";
    private View mRootView;
    RelativeLayout mMainWalletLaout;
    RelativeLayout mNotIdentityWalletLaout;
    LinearLayout manage_bank_cards_no_cards;
    View mWalletView;
    private Context mCtx;
    private TextView mRefersh;

    @Override
    public String getFragmentName() {
        return tag;
    }

    /**
     * ***生命周期******
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCtx = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == mRootView) {
            mRootView = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_layout_find, null);
           TitleView mTitleView = (TitleView) mRootView.findViewById(R.id.title);
            mTitleView.setTitle("发现");
            mTitleView.setLeftVisiable(false);

        }
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //钱包的
        initView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initView() {

    }


    @Override
    public void setVisible(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtil.d("是否显示：" + isVisibleToUser + "    isNeedRefresh:" + isNeedRefresh);
        if (isVisibleToUser && isNeedRefresh) {
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            // 刷新重试
//            case R.id.not_identity_tv:
//                // 未认证就去联网获取认证信息
//                if(mWealthPresenter==null){
//                    mWealthPresenter=new WealthPresenter(mCtx, this);
//                }
//                mWealthPresenter.getData(UcfWalletApplication.getSelf().getToken());
//                break;

        }
    }
}
