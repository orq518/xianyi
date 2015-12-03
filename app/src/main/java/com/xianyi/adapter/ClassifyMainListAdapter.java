package com.xianyi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xianyi.R;
import com.xianyi.bean.ClassifyMainListBean;

import java.util.ArrayList;

/**
 * ${todo}<分类大列表适配器>
 *
 * @author lht
 * @data: on 15/12/1 13:39
 */
public class ClassifyMainListAdapter extends BaseAdapter {
    private Context ctx;
    private LayoutInflater mInflater;
    private ArrayList<ClassifyMainListBean> bankList;

    public ClassifyMainListAdapter(Context ctx, ArrayList<ClassifyMainListBean> bankList) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            // 一个图片
            if("01".equals(bankList.get(position).type)){
                convertView = mInflater.inflate((R.layout.classify_main_list_one_img_item), null);
                holder = new ViewHolder();
                holder.icon = (ImageView) convertView.findViewById(R.id.im_main_list_one_icon);
                holder.price_now = (TextView) convertView .findViewById(R.id.gv_main_list_one_price_now);
                holder.price_old = (TextView) convertView .findViewById(R.id.gv_main_list_one_price_old);
                holder.time = (TextView) convertView .findViewById(R.id.gv_main_list_one_time);
                holder.address = (TextView) convertView .findViewById(R.id.gv_main_list_one_address);
                holder.description = (TextView) convertView .findViewById(R.id.gv_main_list_one_description);
                holder.words = (Button) convertView .findViewById(R.id.bt_main_list_one_words);
                holder.collect = (Button) convertView .findViewById(R.id.bt_main_list_one_collect);
                holder.roll_out = (Button) convertView .findViewById(R.id.bt_main_list_one_roll_out);
            }
            // 多个图片
            else if("02".equals(bankList.get(position).type)){
                convertView = mInflater.inflate((R.layout.classify_main_list_more_img_item), null);
                holder = new ViewHolder();
                holder.icon = (ImageView) convertView.findViewById(R.id.im_main_list_one_icon);
                holder.price_now = (TextView) convertView .findViewById(R.id.gv_main_list_one_price_now);
                holder.price_old = (TextView) convertView .findViewById(R.id.gv_main_list_one_price_old);
                holder.time = (TextView) convertView .findViewById(R.id.gv_main_list_one_time);
                holder.address = (TextView) convertView .findViewById(R.id.gv_main_list_one_address);
                holder.description = (TextView) convertView .findViewById(R.id.gv_main_list_one_description);
                holder.words = (Button) convertView .findViewById(R.id.bt_main_list_one_words);
                holder.collect = (Button) convertView .findViewById(R.id.bt_main_list_one_collect);
                holder.roll_out = (Button) convertView .findViewById(R.id.bt_main_list_one_roll_out);
            }
            // 广告
            else if("03".equals(bankList.get(position).type)){
                convertView = mInflater.inflate((R.layout.classify_main_list_ad_item), null);

            }

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

//        // 一个图片
//        if("01".equals(bankList.get(position).type)){
//            holder.price_now.setText(bankList.get(position).price_now);
//            holder.price_old.setText(bankList.get(position).price_old);
//            holder.time.setText(bankList.get(position).time);
//            holder.address.setText(bankList.get(position).address);
//            holder.description.setText(bankList.get(position).description);
//            holder.words.setText(bankList.get(position).wordsNum);
//            holder.collect.setText(bankList.get(position).collectNum);
//            holder.roll_out.setText(bankList.get(position).roll_outNum);
//
//        }
//        // 多个图片
//        else if("02".equals(bankList.get(position).type)){
//            holder.price_now.setText(bankList.get(position).price_now);
//            holder.price_old.setText(bankList.get(position).price_old);
//            holder.time.setText(bankList.get(position).time);
//            holder.address.setText(bankList.get(position).address);
//            holder.description.setText(bankList.get(position).description);
//            holder.words.setText(bankList.get(position).wordsNum);
//            holder.collect.setText(bankList.get(position).collectNum);
//            holder.roll_out.setText(bankList.get(position).roll_outNum);
//        }
//        // 广告
//        else if("03".equals(bankList.get(position).type)){
//
//        }

        return convertView;
    }

    class ViewHolder {
        ImageView icon;
        TextView price_now;
        TextView price_old;
        TextView time;
        TextView address;
        TextView description;
        Button words;
        Button collect;
        Button roll_out;

    }
}
