package com.xianyi.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xianyi.activity.BigClassifyActivity;
import com.xianyi.adapter.ClassifyMainListAdapter;
import com.xianyi.bean.ClassifyMainListBean;
import com.xianyi.customviews.TitleView;
import com.xianyi.customviews.mylist.MyListView;
import com.xianyi.customviews.residelayout.FindTab2Layout;
import com.xianyi.utils.LogUtil;
import com.xianyi.R;

import java.util.ArrayList;
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
    //    TitleView titleView;
    private Activity mContext;
    //    private ImageView shopCart;//购物车
    private ViewGroup anim_mask_layout;//动画层
//    private BadgeView buyNumView;//显示购买数量的控件

    int boomTime = 3000;//动画时间

    int AnimationTime = 30000;//动画时间
    int AnimationTime1 = 800;//动画时间
    FrameLayout mainlayout;
    FrameLayout tab1_layout;
    FindTab2Layout tab2_layout;
    int mainwidth, mainheight;
    /**
     * 气球最大
     */
    int maxWidth = 100;
    int qiqiuID[] = new int[5];
    int screenWidth;
    TextView title_left, title_right, tv_num;
    int curTab = 0;
    int number = 0;

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

        }
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);

        screenWidth = wm.getDefaultDisplay().getWidth();
        qiqiuID[0] = R.drawable.pic_bubble1;
        qiqiuID[1] = R.drawable.pic_bubble2;
        qiqiuID[2] = R.drawable.pic_bubble3;
        qiqiuID[3] = R.drawable.pic_bubble4;
        qiqiuID[4] = R.drawable.pic_bubble5;
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
                    if (mainwidth == 0 || mainheight == 0) {
                        tab1_layout.measure(0, 0);
                        mainwidth = mainlayout.getWidth();
                        mainheight = mainlayout.getHeight();
                    }
                    Random random = new Random();// 定义随机类
                    int result = random.nextInt(mainwidth) + 1;// 返回[0,10)集合中的整数，注意不包括10

                    int[] start_location = new int[2];
                    start_location[0] = result;
                    if (start_location[0] < 80) {
                        start_location[0] = 80;
                    } else if (start_location[0] + 160 > mainwidth) {
                        start_location[0] = mainwidth - 160;
                    }
                    start_location[1] = mainheight - 80;
                    ImageView qiqiu = new ImageView(mContext);// buyImg是动画的图片，我的是一个小球（R.drawable.sign）
                    int index = result % 5;
                    qiqiu.setImageResource(qiqiuID[index]);// 设置buyImg的图片
                    setAnim1(qiqiu, start_location);// 开始执行动画
                    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) qiqiu.getLayoutParams();
                    maxWidth = 2 * params.width + 30;
                    mHandler.sendEmptyMessageDelayed(1, boomTime);
                    break;
                case 2:

                    if (tab1_layout != null && tab1_layout.getChildCount() > 0) {
//                        LogUtil.d("####tab1_layout.getChildCount():"+tab1_layout.getChildCount());
                        for (int i = 0; i < tab1_layout.getChildCount(); i++) {
                            View view = tab1_layout.getChildAt(i);
                            Object tag = view.getTag();
                            if (tag != null && tag.equals("1")) {
                                continue;
                            }

                            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) view.getLayoutParams();
                            lp.topMargin = lp.topMargin - 5;
                            if (lp.topMargin > mainheight / 3) {
                                if (lp.width < maxWidth) {
                                    lp.width = lp.width + 1;
                                    lp.height = lp.height + 1;
                                }
                            } else {
                                if (lp.width > maxWidth / 2) {
                                    lp.width = lp.width - 1;
                                    lp.height = lp.height - 1;
                                }
                            }


                            view.setLayoutParams(lp);
                            if (lp.topMargin <= 0) {
                                tab1_layout.removeView(view);
                            }
                        }
                    }
                    tab1_layout.invalidate();
                    mHandler.sendEmptyMessageDelayed(2, 20);
                    break;
            }
            super.dispatchMessage(msg);
        }
    };


    private void initView() {
        tab1_layout= (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.fragment_layout_find_tab1, null);
        tab2_layout= new FindTab2Layout(mContext);
        tv_num = (TextView) mRootView.findViewById(R.id.tv_num);
        title_left = (TextView) mRootView.findViewById(R.id.title_left);
        title_right = (TextView) mRootView.findViewById(R.id.title_right);
        title_left.setOnClickListener(this);
        title_right.setOnClickListener(this);
        titleClick(curTab);
        mainlayout = (FrameLayout) mRootView.findViewById(R.id.mainlayout);
        mainlayout.measure(0, 0);
        mainwidth = mainlayout.getWidth();
        mainheight = mainlayout.getHeight();
        mainlayout.addView(tab1_layout);
        setNum();
//        im_Bottom = (TextView) mRootView.findViewById(R.id.im_Bottom);
    }

    public void setNum() {
        if (number == 0) {
            tv_num.setVisibility(View.GONE);
        } else {
            tv_num.setVisibility(View.VISIBLE);
            tv_num.setText("" + number);
        }
    }

    public void titleClick(int index) {
        switch (index) {
            case 0:
                LogUtil.d("点左");
                title_left.setBackgroundResource(R.drawable.title_corner_left_selected);
                title_right.setBackgroundResource(R.drawable.title_corner_right_normal);
                curTab = index;
                if(mainlayout!=null) {
                    mainlayout.removeAllViews();
                    mainlayout.addView(tab1_layout);
                    startQiqiuAnimation(true);
                }
                break;
            case 1:
                LogUtil.d("点右");
                title_left.setBackgroundResource(R.drawable.title_corner_left_normal);
                title_right.setBackgroundResource(R.drawable.title_corner_right_selected);
                curTab = index;
                if(mainlayout!=null) {
                    mainlayout.removeAllViews();
                    mainlayout.addView(tab2_layout);
                }
                startQiqiuAnimation(false);
                break;
        }
    }

    @Override
    public void setVisible(boolean isVisibleToUser) {
        LogUtil.d("find是否显示：" + isVisibleToUser + "    isNeedRefresh:" + isNeedRefresh);
//        if (isVisibleToUser && isNeedRefresh) {
//        } else {
//            ViewGroup rootView = (ViewGroup) mContext.getWindow().getDecorView();
//
//        }
        startQiqiuAnimation(isVisibleToUser);

    }
