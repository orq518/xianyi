package com.xianyi.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;

import com.xianyi.R;
import com.xianyi.customviews.residelayout.SlidingMenu;
import com.xianyi.fragment.BaseFragment;
import com.xianyi.fragment.ClassifyFragment;
import com.xianyi.fragment.FindFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private SlidingMenu mMenu;
    Handler mHandler = new Handler() {
    };

    // 分类
    public static final int HOME_TAB_INDEX_0 = 0;
    // 发现
    public static final int HOME_TAB_INDEX_1 = 1;
    // 消息
    public static final int HOME_TAB_INDEX_2 = 2;
    // 积分
    public static final int HOME_TAB_INDEX_3 = 3;

    private ClassifyFragment mHomeFragment0;
    private FindFragment mHomeFragment1;
    private FindFragment mHomeFragment2;
    private FindFragment mHomeFragment3;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMenu = (SlidingMenu) findViewById(R.id.id_menu);
        mFragmentManager = getSupportFragmentManager();
        onTabSelected(0);
    }

    public void initFragment() {
        mHomeFragment0 = new ClassifyFragment();
        mHomeFragment1 = new FindFragment();

    }

    public void toggleMenu(View view) {
        mMenu.toggle();
    }


    public void onTabSelected(int index) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (index) {
            case HOME_TAB_INDEX_0:
                hideFragments(transaction);
                if (null == mHomeFragment0) {
                    mHomeFragment0 = new ClassifyFragment();
                    transaction.add(R.id.center_layout, mHomeFragment0, "0");
                } else {
                    transaction.show(mHomeFragment0);
                }
                setFragmentVerisiable(mHomeFragment0, 0);

                break;
            case HOME_TAB_INDEX_1:
                hideFragments(transaction);
                if (null == mHomeFragment1) {
                    mHomeFragment1 = new FindFragment();
                    transaction.add(R.id.center_layout, mHomeFragment1, "1");
                } else {
                    transaction.show(mHomeFragment1);
                }
                setFragmentVerisiable(mHomeFragment1, 1);
                break;
            case HOME_TAB_INDEX_2:
            case HOME_TAB_INDEX_3:
            default:
                break;
        }
        transaction.commitAllowingStateLoss();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (null != mHomeFragment0) {
            transaction.hide(mHomeFragment0);
        }
        if (null != mHomeFragment1) {
            transaction.hide(mHomeFragment1);
        }
        if (null != mHomeFragment2) {
            transaction.hide(mHomeFragment2);
        }
        if (null != mHomeFragment3) {
            transaction.hide(mHomeFragment3);
        }
    }
    public void setFragmentVerisiable(final BaseFragment fagment, final int index) {
        if (mHandler == null) {
            mHandler = new Handler() {
            };
        }
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                if (fagment != null) {
//                    fagment.setVisible(true);
//                }
                    switch(index){
                        case 0:
                            if(mHomeFragment0!=null) {
                                mHomeFragment0.setVisible(true);
                            }
                            if(mHomeFragment1!=null) {
                                mHomeFragment1.setVisible(false);
                            }
                            if(mHomeFragment2!=null) {
                                mHomeFragment1.setVisible(false);
                            }
                            if(mHomeFragment3!=null) {
                                mHomeFragment1.setVisible(false);
                            }
                            break;
                        case 1:
                            if(mHomeFragment0!=null) {
                                mHomeFragment0.setVisible(false);
                            }
                            if(mHomeFragment1!=null) {
                                mHomeFragment1.setVisible(true);
                            }
                            if(mHomeFragment2!=null) {
                                mHomeFragment2.setVisible(false);
                            }
                            if(mHomeFragment3!=null) {
                                mHomeFragment3.setVisible(false);
                            }
                            break;
                        case 2:
                            if(mHomeFragment0!=null) {
                                mHomeFragment0.setVisible(false);
                            }
                            if(mHomeFragment1!=null) {
                                mHomeFragment1.setVisible(false);
                            }
                            if(mHomeFragment2!=null) {
                                mHomeFragment2.setVisible(true);
                            }
                            if(mHomeFragment3!=null) {
                                mHomeFragment3.setVisible(false);
                            }
                            break;
                        case 3:
                            if(mHomeFragment0!=null) {
                                mHomeFragment0.setVisible(false);
                            }
                            if(mHomeFragment1!=null) {
                                mHomeFragment1.setVisible(false);
                            }
                            if(mHomeFragment2!=null) {
                                mHomeFragment2.setVisible(false);
                            }
                            if(mHomeFragment3!=null) {
                                mHomeFragment3.setVisible(true);
                            }
                            break;
                    }
            }
        }, 400);
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() != null) {
            String tag = (String) v.getTag();
            if (tag.equals("tab0")) {
                onTabSelected(0);
            } else if (tag.equals("tab1")) {
                onTabSelected(1);
            } else if (tag.equals("tab2")) {

            } else if (tag.equals("tab3")) {
                onTabSelected(2);
            } else if (tag.equals("tab4")) {
                onTabSelected(3);
            }
        }

    }

}
