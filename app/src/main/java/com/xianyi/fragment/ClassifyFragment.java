package com.xianyi.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xianyi.R;
import com.xianyi.customviews.CycleImageLayout;
import com.xianyi.customviews.TitleView;
import com.xianyi.utils.BannerManager;
import com.xianyi.utils.LogUtil;

/**
 * ${todo}<分类页面>
 *
 * @author lht
 * @data: on 15/11/24 11:21
 */
public class ClassifyFragment extends BaseFragment implements CycleImageLayout.ImageCycleViewListener{
	private static final String LTAG = ClassifyFragment.class.getSimpleName();
	/** 上下文 **/
	private Context mContext;
	/** 根view布局 **/
	private View mRootView;
	/** title布局 **/
	private TitleView mTitle;
	/** 广告轮播布局banner **/
	private CycleImageLayout mBannerView;
	/** 广告轮播布局banner管理对象 **/
	private BannerManager mBannerManager;

	@Override
	public String getFragmentName() {
		return LTAG;
	}

	/***** 生命周期 *****/
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mContext = activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if (null == mRootView) {
			mRootView = getLayoutInflater(savedInstanceState).inflate(R.layout.fargment_classify, null);
		}
		return mRootView;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		initView();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	private void initView() {
		mBannerManager = new BannerManager(mContext, mBannerView, this);

		// 顶部布局
		mTitle = (TitleView) mRootView.findViewById(R.id.title);
		mBannerView = (CycleImageLayout) mRootView.findViewById(R.id.ad_view);

		// 设置顶部布局
		mTitle.setTitle(getString(R.string.classify_title));
		mTitle.setLeftVisiable(true);
		mTitle.setLeftIcon(R.drawable.stars);
		mTitle.setLeftClickListener(new TitleLeftOnClickListener());

		initData();
	}

	@Override
	public void setVisible(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);

		LogUtil.d("是否显示：" + isVisibleToUser + "    isNeedRefresh:" + isNeedRefresh);
		if (isVisibleToUser && isNeedRefresh) {
			isNeedRefresh = false;
		}
	}

	/**
	 * 请求数据
	 */
	public void initData() {


	}

	@Override
	public void displayImage(String imageURL, ImageView imageView) {
		mBannerManager.displayImage(imageURL, imageView);
	}

	@Override
	public void onImageClick(int position, View imageView) {
		mBannerManager.clickImage(position, imageView);
	}

	/**
	 * 顶部布局--左按钮事件监听
	 */
	public class TitleLeftOnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {

		}

	}
}