public void startQiqiuAnimation(boolean isstart){
    if (isstart) {
        if (tab1_layout != null) {
            mHandler.removeMessages(1);
            mHandler.removeMessages(2);
            if (tab1_layout != null && tab1_layout.getChildCount() == 0) {
                mHandler.sendEmptyMessage(1);
            } else {
                mHandler.sendEmptyMessageDelayed(1, boomTime);
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
            case R.id.title_left:
                titleClick(0);
                break;
            case R.id.title_right:
                titleClick(1);
                break;
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
    PopupWindow popupWindow;
    private void showPopUp(final View view) {

        LinearLayout relativeLayout = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.find_pop_layout, null);
         popupWindow = new PopupWindow(relativeLayout,
                mainwidth * 2 / 3, ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        int[] location = new int[2];//参考控件的位置
        view.getLocationOnScreen(location);
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        relativeLayout.measure(w, h);
        int height = relativeLayout.getMeasuredHeight();
        int width = relativeLayout.getMeasuredWidth();

        LogUtil.d("##location[0]:" + location[0]);
        LogUtil.d("##location[1]:" + location[1]);
        LogUtil.d("##maxWidth:" + screenWidth);
        int offsetX = 0, offsetY = 0;
        if (location[0] < screenWidth / 3 && location[1] - height > 100) {//弹出框在右上
            offsetX = location[0] + view.getWidth() / 2;
            offsetY = location[1] - height;
            relativeLayout.setBackgroundResource(R.drawable.pop_bubble_righttop);
            LogUtil.d("右上");
        } else if (location[0] < screenWidth / 3 && location[1] - height <= 100) {//右下
            offsetX = location[0] + view.getWidth() / 2;
            offsetY = location[1] + view.getHeight();
            relativeLayout.setBackgroundResource(R.drawable.pop_bubble_rightbottom);
            LogUtil.d("右下");
        } else if ((location[0] >= screenWidth / 3 && location[0] < screenWidth * 2 / 3) && location[1] - height > 100) {//上方
            offsetX = location[0] - view.getWidth() / 2;
            ;
            offsetY = location[1] - height;
            relativeLayout.setBackgroundResource(R.drawable.pop_bubble_top);
            LogUtil.d("上方");
        } else if ((location[0] >= screenWidth / 3 && location[0] < screenWidth * 2 / 3) && location[1] - height <= 100) {//下方
            offsetX = location[0] - view.getWidth() / 2;
            offsetY = location[1] + view.getHeight();
            relativeLayout.setBackgroundResource(R.drawable.pop_bubble_bottom);
            LogUtil.d("下方");
        } else if (location[0] > screenWidth * 2 / 3 && location[1] - height > 100) {//左上
            offsetX = location[0] - width;
            offsetY = location[1] - height;
            relativeLayout.setBackgroundResource(R.drawable.pop_bubble_lefttop);
            LogUtil.d("左上");
        } else if (location[0] > screenWidth * 2 / 3 && location[1] - height <= 100) {//左下
            offsetX = location[0] - width;
            offsetY = location[1] + view.getHeight();
            relativeLayout.setBackgroundResource(R.drawable.pop_bubble_leftbottom);
            LogUtil.d("左下");
        } else {
            offsetX = location[0] + view.getWidth() / 2;
            offsetY = location[1] - height;
            relativeLayout.setBackgroundResource(R.drawable.pop_bubble_righttop);
        }

        popupWindow.showAsDropDown(relativeLayout, offsetX, offsetY);


        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        Button ok_bt= (Button) relativeLayout.findViewById(R.id.ok);
        ok_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;
                popupWindow.dismiss();
                int[] start_location = new int[2];// 一个整型数组，用来存储按钮的在屏幕的X、Y坐标
                view.getLocationInWindow(start_location);// 这是获取购买按钮的在屏幕的X、Y坐标（这也是动画开始的坐标）
                ImageView buyImg = new ImageView(mContext);// buyImg是动画的图片，我的是一个小球（R.drawable.sign）
                buyImg.setImageResource(R.drawable.sign);// 设置buyImg的图片
                setAnim(buyImg, start_location);// 开始执行动画
                tab1_layout.removeView(view);
            }
        });
        Button cancel_bt= (Button) relativeLayout.findViewById(R.id.cancel);
        cancel_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                tab1_layout.removeView(view);
            }
        });
    }

    private void setAnim1(final View mView, int[] start_location) {
        tab1_layout.addView(mView);//把动画小球添加到动画层
        View view = addViewToAnimLayout(mView,
                start_location);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mContext, "点击气球", Toast.LENGTH_SHORT).show();
                LogUtil.d("tab1_layout.getHeight():" + tab1_layout.getChildCount());
                mView.setTag("1");
                showPopUp(view);
            }
        });
    }

    //
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

    private View addViewToAnimLayout(final ViewGroup vg, final View view,
                                     int[] location) {
        int x = location[0];
        int y = location[1];
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = x;
        lp.topMargin = y;
        view.setLayoutParams(lp);
        return view;
    }

    private void setAnim(final View v, int[] start_location) {
        anim_mask_layout = null;
        anim_mask_layout = createAnimLayout();
        anim_mask_layout.addView(v);//把动画小球添加到动画层
        final View view = addViewToAnimLayout(anim_mask_layout, v,
                start_location);
        int[] end_location = new int[2];// 这是用来存储动画结束位置的X、Y坐标
        title_right.getLocationInWindow(end_location);// shopCart是那个购物车

        // 计算位移
        int endX = end_location[0] - start_location[0] + title_right.getWidth()-10;// 动画位移的X坐标
        int endY = end_location[1] - start_location[1];// 动画位移的y坐标
//        LogUtil.d("11endX:" + endX);
//        LogUtil.d("11endY:" + endY);
        TranslateAnimation translateAnimationX = new TranslateAnimation(0,
                endX, 0, 0);
        translateAnimationX.setInterpolator(new LinearInterpolator());
        translateAnimationX.setRepeatCount(0);// 动画重复执行的次数
        translateAnimationX.setFillAfter(true);

        TranslateAnimation translateAnimationY = new TranslateAnimation(0, 0,
                0, endY);
        translateAnimationY.setInterpolator(new AccelerateInterpolator());
        translateAnimationY.setRepeatCount(0);// 动画重复执行的次数
        translateAnimationX.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        set.setFillAfter(false);
        set.addAnimation(translateAnimationY);
        set.addAnimation(translateAnimationX);
        set.setDuration(800);// 动画的执行时间
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
                setNum();
            }
        });

    }


}
