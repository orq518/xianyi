package com.xianyi.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xianyi.R;
import com.xianyi.activity.BigListActivity;
import com.xianyi.activity.ClassifyActivity;
import com.xianyi.customviews.CycleImageLayout;
import com.xianyi.customviews.TitleView;
import com.xianyi.utils.BannerManager;
import com.xianyi.utils.LogUtil;

import java.util.ArrayList;

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
	/** 新生儿礼盒 **/
	private LinearLayout mLYrGiftBox;
	/** 哈衣 **/
	private LinearLayout mLYrHaYi;
	/** 外衣 **/
	private LinearLayout mLYCoat;
	/** 羽绒 **/
	private LinearLayout mLYDown;
	/** 套装 **/
	private LinearLayout mLYSuit;
	/** 童鞋 **/
	private LinearLayout mLYChildrenShoes;
	/** 婴儿推车 **/
	private LinearLayout mLYBabyStroller;
	/** 奶瓶 **/
	private LinearLayout mLYFeeder;
	/** 婴儿床 **/
	private LinearLayout mLYBabyBed;
	/** 纸尿布 **/
	private LinearLayout mLYDiapers;
	/** 沐浴毛毯 **/
	private LinearLayout mLYBathBlanket;
	/** 儿童座椅 **/
	private LinearLayout mLYChildSeat;
	/** 游泳池 **/
	private LinearLayout mLYSwimmingpPool;
	/** 积木 **/
	private LinearLayout mLYBuildinBlocks;
	/** 摇铃 **/
	private LinearLayout mLYBell;
	/** 毛绒玩具 **/
	private LinearLayout mLYPlushToys;
	/** 电动玩具 **/
	private LinearLayout mLYelectricToys;
	/** 智能玩具 **/
	private LinearLayout mLYIntelligentToys;
	/** 自行车 **/
	private LinearLayout mLYBicycle;
	/** 旱冰鞋 **/
	private LinearLayout mLYRollerSkates;
	/** 滑板车 **/
	private LinearLayout mLYScooter;
	/** 幼教卡/盘 **/
	private LinearLayout mLYPreschoolEducation;
	/** 绘本/图书 **/
	private LinearLayout mLYBook;
	/** 跳绳 **/
	private LinearLayout mLYSkip;
	/** 防辐射服 **/
	private LinearLayout mLYRadiationProofClothes;
	/** 孕妇装 **/
	private LinearLayout mLYMaternityDress;
	/** 洗护保养 **/
	private LinearLayout mLYMaintain;
	/** 营养保险 **/
	private LinearLayout mLYInsurance;
	/** 待产包 **/
	private LinearLayout mLYPrepartalBag;
	/** 妈咪包 **/
	private LinearLayout mLYMamiBag;

	/** 数据 **/
	private ArrayList<String> imageUrlList;

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

		mTitle = (TitleView) mRootView.findViewById(R.id.title);
		mBannerView = (CycleImageLayout) mRootView.findViewById(R.id.ad_view);
		mImBabyClothes = (ImageView) mRootView.findViewById(R.id.iv_baby_clothes);
		mImLivingThings = (ImageView) mRootView.findViewById(R.id.iv_living_things);
		mImToy = (ImageView) mRootView.findViewById(R.id.iv_toy);
		mImTeaching = (ImageView) mRootView.findViewById(R.id.iv_teaching);
		mImMommy = (ImageView) mRootView.findViewById(R.id.iv_mommy);
		mLYrGiftBox = (LinearLayout) mRootView.findViewById(R.id.rl_gift_box);
		mLYrHaYi = (LinearLayout) mRootView.findViewById(R.id.rl_ha_yi);
		mLYCoat = (LinearLayout) mRootView.findViewById(R.id.rl_coat);
		mLYDown = (LinearLayout) mRootView.findViewById(R.id.rl_down);
		mLYSuit = (LinearLayout) mRootView.findViewById(R.id.rl_suit);
		mLYChildrenShoes = (LinearLayout) mRootView.findViewById(R.id.rl_children_shoes);
		mLYBabyStroller = (LinearLayout) mRootView.findViewById(R.id.rl_baby_stroller);
		mLYFeeder = (LinearLayout) mRootView.findViewById(R.id.rl_feeder);
		mLYBabyBed = (LinearLayout) mRootView.findViewById(R.id.rl_baby_bed);
		mLYDiapers = (LinearLayout) mRootView.findViewById(R.id.rl_diapers);
		mLYBathBlanket = (LinearLayout) mRootView.findViewById(R.id.rl_bath_blanket);
		mLYChildSeat = (LinearLayout) mRootView.findViewById(R.id.rl_child_seat);
		mLYSwimmingpPool = (LinearLayout) mRootView.findViewById(R.id.rl_swimming_pool);
		mLYBuildinBlocks = (LinearLayout) mRootView.findViewById(R.id.rl_building_blocks);
		mLYBell = (LinearLayout) mRootView.findViewById(R.id.rl_bell);
		mLYPlushToys = (LinearLayout) mRootView.findViewById(R.id.rl_plush_toys);
		mLYelectricToys = (LinearLayout) mRootView.findViewById(R.id.rl_electric_toy);
		mLYIntelligentToys = (LinearLayout) mRootView.findViewById(R.id.rl_intelligent_toy);
		mLYBicycle = (LinearLayout) mRootView.findViewById(R.id.rl_bicycle);
		mLYRollerSkates = (LinearLayout) mRootView.findViewById(R.id.rl_roller_skates);
		mLYScooter = (LinearLayout) mRootView.findViewById(R.id.rl_scooter);
		mLYPreschoolEducation = (LinearLayout) mRootView.findViewById(R.id.rl_preschool_education);
		mLYBook = (LinearLayout) mRootView.findViewById(R.id.rl_book);
		mLYSkip = (LinearLayout) mRootView.findViewById(R.id.rl_skip);
		mLYRadiationProofClothes = (LinearLayout) mRootView.findViewById(R.id.rl_radiation_proof_clothes);
		mLYMaternityDress = (LinearLayout) mRootView.findViewById(R.id.rl_maternity_dress);
		mLYMaintain = (LinearLayout) mRootView.findViewById(R.id.rl_maintain);
		mLYInsurance = (LinearLayout) mRootView.findViewById(R.id.rl_insurance);
		mLYPrepartalBag = (LinearLayout) mRootView.findViewById(R.id.rl_prepartal_bag);
		mLYMamiBag = (LinearLayout) mRootView.findViewById(R.id.rl_mami_bag);

		// 设置顶部布局
		mTitle.setTitle(getString(R.string.classify_title));
		mTitle.setLeftVisiable(false);

		mImBabyClothes.setOnClickListener(this);
		mImLivingThings.setOnClickListener(this);
		mImToy.setOnClickListener(this);
		mImTeaching.setOnClickListener(this);
		mImMommy.setOnClickListener(this);
		mLYrGiftBox.setOnClickListener(this);
		mLYrHaYi.setOnClickListener(this);
		mLYCoat.setOnClickListener(this);
		mLYDown.setOnClickListener(this);
		mLYSuit.setOnClickListener(this);
		mLYChildrenShoes.setOnClickListener(this);
		mLYBabyStroller.setOnClickListener(this);
		mLYFeeder.setOnClickListener(this);
		mLYBabyBed.setOnClickListener(this);
		mLYDiapers.setOnClickListener(this);
		mLYBathBlanket.setOnClickListener(this);
		mLYChildSeat.setOnClickListener(this);
		mLYSwimmingpPool.setOnClickListener(this);
		mLYBuildinBlocks.setOnClickListener(this);
		mLYBell.setOnClickListener(this);
		mLYPlushToys.setOnClickListener(this);
		mLYelectricToys.setOnClickListener(this);
		mLYIntelligentToys.setOnClickListener(this);
		mLYBicycle.setOnClickListener(this);
		mLYRollerSkates.setOnClickListener(this);
		mLYScooter.setOnClickListener(this);
		mLYPreschoolEducation.setOnClickListener(this);
		mLYBook.setOnClickListener(this);
		mLYSkip.setOnClickListener(this);
		mLYRadiationProofClothes.setOnClickListener(this);
		mLYMaternityDress.setOnClickListener(this);
		mLYMaintain.setOnClickListener(this);
		mLYInsurance.setOnClickListener(this);
		mLYPrepartalBag.setOnClickListener(this);
		mLYMamiBag.setOnClickListener(this);

		imageUrlList = new ArrayList<String>();
		initData();
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
		mBannerView.setImageResources(setData(), null, this);
	}

	@Override
	public void displayImage(String imageURL, ImageView imageView) {
		mBannerManager.displayImage(imageURL, imageView);
	}

	@Override
	public void onImageClick(int position, View imageView) {
		// mBannerManager.clickImage(position, imageView);
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

			// 新生儿礼盒
			case R.id.rl_gift_box:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "0");
				intent.putExtra("classify", "1");
				startActivity(intent);
				break;

			// 哈衣
			case R.id.rl_ha_yi:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "0");
				intent.putExtra("classify", "2");
				startActivity(intent);
				break;

			// 外衣
			case R.id.rl_coat:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "0");
				intent.putExtra("classify", "3");
				startActivity(intent);
				break;

			// 羽绒
			case R.id.rl_down:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "0");
				intent.putExtra("classify", "4");
				startActivity(intent);
				break;

			// 套装
			case R.id.rl_suit:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "0");
				intent.putExtra("classify", "5");
				startActivity(intent);
				break;

			// 童鞋
			case R.id.rl_children_shoes:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "0");
				intent.putExtra("classify", "6");
				startActivity(intent);
				break;

			// 婴儿推车
			case R.id.rl_baby_stroller:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "1");
				intent.putExtra("classify", "1");
				startActivity(intent);
				break;

			// 奶瓶
			case R.id.rl_feeder:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "1");
				intent.putExtra("classify", "2");
				startActivity(intent);
				break;

			// 婴儿床
			case R.id.rl_baby_bed:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "1");
				intent.putExtra("classify", "3");
				startActivity(intent);
				break;

			// 纸尿布
			case R.id.rl_diapers:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "1");
				intent.putExtra("classify", "4");
				startActivity(intent);
				break;

			// 沐浴毛毯
			case R.id.rl_bath_blanket:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "1");
				intent.putExtra("classify", "5");
				startActivity(intent);
				break;

			// 儿童座椅
			case R.id.rl_child_seat:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "1");
				intent.putExtra("classify", "6");
				startActivity(intent);
				break;

			// 游泳池
			case R.id.rl_swimming_pool:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "2");
				intent.putExtra("classify", "1");
				startActivity(intent);
				break;

			// 积木
			case R.id.rl_building_blocks:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "2");
				intent.putExtra("classify", "2");
				startActivity(intent);
				break;

			// 摇铃
			case R.id.rl_bell:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "2");
				intent.putExtra("classify", "3");
				startActivity(intent);
				break;

			// 毛绒玩具
			case R.id.rl_plush_toys:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "2");
				intent.putExtra("classify", "4");
				startActivity(intent);
				break;

			// 电动玩具
			case R.id.rl_electric_toy:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "2");
				intent.putExtra("classify", "5");
				startActivity(intent);
				break;

			// 智能玩具
			case R.id.rl_intelligent_toy:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "2");
				intent.putExtra("classify", "6");
				startActivity(intent);
				break;

			// 自行车
			case R.id.rl_bicycle:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "3");
				intent.putExtra("classify", "1");
				startActivity(intent);
				break;

			// 旱冰鞋
			case R.id.rl_roller_skates:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "3");
				intent.putExtra("classify", "2");
				startActivity(intent);
				break;

			// 滑板车
			case R.id.rl_scooter:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "3");
				intent.putExtra("classify", "3");
				startActivity(intent);
				break;

			// 幼教卡/盘
			case R.id.rl_preschool_education:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "3");
				intent.putExtra("classify", "4");
				startActivity(intent);
				break;

			// 绘本/图书
			case R.id.rl_book:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "3");
				intent.putExtra("classify", "5");
				startActivity(intent);
				break;

			// 跳绳
			case R.id.rl_skip:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "3");
				intent.putExtra("classify", "6");
				startActivity(intent);
				break;

			// 防辐射服
			case R.id.rl_radiation_proof_clothes:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "4");
				intent.putExtra("classify", "1");
				startActivity(intent);
				break;

			// 孕妇装
			case R.id.rl_maternity_dress:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "4");
				intent.putExtra("classify", "2");
				startActivity(intent);
				break;

			// 洗护保养
			case R.id.rl_maintain:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "4");
				intent.putExtra("classify", "3");
				startActivity(intent);
				break;

			// 营养保险
			case R.id.rl_insurance:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "4");
				intent.putExtra("classify", "4");
				startActivity(intent);
				break;

			// 待产包
			case R.id.rl_prepartal_bag:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "4");
				intent.putExtra("classify", "5");
				startActivity(intent);
				break;

			// 妈咪包
			case R.id.rl_mami_bag:
				intent = new Intent(mContext, BigListActivity.class);
				intent.putExtra("type", "4");
				intent.putExtra("classify", "6");
				startActivity(intent);
				break;

			default:
				break;
		}
	}

	public ArrayList<String> setData(){
		for(int i = 0; i < 2; i++){
			imageUrlList.add("http://api.hongdoulicai.com/assets/images/banner/1.png");
		}
		return imageUrlList;
	}
}