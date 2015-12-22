package com.xianyi.customviews;

/**
 * The author 欧瑞强 on 2015/12/21.
 * todo
 */

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xianyi.R;
import com.xianyi.adapter.ClassifyMainListAdapter;
import com.xianyi.bean.ClassifyMainListBean;
import com.xianyi.customviews.mylist.MyListView;

import java.util.ArrayList;

/**
 * The author 欧瑞强 on 2015/12/18.
 * todo
 */
public  class FindTab2Layout extends FrameLayout {
    /*************** 主列表 ***************/
    /**
     * listView
     **/
    private MyListView mListView;
    /**
     * 适配器
     **/
    private MyAdapter adapter;
    /**
     * 数据源
     **/
    private ArrayList<ClassifyMainListBean> bankList = new ArrayList<ClassifyMainListBean>();
    Context mContext;

    public FindTab2Layout(Context context) {
        super(context);
        mContext = context;
        initMainList();
    }

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

    /**
     * 初始化主列表
     */
    private void initMainList() {
        mListView = new MyListView(mContext);
        LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        this.addView(mListView,params);
        mListView.setDivider(mContext.getResources().getDrawable(R.drawable.listview_divider_line));
        mListView.setDividerHeight(2);
        mListView.setVerticalScrollBarEnabled(true);
        setData();

//        // 设置listview可以加载、刷新
        mListView.setPullLoadEnable(true);
        mListView.setPullRefreshEnable(true);
        adapter = new MyAdapter(mContext);
        mListView.setAdapter(adapter);
//
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
                        Toast.makeText(mContext, "refresh",
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
                        Toast.makeText(mContext, "loadMore",
                                Toast.LENGTH_SHORT).show();
                        mHandler.sendEmptyMessage(MSG_LOADMORE);
                    }
                }, 1000);
            }
        });

    }

    /**
     * 设置数据--测试
     */
    private void setData() {
        ClassifyMainListBean bModel0 = new ClassifyMainListBean();
        bModel0.type = "01";
        bModel0.price_now = "￥500";
        bModel0.price_old = "￥600";
        bModel0.time = "1小时前";
        bModel0.address = "朝阳区安贞胜古北里";
        bModel0.description = "中广托普广告传媒有限公司";
        bModel0.collectNum = "34";
        bModel0.roll_outNum = "2";
        bModel0.wordsNum = "12";
        bankList.add(bModel0);

        ClassifyMainListBean bModel1 = new ClassifyMainListBean();
        bModel1.type = "02";
        bModel1.price_now = "￥500";
        bModel1.price_old = "￥600";
        bModel1.time = "1小时前";
        bModel1.address = "朝阳区安贞胜古北里";
        bModel1.description = "中广托普广告传媒有限公司";
        bModel1.collectNum = "34";
        bModel1.roll_outNum = "2";
        bModel1.wordsNum = "12";
        bankList.add(bModel1);

        ClassifyMainListBean bModel2 = new ClassifyMainListBean();
        bModel2.type = "03";
        bankList.add(bModel2);

        ClassifyMainListBean bModel3 = new ClassifyMainListBean();
        bModel3.type = "01";
        bModel3.price_now = "￥500";
        bModel3.price_old = "￥600";
        bModel3.time = "1小时前";
        bModel3.address = "朝阳区安贞胜古北里";
        bModel3.description = "中广托普广告传媒有限公司";
        bModel3.collectNum = "34";
        bModel3.roll_outNum = "2";
        bModel3.wordsNum = "12";
        bankList.add(bModel3);

        ClassifyMainListBean bModel4 = new ClassifyMainListBean();
        bModel4.type = "02";
        bModel4.price_now = "￥500";
        bModel4.price_old = "￥600";
        bModel4.time = "1小时前";
        bModel4.address = "朝阳区安贞胜古北里";
        bModel4.description = "中广托普广告传媒有限公司";
        bModel4.collectNum = "34";
        bModel4.roll_outNum = "2";
        bModel4.wordsNum = "12";
        bankList.add(bModel4);

        ClassifyMainListBean bModel5 = new ClassifyMainListBean();
        bModel5.type = "03";
        bankList.add(bModel5);
    }
    public class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;


        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return bankList.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {

                holder=new ViewHolder();

                convertView = mInflater.inflate(R.layout.find_tab2_list_item, null);
//                holder.img = (ImageView)convertView.findViewById(R.id.img);
//                holder.title = (TextView)convertView.findViewById(R.id.title);
//                holder.info = (TextView)convertView.findViewById(R.id.info);
//                holder.viewBtn = (Button)convertView.findViewById(R.id.view_btn);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }


//            holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
//            holder.title.setText((String)mData.get(position).get("title"));
//            holder.info.setText((String)mData.get(position).get("info"));
//
//            holder.viewBtn.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                }
//            });


            return convertView;
        }

    }
    public final class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView info;
        public Button viewBtn;
    }
}
