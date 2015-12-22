package com.xianyi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xianyi.R;
import com.xianyi.bean.ClassifyMainListBean;
import com.xianyi.customviews.AlignLeftGallery;
import com.xianyi.customviews.residelayout.CircleImageView;

import java.util.ArrayList;

/**
 * ${todo}<分类大列表适配器>
 *
 * @author lht
 * @data: on 15/12/1 13:39
 */
public class ClassifyMainListAdapter extends BaseAdapter {
    private static final int TYPE_ONE_IMG = 1;// 一个图片
    private static final int TYPE_MORE_IMG = 2;// 多个图片
    private static final int TYPE_AD = 3;// 广告
    private Context ctx;
    private LayoutInflater mInflater;
    private ArrayList<ClassifyMainListBean> bankList;
    private int currentType;//当前item类型

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
    public int getItemViewType(int position) {
        // TODO Auto-generated method stub
        if ("1".equals(bankList.get(position).getType())) {
            return TYPE_ONE_IMG;
        } else if ("2".equals(bankList.get(position).getType())) {
            return TYPE_MORE_IMG;
        } else if ("3".equals(bankList.get(position).getType())) {
            return TYPE_AD;
        }else {
            return 100;
        }
    }

    @Override
    public int getViewTypeCount() {
        return bankList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        currentType = getItemViewType(position);
        // 一个图片
        if (currentType == TYPE_ONE_IMG) {
            OneViewHolder oneHolder = null;
            if (convertView == null) {
                convertView = mInflater.inflate((R.layout.classify_main_list_one_img_item), null);
                oneHolder = new OneViewHolder();
                oneHolder.icon = (CircleImageView) convertView.findViewById(R.id.im_main_list_one_icon);
                oneHolder.price_now = (TextView) convertView .findViewById(R.id.gv_main_list_one_price_now);
                oneHolder.price_old = (TextView) convertView .findViewById(R.id.gv_main_list_one_price_old);
                oneHolder.time = (TextView) convertView .findViewById(R.id.gv_main_list_one_time);
                oneHolder.address = (TextView) convertView .findViewById(R.id.gv_main_list_one_address);
                oneHolder.description = (TextView) convertView .findViewById(R.id.gv_main_list_one_description);
                oneHolder.words = (Button) convertView .findViewById(R.id.bt_main_list_one_words);
                oneHolder.collect = (Button) convertView .findViewById(R.id.bt_main_list_one_collect);
                oneHolder.roll_out = (Button) convertView .findViewById(R.id.bt_main_list_one_roll_out);

                convertView.setTag(oneHolder);
            } else {
                oneHolder = (OneViewHolder) convertView.getTag();
            }
            oneHolder.price_now.setText(bankList.get(position).price_now);
            oneHolder.price_old.setText(bankList.get(position).price_old);
            oneHolder.time.setText(bankList.get(position).time);
            oneHolder.address.setText(bankList.get(position).address);
            oneHolder.description.setText(bankList.get(position).description);
            oneHolder.words.setText(bankList.get(position).wordsNum);
            oneHolder.collect.setText(bankList.get(position).collectNum);
            oneHolder.roll_out.setText(bankList.get(position).roll_outNum);

        }
        // 多个图片
        else if (currentType == TYPE_MORE_IMG) {
            MoreViewHolder moreHolder = null;
            if (convertView == null) {
                convertView = mInflater.inflate((R.layout.classify_main_list_more_img_item), null);
                moreHolder = new MoreViewHolder();
                moreHolder.icon = (CircleImageView) convertView.findViewById(R.id.im_main_list_more_icon);
                moreHolder.price_now = (TextView) convertView.findViewById(R.id.gv_main_list_more_price_now);
                moreHolder.price_old = (TextView) convertView.findViewById(R.id.gv_main_list_more_price_old);
                moreHolder.time = (TextView) convertView.findViewById(R.id.gv_main_list_more_time);
                moreHolder.address = (TextView) convertView.findViewById(R.id.gv_main_list_more_address);
                moreHolder.gallery = (AlignLeftGallery) convertView.findViewById(R.id.gallery_main_list_more);
                moreHolder.description = (TextView) convertView.findViewById(R.id.gv_main_list_more_description);
                moreHolder.words = (Button) convertView.findViewById(R.id.bt_main_list_more_words);
                moreHolder.collect = (Button) convertView .findViewById(R.id.bt_main_list_more_collect);
                moreHolder.roll_out = (Button) convertView.findViewById(R.id.bt_main_list_more_roll_out);
                convertView.setTag(moreHolder);
            } else {
                moreHolder = (MoreViewHolder) convertView.getTag();
            }

            //为GridView设置适配器
            moreHolder.gallery.setAdapter(new ClassifyMainListGridViewAdapter(ctx));
            //注册监听事件
            moreHolder.gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                    Toast.makeText(ctx, "pic" + position, Toast.LENGTH_SHORT).show();
                }
            });

            moreHolder.price_now.setText(bankList.get(position).price_now);
            moreHolder.price_old.setText(bankList.get(position).price_old);
            moreHolder.time.setText(bankList.get(position).time);
            moreHolder.address.setText(bankList.get(position).address);
            moreHolder.description.setText(bankList.get(position).description);
            moreHolder.words.setText(bankList.get(position).wordsNum);
            moreHolder.roll_out.setText(bankList.get(position).roll_outNum);
        }
        // 广告
        else if (currentType == TYPE_AD){
            AdViewHolder adHolder = null;
            if (convertView == null) {
                convertView = mInflater.inflate((R.layout.classify_main_list_ad_item), null);
                adHolder = new AdViewHolder();
                convertView.setTag(adHolder);
            } else {
                adHolder = (AdViewHolder) convertView.getTag();
            }
        }
        return convertView;
    }

    class OneViewHolder {
        CircleImageView icon;
        TextView price_now;
        TextView price_old;
        TextView time;
        TextView address;
        TextView description;
        Button words;
        Button collect;
        Button roll_out;
    }

    class MoreViewHolder {
        CircleImageView icon;
        TextView price_now;
        TextView price_old;
        TextView time;
        TextView address;
        TextView description;
        AlignLeftGallery gallery;
        Button words;
        Button collect;
        Button roll_out;
    }

    class AdViewHolder {

    }
}
