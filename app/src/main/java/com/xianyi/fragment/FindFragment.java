package com.xianyi.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xianyi.customviews.TitleView;
import com.xianyi.utils.LogUtil;
import com.xianyi.R;

import java.util.Random;


/**
 * Created by ouruiqiang on 2015/9/16. 钱包的fragment
 * File for what:
 * ps:
 */
@SuppressWarnings("ALL")
public class FindFragment extends BaseFragment implements View.OnClickListener {

    private String tag = "FindFragment";
    private View mRootView;
    RelativeLayout mMainWalletLaout;
    RelativeLayout mNotIdentityWalletLaout;
    LinearLayout manage_bank_cards_no_cards;
    View mWalletView;
    private TextView mRefersh;
    TitleView titleView;
    private Activity mContext;
    //    private ImageView shopCart;//购物车
    private ViewGroup anim_mask_layout;//动画层
//    private BadgeView buyNumView;//显示购买数量的控件

    int AnimationTime = 30000;//动画时间
    int AnimationTime1 = 800;//动画时间
    ImageView shopTop;
    FrameLayout animation_rootlayout;
    int width, height;

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
        mContext = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == mRootView) {
            mRootView = getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_layout_find, null);
            TitleView mTitleView = (TitleView) mRootView.findViewById(R.id.title);
            mTitleView.setTitle("发现");
            mTitleView.setLeftVisiable(false);

        }
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
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

    Handler mHandler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (width == 0 || height == 0) {
                        animation_rootlayout.measure(0, 0);
                        width = animation_rootlayout.getWidth();
                        height = animation_rootlayout.getHeight();
                    }
                    Random random = new Random();// 定义随机类
                    int result = random.nextInt(width) + 1;// 返回[0,10)集合中的整数，注意不包括10

                    int[] start_location = new int[2];
                    start_location[0] = result - 80;
                    start_location[1] = height - 80;
                    ImageView qiqiu = new ImageView(mContext);// buyImg是动画的图片，我的是一个小球（R.drawable.sign）
                    qiqiu.setImageResource(R.drawable.bg_chat_dis_active);// 设置buyImg的图片
                    setAnim(qiqiu, start_location);// 开始执行动画
                    mHandler.sendEmptyMessageDelayed(1, 10000);
                    break;
                case 2:
                    if (animation_rootlayout != null && animation_rootlayout.getChildCount() > 0) {
                        for (int i = 0; i < animation_rootlayout.getChildCount(); i++) {
                            View view = animation_rootlayout.getChildAt(i);
                            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
                            lp.topMargin = lp.topMargin - 2;
                            view.setLayoutParams(lp);
                            if (lp.topMargin <= 0) {
                                animation_rootlayout.removeView(view);
                            }
                        }
                    }
                    LogUtil.d("11");
                    animation_rootlayout.invalidate();
                    mHandler.sendEmptyMessageDelayed(2, 50);
                    break;
            }
            super.dispatchMessage(msg);
        }
    };

    private void initView() {
        titleView = (TitleView) mRootView.findViewById(R.id.title);
        animation_rootlayout = (FrameLayout) mRootView.findViewById(R.id.animation_rootlayout);
        animation_rootlayout.measure(0, 0);
        width = animation_rootlayout.getWidth();
        height = animation_rootlayout.getHeight();
        shopTop = (ImageView) mRootView.findViewById(R.id.im_top);
//        im_Bottom = (TextView) mRootView.findViewById(R.id.im_Bottom);
    }


    @Override
    public void setVisible(boolean isVisibleToUser) {
        LogUtil.d("find是否显示：" + isVisibleToUser + "    isNeedRefresh:" + isNeedRefresh);
//        if (isVisibleToUser && isNeedRefresh) {
//        } else {
//            ViewGroup rootView = (ViewGroup) mContext.getWindow().getDecorView();
//
//        }
        if (isVisibleToUser) {
            if (animation_rootlayout != null) {
                mHandler.removeMessages(1);
                mHandler.removeMessages(2);
                if(animation_rootlayout != null && animation_rootlayout.getChildCount()==0) {
                    mHandler.sendEmptyMessage(1);
                }else{
                    mHandler.sendEmptyMessageDelayed(1, 10000);
                }
                mHandler.sendEmptyMessage(2);
            } else {
                mHandler.removeMessages(1);
                mHandler.removeMessages(2);
            }
        } else {
            mHandler.removeMessages(1);
            mHandler.removeMessages(2);
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

    /**
     * @param
     * @return void
     * @throws
     * @Description: 创建动画层
     */
    private ViewGroup createAnimLayout() {
        ViewGroup rootView = (ViewGroup) mContext.getWindow().getDecorView();
        LinearLayout animLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        animLayout.setLayoutParams(lp);
        animLayout.setId(Integer.MAX_VALUE);
        animLayout.setBackgroundResource(android.R.color.transparent);
        rootView.addView(animLayout);
        return animLayout;
    }

    private void setAnim(final View mView, int[] start_location) {
//        if (anim_mask_layout == null) {
//        anim_mask_layout = null;
//        anim_mask_layout = createAnimLayout();
//        anim_mask_layout.addView(mView);//把动画小球添加到动画层

//        }
        animation_rootlayout.addView(mView);//把动画小球添加到动画层
        View view = addViewToAnimLayout(mView,
                start_location);
//        int[] end_location = new int[2];// 这是用来存储动画结束位置的X、Y坐标
//        titleView.getLocationInWindow(end_location);// shopCart是那个购物车
//
//        // 计算位移
//        int endY = end_location[1] - start_location[1];// 动画位移的y坐标
//        final TranslateAnimation translateAnimationY = new TranslateAnimation(0, 0,
//                0, endY);
//        translateAnimationY.setInterpolator(new LinearInterpolator());//速率匀速
//        translateAnimationY.setRepeatCount(0);// 动画重复执行的次数
//
//        final AnimationSet set = new AnimationSet(false);
//        set.setFillAfter(false);
//        set.addAnimation(translateAnimationY);
//        set.setDuration(AnimationTime);// 动画的执行时间
//
//        view.startAnimation(set);
//
//        // 动画监听事件
//        set.setAnimationListener(new Animation.AnimationListener() {
//            // 动画的开始
//            @Override
//            public void onAnimationStart(Animation animation) {
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//            }
//
//            // 动画的结束
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                animation_rootlayout.removeView(mView);
//                LogUtil.d("动画结束:" + animation_rootlayout.getChildCount());
//            }
//        });
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "点击气球", Toast.LENGTH_SHORT).show();
                LogUtil.d("111animation_rootlayout.getHeight():" + animation_rootlayout.getChildCount());
                animation_rootlayout.removeView(mView);
//                int[] start_location = new int[2];// 一个整型数组，用来存储按钮的在屏幕的X、Y坐标
//                mView.getLocationInWindow(start_location);// 这是获取购买按钮的在屏幕的X、Y坐标（这也是动画开始的坐标）
//                Log.d("ouou", "start_location[0]:" + start_location[0]);
//                Log.d("ouou", "start_location[1]:" + start_location[1]);
//                ImageView buyImg = new ImageView(mContext);// buyImg是动画的图片，我的是一个小球（R.drawable.sign）
//                buyImg.setImageResource(R.drawable.sign);// 设置buyImg的图片
//                setAnim_AddTop(buyImg, start_location);
//                translateAnimationY.cancel();
                mView.setVisibility(View.GONE);
                LogUtil.d("222animation_rootlayout.getHeight():" + animation_rootlayout.getChildCount());
                int count = animation_rootlayout.getChildCount();
                for (int i = 0; i < count; i++) {

                    View qqview = animation_rootlayout.getChildAt(i);
                    int[] location = new int[2];// 这是用来存储动画结束位置的X、Y坐标
                    qqview.getLocationInWindow(location);// shopCart是那个购物车
                    LogUtil.d("位置:" + location[0] + "     " + location[1]);

                }
            }
        });
    }

    private View addViewToAnimLayout(final View view,
                                     int[] location) {
        int x = location[0];
        int y = location[1];
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.width = 100;
        lp.height = 120;
        lp.leftMargin = x;
        lp.topMargin = y;
        view.setLayoutParams(lp);
        return view;
    }

    private void setAnim_AddTop(final View v, int[] start_location) {
//        if (anim_mask_layout == null) {
        anim_mask_layout = null;
        anim_mask_layout = createAnimLayout();
        anim_mask_layout.addView(v);//把动画小球添加到动画层
//        }
        View view = addViewToAnimLayout(v,
                start_location);
        int[] end_location = new int[2];// 这是用来存储动画结束位置的X、Y坐标
        titleView.getLocationInWindow(end_location);// shopCart是那个购物车
        Log.d("ouou", "##end_location[1]:" + end_location[1]);
        // 计算位移
        int endX = start_location[0];// 动画位移的X坐标
        Log.d("ouou", "##endX:" + endX);
        int endY = end_location[1] - start_location[1];// 动画位移的y坐标
        TranslateAnimation translateAnimationX = new TranslateAnimation(0,
                endX, 0, 0);
        translateAnimationX.setInterpolator(new LinearInterpolator());
        translateAnimationX.setRepeatCount(0);// 动画重复执行的次数
        translateAnimationX.setFillAfter(true);

        TranslateAnimation translateAnimationY = new TranslateAnimation(0, 0,
                0, endY);
        translateAnimationY.setInterpolator(new AccelerateInterpolator());//速率
//        translateAnimationY.setInterpolator(new LinearInterpolator());//速率
        translateAnimationY.setRepeatCount(0);// 动画重复执行的次数
        translateAnimationX.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        set.setFillAfter(false);
        set.addAnimation(translateAnimationY);
        set.addAnimation(translateAnimationX);
        set.setDuration(AnimationTime1);// 动画的执行时间
        view.startAnimation(set);
        // 动画监听事件
        set.setAnimationListener(new Animation.AnimationListener() {
            // 动画的开始
            @Override
            public void onAnimationStart(Animation animation) {
                v.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub
            }

            // 动画的结束
            @Override
            public void onAnimationEnd(Animation animation) {
                v.setVisibility(View.GONE);
//                buyNumView.setText(buyNum + "");//
//                buyNumView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
//                buyNumView.show();
            }
        });
    }

}
