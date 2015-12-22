package com.xianyi.activity;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.xianyi.R;
import com.xianyi.adapter.HistoryListAdapter;
import com.xianyi.adapter.MyCollectListAdapter;
import com.xianyi.bean.HistoryListBean;
import com.xianyi.bean.MyCollectListBean;
import com.xianyi.customviews.TitleView;
import com.xianyi.customviews.mylist.MyListView;

import java.util.ArrayList;

/**
 * ${todo}<浏览历史页面>
 *
 * @author lht
 * @data: on 15/12/21 16:35
 */
public class HistoryActivity extends BaseActivity implements View.OnClickListener {
    private static final String LTAG = HistoryActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;
    /** 顶部布局 **/
    private TitleView mTitleView;
    /** listView **/
    private MyListView mListView;
    /** 适配器 **/
    private HistoryListAdapter adapter;
    /** 数据源 **/
    private ArrayList<HistoryListBean> bankList = new ArrayList<HistoryListBean>();


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
        setContentView(R.layout.activity_history);
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
        mTitleView.setTitle("我的浏览历史");
        mTitleView.setLeftClickListener(new TitleLeftOnClickListener());

        // 设置listview可以加载、刷新
        mListView.setPullLoadEnable(true);
        mListView.setPullRefreshEnable(true);
        adapter = new HistoryListAdapter(mContext, bankList);
        mListView.setAdapter(adapter);

        // listview单击
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });

        // 设置回调函数
        mListView.setMyListViewListener(new MyListView.IMyListViewListener() {

            @Override
            public void onRefresh() {
                // 模拟刷新数据，1s之后停止刷新
                mHandler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        mListView.stopRefresh();
                        Toast.makeText(HistoryActivity.this, "refresh",
                                Toast.LENGTH_SHORT).show();
                        mHandler.sendEmptyMessage(MSG_REFRESH);
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    // 模拟加载数据，1s之后停止加载
                    @Override
                    public void run() {
                        mListView.stopLoadMore();
                        Toast.makeText(HistoryActivity.this, "loadMore",
                                Toast.LENGTH_SHORT).show();
                        mHandler.sendEmptyMessage(MSG_LOADMORE);
                    }
                }, 1000);
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
        HistoryListBean bModel0 = new HistoryListBean();
        bModel0.state = "";
        bModel0.price_now = "￥350";
        bModel0.price_old = "￥400";
        bModel0.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel0.type = "0";
        bankList.add(bModel0);

        HistoryListBean bModel1 = new HistoryListBean();
        bModel1.state = "";
        bModel1.price_now = "￥350";
        bModel1.price_old = "￥400";
        bModel1.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel1.type = "0";
        bankList.add(bModel1);

        HistoryListBean bModel2 = new HistoryListBean();
        bModel2.state = "此宝贝已换";
        bModel2.price_now = "￥350";
        bModel2.price_old = "￥400";
        bModel2.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel2.type = "1";
        bankList.add(bModel2);

        HistoryListBean bModel3 = new HistoryListBean();
        bModel3.state = "此宝贝已被卖家删除";
        bModel3.price_now = "￥350";
        bModel3.price_old = "￥400";
        bModel3.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel3.type = "1";
        bankList.add(bModel3);

    }
}
