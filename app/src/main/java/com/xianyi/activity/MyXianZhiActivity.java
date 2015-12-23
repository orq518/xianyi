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
import com.xianyi.adapter.HistoryListAdapter;
import com.xianyi.bean.HistoryListBean;
import com.xianyi.bean.MyXianZhiListBean;
import com.xianyi.customviews.TitleView;
import com.xianyi.customviews.mylist.BaseSwipeAdapter;
import com.xianyi.customviews.mylist.MyListView;
import com.xianyi.customviews.mylist.SimpleSwipeListener;
import com.xianyi.customviews.mylist.SwipeLayout;

import java.util.ArrayList;

/**
 * ${todo}<我的闲置页面>
 *
 * @author lht
 * @data: on 15/12/21 16:35
 */
public class MyXianZhiActivity extends BaseActivity implements View.OnClickListener {
    private static final String LTAG = MyXianZhiActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;
    /** 顶部布局 **/
    private TitleView mTitleView;
    /** listView **/
    private MyListView mListView;
    /** 适配器 **/
    private ListAdapter adapter;
    /** 数据源 **/
    private ArrayList<MyXianZhiListBean> bankList = new ArrayList<MyXianZhiListBean>();


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
        setContentView(R.layout.activity_my_xianzhi);
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
        mTitleView.setTitle("我的闲置");
        mTitleView.setLeftClickListener(new TitleLeftOnClickListener());

        // 设置listview可以加载、刷新
        mListView.setPullLoadEnable(true);
        mListView.setPullRefreshEnable(true);
        adapter = new ListAdapter(mContext);
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
                        Toast.makeText(MyXianZhiActivity.this, "refresh",
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
                        Toast.makeText(MyXianZhiActivity.this, "loadMore",
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

    public class ListAdapter extends BaseSwipeAdapter {
        // 上下文对象
        private Context mContext;
        private ImageView im_my_xianzhi_icon;
        private TextView gv_my_xianzhi_price_now;
        private TextView gv_my_xianzhi_price_old;
        private TextView tv_my_xianzhi_context;
        private TextView tv_my_xianzhi_num;
        private TextView tv_my_xianzhi_tip;
        private TextView tv_my_xianzhi_time;

        // 构造函数
        public ListAdapter(Context mContext) {
            this.mContext = mContext;
        }

        // SwipeLayout的布局id
        @Override
        public int getSwipeLayoutResourceId(int position) {
            return R.id.swipe;
        }

        @Override
        public View generateView(final int position, ViewGroup parent) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.activity_my_xianzhi_item, parent, false);
            final SwipeLayout swipeLayout = (SwipeLayout) v.findViewById(getSwipeLayoutResourceId(position));

            // 当隐藏的删除menu被打开的时候的回调函数
            swipeLayout.addSwipeListener(new SimpleSwipeListener() {
                @Override
                public void onOpen(SwipeLayout layout) {
                    Toast.makeText(mContext, "Open", Toast.LENGTH_SHORT).show();
                }
            });

            // 双击的回调函数
            swipeLayout.setOnDoubleClickListener(new SwipeLayout.DoubleClickListener() {
                @Override
                public void onDoubleClick(SwipeLayout layout,
                                          boolean surface) {
                    Toast.makeText(mContext, "DoubleClick",
                            Toast.LENGTH_SHORT).show();
                }
            });

            // 添加删除布局的点击事件
            v.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    Toast.makeText(mContext, "delete", Toast.LENGTH_SHORT).show();
                    // 点击完成之后，关闭删除menu
                    swipeLayout.close();
                    bankList.remove(position);
                    notifyDataSetChanged();
                }
            });

            // 添加编辑布局的点击事件
            v.findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    Toast.makeText(mContext, "delete", Toast.LENGTH_SHORT).show();
                    // 点击完成之后，关闭删除menu
                    swipeLayout.close();
                    bankList.remove(position);
                    notifyDataSetChanged();
                }
            });

            return v;
        }

        // 对控件的填值操作独立出来了，我们可以在这个方法里面进行item的数据赋值
        @Override
        public void fillValues(int position, View convertView) {

            im_my_xianzhi_icon = (ImageView) convertView.findViewById(R.id.im_my_xianzhi_icon);
            gv_my_xianzhi_price_now = (TextView) convertView.findViewById(R.id.gv_my_xianzhi_price_now);
            gv_my_xianzhi_price_old = (TextView) convertView.findViewById(R.id.gv_my_xianzhi_price_old);
            tv_my_xianzhi_context = (TextView) convertView.findViewById(R.id.tv_my_xianzhi_context);
            tv_my_xianzhi_num = (TextView) convertView.findViewById(R.id.tv_my_xianzhi_num);
            tv_my_xianzhi_tip = (TextView) convertView.findViewById(R.id.tv_my_xianzhi_tip);
            tv_my_xianzhi_time = (TextView) convertView.findViewById(R.id.tv_my_xianzhi_time);

            gv_my_xianzhi_price_now.setText(bankList.get(position).getPrice_now());
            gv_my_xianzhi_price_old.setText(bankList.get(position).getPrice_old());
            tv_my_xianzhi_context.setText(bankList.get(position).getContext());
            tv_my_xianzhi_num.setText(bankList.get(position).getNumOrName());
            tv_my_xianzhi_tip.setText(bankList.get(position).getTip());

            // 0-人数,无时间，1－姓名
            if("1".equals(bankList.get(position).getType())){
                tv_my_xianzhi_time.setVisibility(View.GONE);
                tv_my_xianzhi_num.setTextColor(getResources().getColor(R.color.classify_text_orange));
            }else{
                tv_my_xianzhi_time.setVisibility(View.VISIBLE);
                tv_my_xianzhi_time.setText(bankList.get(position).getTime());
                tv_my_xianzhi_num.setTextColor(getResources().getColor(R.color.red));
            }
        }

        @Override
        public int getCount() {
            return bankList.size();
        }

        @Override
        public Object getItem(int position) {
            return bankList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }


    /**
     * 设置数据--测试
     */
    private void setData() {
        MyXianZhiListBean bModel0 = new MyXianZhiListBean();
        bModel0.price_now = "￥350";
        bModel0.price_old = "￥400";
        bModel0.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel0.type = "0";
        bModel0.numOrName = "18";
        bModel0.tip = "人向你发起了交易申请";
        bModel0.time = "";
        bankList.add(bModel0);

        MyXianZhiListBean bModel1 = new MyXianZhiListBean();
        bModel1.price_now = "￥350";
        bModel1.price_old = "￥400";
        bModel1.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel1.type = "1";
        bModel1.numOrName = "火星上的猪";
        bModel1.tip = "申请和你交易";
        bModel1.time = "3小时前";
        bankList.add(bModel1);

        MyXianZhiListBean bModel2 = new MyXianZhiListBean();
        bModel2.price_now = "￥350";
        bModel2.price_old = "￥400";
        bModel2.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel2.type = "0";
        bModel2.numOrName = "18";
        bModel2.tip = "人向你发起了交易申请";
        bModel2.time = "";
        bankList.add(bModel2);

        MyXianZhiListBean bModel3 = new MyXianZhiListBean();
        bModel3.price_now = "￥350";
        bModel3.price_old = "￥400";
        bModel3.context = "Pouch婴儿推车婴儿车宝宝手推车童车高景观避震轻便可躺可坐";
        bModel3.type = "0";
        bModel3.numOrName = "18";
        bModel3.tip = "人向你发起了交易申请";
        bModel3.time = "";
        bankList.add(bModel3);

    }
}
