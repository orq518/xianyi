package com.xianyi.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xianyi.R;
import com.xianyi.adapter.MyTradeListAdapter;
import com.xianyi.bean.MyTradeListBean;
import com.xianyi.bean.MyXianZhiListBean;
import com.xianyi.customviews.TitleView;
import com.xianyi.customviews.mylist.BaseSwipeAdapter;
import com.xianyi.customviews.mylist.MyListView;
import com.xianyi.customviews.mylist.SimpleSwipeListener;
import com.xianyi.customviews.mylist.SwipeLayout;

import java.util.ArrayList;

/**
 * ${todo}<我的交易页面>
 *
 * @author lht
 * @data: on 15/12/21 16:35
 */
public class MyTradeActivity extends BaseActivity implements View.OnClickListener {
    private static final String LTAG = MyTradeActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;
    /** 顶部布局 **/
    private TitleView mTitleView;
    /** listView **/
    private MyListView mListView;
    /** 适配器 **/
    private MyTradeListAdapter adapter;
    /** 数据源 **/
    private ArrayList<MyTradeListBean> bankList = new ArrayList<MyTradeListBean>();


    private final int MSG_REFRESH = 1000;
    private final int MSG_LOADMORE = 2000;
    protected android.os.Handler mHandler = new android.os.Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_REFRESH:

                    break;

                case MSG_LOADMORE:

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trade);
        mContext = this;

        initViews();
    }

    public void initViews() {
        mTitleView = (TitleView) findViewById(R.id.title);
        mListView = (MyListView) findViewById(R.id.listview);

        setData();

        showView();
    }

    /**
     * 显示数据
     */
    private void showView() {
        // 设置顶部标题布局
        mTitleView.setTitle("我的交易");
        mTitleView.setLeftClickListener(new TitleLeftOnClickListener());

        // 设置listview
        adapter = new MyTradeListAdapter(mContext, bankList);
        mListView.setAdapter(adapter);

        // listview单击
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });


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
            //
            case R.id.btn_login:

                break;

            default:
                break;
        }
    }


    /**
     * 设置数据--测试
     */
    private void setData() {
        MyTradeListBean bModel0 = new MyTradeListBean();
        bModel0.price_now = "￥350";
        bModel0.price_old = "￥400";
        bModel0.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel0.type = "0";
        bModel0.numOrName = "";
        bModel0.tip = "交易已完成";
        bModel0.time = "12分钟前";
        bankList.add(bModel0);

        MyTradeListBean bModel1 = new MyTradeListBean();
        bModel1.price_now = "￥350";
        bModel1.price_old = "￥400";
        bModel1.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel1.type = "1";
        bModel1.numOrName = "火星上的猪";
        bModel1.tip = "申请和你交易";
        bModel1.time = "3小时前";
        bankList.add(bModel1);

        MyTradeListBean bModel2 = new MyTradeListBean();
        bModel2.price_now = "￥350";
        bModel2.price_old = "￥400";
        bModel2.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel2.type = "2";
        bModel2.numOrName = "";
        bModel2.tip = "目前无人问津";
        bModel2.time = "";
        bankList.add(bModel2);

        MyTradeListBean bModel3 = new MyTradeListBean();
        bModel3.price_now = "￥350";
        bModel3.price_old = "￥400";
        bModel3.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel3.type = "3";
        bModel3.numOrName = "天天都开心";
        bModel3.tip = "已经和你交易";
        bModel3.time = "12天前";
        bankList.add(bModel3);

        MyTradeListBean bModel4 = new MyTradeListBean();
        bModel4.price_now = "￥350";
        bModel4.price_old = "￥400";
        bModel4.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel4.type = "4";
        bModel4.numOrName = "过河的松鼠";
        bModel4.tip = "拒绝和你交易";
        bModel4.time = "3小时前";
        bankList.add(bModel4);

        MyTradeListBean bModel5 = new MyTradeListBean();
        bModel5.price_now = "￥350";
        bModel5.price_old = "￥400";
        bModel5.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel5.type = "4";
        bModel5.numOrName = "小甜妞儿";
        bModel5.tip = "还未回复你的申请";
        bModel5.time = "";
        bankList.add(bModel5);
    }
}
