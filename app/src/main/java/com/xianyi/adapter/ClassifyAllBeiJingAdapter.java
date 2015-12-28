package com.xianyi.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xianyi.R;

/**
 * ${todo}<分类页面-全北京适配器>
 *
 * @author lht
 * @data: on 15/11/30 11:21
 */
public class ClassifyAllBeiJingAdapter extends BaseAdapter {
	private List<Map> mList;
	private Context mContext;
	public static final int APP_PAGE_SIZE = 6;
	private PackageManager pm;
	
	public ClassifyAllBeiJingAdapter(Context context, List<Map> list, int page) {
		mContext = context;
		pm = context.getPackageManager();
		
		mList = new ArrayList<Map>();
		int i = page * APP_PAGE_SIZE;
		int iEnd = i+APP_PAGE_SIZE;
		while ((i<list.size()) && (i<iEnd)) {
			mList.add(list.get(i));
			i++;
		}
	}
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mList.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Map appInfo = mList.get(position);
		AppItem appItem;
		if (convertView == null) {
			View v = LayoutInflater.from(mContext).inflate(R.layout.classify_all_beijing_gradview_item, null);
			
			appItem = new AppItem();

			appItem.mVillageName = (TextView)v.findViewById(R.id.tv_village_name);
			appItem.mPopNum = (TextView)v.findViewById(R.id.tv_pop_num);
			appItem.mEnthusiasmNum = (TextView)v.findViewById(R.id.tv_enthusiasm_num);
			appItem.mIconLeft = (ImageView)v.findViewById(R.id.im_left);
			appItem.mIconRight = (ImageView)v.findViewById(R.id.im_right);

			v.setTag(appItem);
			convertView = v;
		} else {
			appItem = (AppItem)convertView.getTag();
		}

		appItem.mVillageName.setText(appInfo.get("name").toString());
		appItem.mPopNum.setText(appInfo.get("pop").toString());
		appItem.mEnthusiasmNum.setText(appInfo.get("enthusiasm").toString());

		appItem.mIconLeft.setImageResource(R.drawable.pic_blog_1);
		appItem.mIconRight.setImageResource(R.drawable.pic_blog_2);

		return convertView;
	}

	/**
	 * 每个应用显示的内容，包括图标和名称
	 */
	class AppItem {
		TextView mVillageName;
		TextView mPopNum;
		TextView mEnthusiasmNum;
		ImageView mIconLeft;
		ImageView mIconRight;
	}
}
