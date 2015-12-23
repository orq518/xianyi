package com.xianyi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xianyi.R;
import com.xianyi.bean.MyCollectListBean;
import com.xianyi.bean.MyTradeListBean;

import java.util.ArrayList;

/**
 * ${todo}<我的交易列表Adapter>
 *
 * @author lht
 * @data: on 15/12/22 14:56
 */
public class MyTradeListAdapter extends BaseAdapter {
    private Context ctx;
    private LayoutInflater mInflater;
    private ArrayList<MyTradeListBean> bankList;
    private int currentType;//当前item类型

    public MyTradeListAdapter(Context ctx, ArrayList<MyTradeListBean> bankList) {
        this.ctx = ctx;
        this.bankList = bankList;
        mInflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return bankList.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return bankList.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public int getViewTypeCount() {
        return bankList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder oneHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate((R.layout.activity_my_trade_item), null);
            oneHolder = new ViewHolder();

            oneHolder.im_my_trade_icon = (ImageView) convertView.findViewById(R.id.im_my_trade_icon);
            oneHolder.gv_my_trade_price_now = (TextView) convertView.findViewById(R.id.gv_my_trade_price_now);
            oneHolder.gv_my_trade_price_old = (TextView) convertView.findViewById(R.id.gv_my_trade_price_old);
            oneHolder.tv_my_trade_context = (TextView) convertView.findViewById(R.id.tv_my_trade_context);
            oneHolder.tv_my_trade_num = (TextView) convertView.findViewById(R.id.tv_my_xianzhi_num);
            oneHolder.tv_my_trade_tip = (TextView) convertView.findViewById(R.id.tv_my_xianzhi_tip);
            oneHolder.tv_my_trade_time = (TextView) convertView.findViewById(R.id.tv_my_xianzhi_time);

            convertView.setTag(oneHolder);
        } else {
            oneHolder = (ViewHolder) convertView.getTag();
        }

        oneHolder.gv_my_trade_price_now.setText(bankList.get(position).getPrice_now());
        oneHolder.gv_my_trade_price_old.setText(bankList.get(position).getPrice_old());
        oneHolder.tv_my_trade_context.setText(bankList.get(position).getContext());

        oneHolder.tv_my_trade_tip.setText(bankList.get(position).getTip());

        // 0-没有顶部布局，1没有底部布局
        if("0".equals(bankList.get(position).getType())){
            oneHolder.tv_my_trade_num.setVisibility(View.GONE);
            oneHolder.tv_my_trade_time.setVisibility(View.VISIBLE);

            oneHolder.tv_my_trade_time.setText(bankList.get(position).getTime());

        }else if("1".equals(bankList.get(position).getType())){
            oneHolder.tv_my_trade_num.setVisibility(View.VISIBLE);
            oneHolder.tv_my_trade_time.setVisibility(View.VISIBLE);

            oneHolder.tv_my_trade_num.setText(bankList.get(position).getNumOrName());
            oneHolder.tv_my_trade_time.setText(bankList.get(position).getTime());

        }else if("2".equals(bankList.get(position).getType())){
            oneHolder.tv_my_trade_num.setVisibility(View.GONE);
            oneHolder.tv_my_trade_time.setVisibility(View.GONE);

        }else if("3".equals(bankList.get(position).getType())){
            oneHolder.tv_my_trade_num.setVisibility(View.VISIBLE);
            oneHolder.tv_my_trade_time.setVisibility(View.VISIBLE);

            oneHolder.tv_my_trade_num.setText(bankList.get(position).getNumOrName());
            oneHolder.tv_my_trade_time.setText(bankList.get(position).getTime());

        }else if("4".equals(bankList.get(position).getType())){
            oneHolder.tv_my_trade_num.setVisibility(View.VISIBLE);
            oneHolder.tv_my_trade_time.setVisibility(View.VISIBLE);

            oneHolder.tv_my_trade_num.setText(bankList.get(position).getNumOrName());
            oneHolder.tv_my_trade_time.setText(bankList.get(position).getTime());

        }else if("5".equals(bankList.get(position).getType())){
            oneHolder.tv_my_trade_num.setVisibility(View.VISIBLE);
            oneHolder.tv_my_trade_time.setVisibility(View.GONE);

            oneHolder.tv_my_trade_num.setText(bankList.get(position).getNumOrName());
        }


        return convertView;
    }

    class ViewHolder {
        ImageView im_my_trade_icon;
        TextView gv_my_trade_price_now;
        TextView gv_my_trade_price_old;
        TextView tv_my_trade_context;
        TextView tv_my_trade_num;
        TextView tv_my_trade_tip;
        TextView tv_my_trade_time;
    }

}
