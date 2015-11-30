package com.xianyi.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.xianyi.R;
import com.xianyi.adapter.ClassifyAllBeiJingAdapter;
import com.xianyi.adapter.ClassifyAllLeftListAdapter;
import com.xianyi.adapter.ClassifyAllRightAdapter;
import com.xianyi.customviews.ClassifyAllBeiJingPageControlView;
import com.xianyi.customviews.ClassifyAllBeiJingScrollLayout;
import com.xianyi.utils.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ${todo}<大类别列表页>
 *
 * @author lht
 * @data: on 15/11/25 14:52
 */
public class BigClassifyActivity extends BaseActivity implements View.OnClickListener{
    private static final String LTAG = BigClassifyActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;

    /*************** 全部分类布局 ***************/
    /** 全部分类布局 **/
    private LinearLayout mLyAllClass;
    /** 全部分类 **/
    private TextView mTvALLClassify;
    /** 是否显示全部分类布局 **/
    private boolean mAllClassListview = false;
    /** 全部分类，左列表 **/
    private ListView mLeftlist;
    /** 全部分类，右列表 **/
    private ListView mRightlist;
    /** 全部分类，左列表Adapter **/
    private ClassifyAllLeftListAdapter leftAdapter = null;
    /** 全部分类，右列表Adapter **/
    private ClassifyAllRightAdapter rightAdapter = null;
    /** 全部分类，数据源 **/
    private List<Map<String, Object>> mAllList;
    /** 全部分类，左布局图片 **/
    private int[] listviewImg = new int[] {
            R.drawable.classify_all_left_clothes, R.drawable.classify_all_left_living,
            R.drawable.classify_all_left_toy, R.drawable.classify_all_left_teaching,
            R.drawable.classify_all_left_mama};
    /** 全部分类，左布局文案 **/
    private String[] leftListviewText = new String[] { "婴童服饰", "起居用品", "童趣玩具",
            "文体教具", "妈咪专项"};
    /** 全部分类，右部布局文案 **/
    public static String[][] rightListviewText = new String[][] {
            { "我我我我我", "我我我我我", "我我我我我", "我我我我我", "我我我我我" },
            { "你你你你你", "你你你你你", "你你你你你", "你你你你你", "你你你你你" },
            { "他他他他他", "他他他他他", "他他他他他", "他他他他他", "他他他他他" },
            { "它它它它它", "它它它它它", "它它它它它", "它它它它它", "它它它它它" },
            { "她她她她她", "她她她她她", "她她她她她", "她她她她她", "她她她她她" } };

