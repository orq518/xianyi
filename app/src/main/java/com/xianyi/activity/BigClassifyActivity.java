package com.xianyi.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.xianyi.R;
import com.xianyi.adapter.ClassifyAllLeftListAdapter;
import com.xianyi.adapter.ClassifyAllRightAdapter;

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

    /** 全部分类布局 **/
    private LinearLayout mLyAllClass;
    /** 全部分类 **/
    private TextView mTvALLClassify;
    /** 是否显示全部分类布局 **/
    private boolean mAllListview = false;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_classify);

        initViews();
    }

    public void initViews() {
        mLyAllClass = (LinearLayout) findViewById(R.id.ly_all_class);
        mTvALLClassify = (TextView)findViewById(R.id.tv_all_classify);

        initAllClassList();

        mTvALLClassify.setOnClickListener(this);
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
            mAllListview = false;
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent;
        switch (v.getId()) {
            // 全部分类
            case R.id.tv_all_classify:
                Drawable drawable = null;
                if (!mAllListview) {
                    drawable = getResources().getDrawable(R.drawable.ic_arrow_up_black);
                    mLyAllClass.setVisibility(View.VISIBLE);
                    leftAdapter.notifyDataSetChanged();
                    mAllListview = true;
                }
                else {
                    drawable = getResources().getDrawable(R.drawable.ic_arrow_down_black);
                    mLyAllClass.setVisibility(View.GONE);
                    mAllListview = false;
                }
                //
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                mTvALLClassify.setCompoundDrawables(null, null, drawable, null);
                break;

            // 全北京
            case R.id.tv_all_beijing:

                break;

            default:
                break;
        }
    }

}
