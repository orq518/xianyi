package com.xianyi.adapter;

import java.util.List;
import java.util.Map;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.widget.TextView;

import com.xianyi.R;

/**
 * ${todo}<全部分类左列表适配器>
 *
 * @author lht
 * @data: on 15/11/25 16:29
 */
public class ClassifyAllLeftListAdapter extends BaseAdapter {

	private Context ctx;
	private List<Map<String, Object>> list;
	private int position = 0;
	private boolean islodingimg = true;
	private int layout;

	public ClassifyAllLeftListAdapter(Context ctx, List<Map<String, Object>> list) {
		this.ctx = ctx;
		this.list = list;
	}

	public ClassifyAllLeftListAdapter(Context ctx, List<Map<String, Object>> list,
									  int layout, boolean islodingimg) {
		this.ctx = ctx;
		this.list = list;
		this.layout = layout;
		this.islodingimg = islodingimg;
	}

	public int getCount() {
		return list.size();
	}

	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	public long getItemId(int arg0) {
		return arg0;
	}

	public View getView(int arg0, View arg1, ViewGroup arg2) {
		Holder hold;
		if (arg1 == null) {
			hold = new Holder();
			arg1 = View.inflate(ctx, layout, null);
			hold.txt = (TextView) arg1.findViewById(R.id.right_item_txt);
			hold.img = (ImageView) arg1.findViewById(R.id.right_item_img);
			hold.layout = (LinearLayout) arg1.findViewById(R.id.right_item_layout);
			arg1.setTag(hold);
		} else {
			hold = (Holder) arg1.getTag();
		}
		if(islodingimg == true){
			hold.img.setImageResource(Integer.parseInt(list.get(arg0).get("img").toString()));
		}
		hold.txt.setText(list.get(arg0).get("txt").toString());
		hold.layout.setBackgroundResource(R.drawable.classify_all_class_left_listselect);
		if (arg0 == position) {
			hold.layout.setBackgroundResource(R.drawable.list_bkg_line_u);
		}
		return arg1;
	}

	public void setSelectItem(int i) {
		position = i;
	}

	public int getSelectItem() {
		return position;
	}

	private static class Holder {
		LinearLayout layout;
		ImageView img;
		TextView txt;
	}

}