    /*************** 北京分类布局 ***************/
    /** 北京分类布局 **/
    private LinearLayout mLyAllBeiJing;
    /** 北京分类 **/
    private TextView mTvALLBeijing;
    /** 是否显示全部分类布局 **/
    private boolean mAllBeiJingListview = false;
    /** 左右滑动切换屏幕的类 **/
    private ClassifyAllBeiJingScrollLayout mScrollLayout;
    /** 页面控制类 **/
    private ClassifyAllBeiJingPageControlView pageControl;
    /** 页面数 **/
    private static final float APP_PAGE_SIZE = 6.0f;
    /** 分页数据 **/
    private DataLoading dataLoad;
    /** Adapter **/
    private ClassifyAllBeiJingAdapter classifyAllBeiJingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_classify);
        mContext = this;

        initViews();
    }

    public void initViews() {
        mLyAllClass = (LinearLayout) findViewById(R.id.ly_all_class);
        mLyAllBeiJing = (LinearLayout) findViewById(R.id.ly_all_beiing);
        mTvALLClassify = (TextView)findViewById(R.id.tv_all_classify);
        mTvALLBeijing = (TextView)findViewById(R.id.tv_all_beijing);

        initAllClassList();
        initAllBeiJingGradView();

        mTvALLClassify.setOnClickListener(this);
        mTvALLBeijing.setOnClickListener(this);
    }

    /**
     * 初始化全部布局类别
     */
    private void initAllClassList() {
        mLeftlist = (ListView) findViewById(R.id.lv_left);
        mRightlist = (ListView) findViewById(R.id.lv_right);

        initAllClassData();
        initAllClassLeftListAdapter();
        initAllClassRightListAdapter(rightListviewText[0]);

        Leftlistclick leftListcLick = new Leftlistclick();
        Rightlistclick rightListcLick = new Rightlistclick();

        mLeftlist.setOnItemClickListener(leftListcLick);
        mRightlist.setOnItemClickListener(rightListcLick);
    }

    /**
     * 初始化全部分类
     */
    private void initAllClassData() {
        mAllList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < leftListviewText.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", listviewImg[i]);
            map.put("txt", leftListviewText[i]);
            mAllList.add(map);
        }
    }

    /**
     * 适配全部分类，左列表
     */
    private void initAllClassLeftListAdapter() {
        leftAdapter = new ClassifyAllLeftListAdapter(BigClassifyActivity.this,
                mAllList, R.layout.classify_left_list_item, true);
        leftAdapter.setSelectItem(0);
        mLeftlist.setAdapter(leftAdapter);
    }

    /**
     * 适配全部分类，右列表
     * @param array
     */
    private void initAllClassRightListAdapter(String[] array) {
        rightAdapter = new ClassifyAllRightAdapter(BigClassifyActivity.this,
                array, R.layout.classify_right_list_item);
        mRightlist.setAdapter(rightAdapter);
        rightAdapter.notifyDataSetChanged();
    }

    /**
     * 全部分类－左列表点击事件
     */
    private class Leftlistclick implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            initAllClassRightListAdapter(rightListviewText[arg2]);
            leftAdapter.setSelectItem(arg2);
            leftAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 全部分类－右列表点击事件
     */
    private class Rightlistclick implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            rightAdapter.setSelectItem(arg2);
            Drawable drawable = getResources().getDrawable(R.drawable.ic_arrow_down_black);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mTvALLClassify.setCompoundDrawables(null, null, drawable, null);
            int position = leftAdapter.getSelectItem();
            mTvALLClassify.setText(rightListviewText[position][arg2]);
            mLyAllClass.setVisibility(View.GONE);
            mAllClassListview = false;
        }
    }

    /**
     * 初始化全北京布局类别
     */
    private void initAllBeiJingGradView() {
        dataLoad = new DataLoading();
        mScrollLayout = (ClassifyAllBeiJingScrollLayout)findViewById(R.id.ScrollLayout);
//        myHandler = new MyHandler(this,1);
//
//        //起一个线程更新数据
//        MyThread m = new MyThread();
//        new Thread(m).start();

        // 初始化数据－全北京
        List<Map> list = new ArrayList<Map>();
        for(int i = 0; i < 16; i++){
            Map map = new HashMap();
            map.put("name", "青年湖西里");
            map.put("pop", "15");
            map.put("enthusiasm", "12");
            list.add(map);
        }

        int pageNo = (int)Math.ceil( list.size() / APP_PAGE_SIZE);
        for (int i = 0; i < pageNo; i++) {
            /** gridview **/
            GridView allBeiJingPage = new GridView(mContext);
            // get the "i" page data
            ClassifyAllBeiJingAdapter classifyAllBeiJingAdapter = new ClassifyAllBeiJingAdapter(mContext, list, i);
            allBeiJingPage.setAdapter(classifyAllBeiJingAdapter);
            allBeiJingPage.setNumColumns(2);
            allBeiJingPage.setVerticalSpacing(20);
            allBeiJingPage.setOnItemClickListener(listener);
            allBeiJingPage.setSelector(new ColorDrawable(Color.TRANSPARENT));
            mScrollLayout.addView(allBeiJingPage);
        }
        //加载分页
        pageControl = (ClassifyAllBeiJingPageControlView) findViewById(R.id.pageControl);// 取消被选中色
        pageControl.bindScrollViewGroup(mScrollLayout);
        //加载分页数据
        dataLoad.bindScrollViewGroup(mScrollLayout);

    }

    /**
     * 分页数据
     */
    class DataLoading {
        private int count;
        public void bindScrollViewGroup(ClassifyAllBeiJingScrollLayout scrollViewGroup) {
            this.count=scrollViewGroup.getChildCount();
            scrollViewGroup.setOnScreenChangeListenerDataLoad(new ClassifyAllBeiJingScrollLayout.OnScreenChangeListenerDataLoad() {
                public void onScreenChange(int currentIndex) {
                    // TODO Auto-generated method stub
                    generatePageControl(currentIndex);
                }
            });
        }

        private void generatePageControl(int currentIndex){
            //如果到最后一页，就加载16条记录
//            if(count==currentIndex + 1){
//
//            }
        }
    }

    /**
     * gridView的onItemLick响应事件
     */
    public AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            LogUtil.d("position = " + position);
        }

    };

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent;

        int mID = v.getId();
        // 全部分类
        if (mID == R.id.tv_all_classify) {
            Drawable drawable = null;
            if (!mAllClassListview) {
                drawable = getResources().getDrawable(R.drawable.ic_arrow_up_black);
                mLyAllClass.setVisibility(View.VISIBLE);
                leftAdapter.notifyDataSetChanged();
                mAllClassListview = true;
            }
            else {
                drawable = getResources().getDrawable(R.drawable.ic_arrow_down_black);
                mLyAllClass.setVisibility(View.GONE);
                mAllClassListview = false;
            }
            //
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mTvALLClassify.setCompoundDrawables(null, null, drawable, null);
        }else{
            Drawable drawable = getResources().getDrawable( R.drawable.ic_arrow_down_black);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mTvALLClassify.setCompoundDrawables(null, null, drawable, null);
            mLyAllClass.setVisibility(View.GONE);
            mAllClassListview = false;
        }

        // 全北京
        if (mID == R.id.tv_all_beijing) {
            Drawable drawableBJ = null;
            if (!mAllBeiJingListview) {
                drawableBJ = getResources().getDrawable(R.drawable.ic_arrow_up_black);
                mLyAllBeiJing.setVisibility(View.VISIBLE);
                mAllBeiJingListview = true;
            } else {
                drawableBJ = getResources().getDrawable(R.drawable.ic_arrow_down_black);
                mLyAllBeiJing.setVisibility(View.GONE);
                mAllBeiJingListview = false;
            }

            drawableBJ.setBounds(0, 0, drawableBJ.getMinimumWidth(), drawableBJ.getMinimumHeight());
            mTvALLBeijing.setCompoundDrawables(null, null, drawableBJ, null);
        }else{
            Drawable drawable = getResources().getDrawable( R.drawable.ic_arrow_down_black);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            mTvALLBeijing.setCompoundDrawables(null, null, drawable, null);
            mLyAllBeiJing.setVisibility(View.GONE);
            mAllBeiJingListview = false;
        }
    }

}
