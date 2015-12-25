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
import com.xianyi.activity.BigListActivity;
import com.xianyi.activity.ClassifyActivity;
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
public class ClassifyFragment extends BaseFragment implements CycleImageLayout.ImageCycleViewListener,
		View.OnClickListener{
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
	/** 婴童服饰 **/
	private ImageView mImBabyClothes;
	/** 起居用品 **/
	private ImageView mImLivingThings;
	/** 童趣玩具 **/
	private ImageView mImToy;
	/** 文体教具 **/
	private ImageView mImTeaching;
	/** 妈咪专享 **/
	private ImageView mImMommy;

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
		mImBabyClothes = (ImageView) mRootView.findViewById(R.id.iv_baby_clothes);
		mImLivingThings = (ImageView) mRootView.findViewById(R.id.iv_living_things);
		mImToy = (ImageView) mRootView.findViewById(R.id.iv_toy);
		mImTeaching = (ImageView) mRootView.findViewById(R.id.iv_teaching);
		mImMommy = (ImageView) mRootView.findViewById(R.id.iv_mommy);

		// 设置顶部布局
		mTitle.setTitle(getString(R.string.classify_title));
		mTitle.setLeftVisiable(false);

		initData();

		mImBabyClothes.setOnClickListener(this);
		mImLivingThings.setOnClickListener(this);
		mImToy.setOnClickListener(this);
		mImTeaching.setOnClickListener(this);
		mImMommy.setOnClickListener(this);
	}

	@Override
	public void setVisible(boolean isVisibleToUser) {
//		super.setUserVisibleHint(isVisibleToUser);

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

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
			// 婴童服饰
			case R.id.iv_baby_clothes:
				intent = new Intent(mContext, ClassifyActivity.class);
				intent.putExtra("type", "0");
				startActivity(intent);
				break;

			// 起居用品
			case R.id.iv_living_things:
				intent = new Intent(mContext, ClassifyActivity.class);
				intent.putExtra("type", "1");
				startActivity(intent);
				break;

			// 童趣玩具
			case R.id.iv_toy:
				intent = new Intent(mContext, ClassifyActivity.class);
				intent.putExtra("type", "2");
				startActivity(intent);
				break;

			// 文体教具
			case R.id.iv_teaching:
				intent = new Intent(mContext, ClassifyActivity.class);
				intent.putExtra("type", "3");
				startActivity(intent);
				break;

			// 妈咪专享
			case R.id.iv_mommy:
				intent = new Intent(mContext, ClassifyActivity.class);
				intent.putExtra("type", "4");
				startActivity(intent);
				break;

			default:
				break;
		}
	}
}