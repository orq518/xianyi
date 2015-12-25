package com.xianyi.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xianyi.R;
import com.xianyi.customviews.TitleView;

/**
 * ${todo}<分类页面>
 *
 * @author lht
 * @data: on 15/11/2 16:35
 */
public class ClassifyActivity extends BaseActivity implements View.OnClickListener{
    private static final String LTAG = ClassifyActivity.class.getSimpleName();
    /** 上下文 **/
    private Context mContext;
    /** 顶部布局 **/
    private TitleView mTitleView;
    /** 1 **/
    private TextView mTV1;
    /** 2 **/
    private TextView mTV2;
    /** 3 **/
    private TextView mTV3;
    /** 4 **/
    private TextView mTV4;
    /** 5 **/
    private TextView mTV5;
    /** 6 **/
    private TextView mTV6;
    /** 7 **/
    private TextView mTV7;
    /** 8 **/
    private TextView mTV8;
    /** 9 **/
    private TextView mTV9;
    /** 10 **/
    private TextView mTV10;
    /** 11 **/
    private TextView mTV11;
    /** 12 **/
    private TextView mTV12;

    /** 类别 **/
    private String type; //0-婴童服饰,1-起居用品,2-童趣玩具,3-文体教具,4-妈咪专享

    private int[] image1 = new int[]{
            R.drawable.pic1_1, R.drawable.pic1_2, R.drawable.pic1_3, R.drawable.pic1_4, R.drawable.pic1_5,
            R.drawable.pic1_6, R.drawable.pic1_7, R.drawable.pic1_8, R.drawable.pic1_9, R.drawable.pic1_10,
            R.drawable.pic1_11, R.drawable.pic1_12};
    private int[] image2 = new int[]{
            R.drawable.pic2_1, R.drawable.pic2_2, R.drawable.pic2_3, R.drawable.pic2_4, R.drawable.pic2_5,
            R.drawable.pic2_6, R.drawable.pic2_7, R.drawable.pic2_8, R.drawable.pic2_9, R.drawable.pic2_10,
            R.drawable.pic2_11, R.drawable.pic2_12};
    private int[] image3 = new int[]{
            R.drawable.pic3_1, R.drawable.pic3_2, R.drawable.pic3_3, R.drawable.pic3_4, R.drawable.pic3_5,
            R.drawable.pic3_6, R.drawable.pic3_7, R.drawable.pic3_8, R.drawable.pic3_9, R.drawable.pic3_10,
            R.drawable.pic3_11, R.drawable.pic3_12};
    private int[] image4 = new int[]{
            R.drawable.pic4_1, R.drawable.pic4_2, R.drawable.pic4_3, R.drawable.pic4_4, R.drawable.pic4_5,
            R.drawable.pic4_6, R.drawable.pic4_7, R.drawable.pic4_8, R.drawable.pic4_9, R.drawable.pic4_10,
            R.drawable.pic4_11, R.drawable.pic4_12};
    private int[] image5 = new int[]{
            R.drawable.pic5_1, R.drawable.pic5_2, R.drawable.pic5_3, R.drawable.pic5_4, R.drawable.pic5_5,
            R.drawable.pic5_6, R.drawable.pic5_7, R.drawable.pic5_8, R.drawable.pic5_9, R.drawable.pic5_10,
            R.drawable.pic5_11, R.drawable.pic5_12};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classify);
        mContext = this;

        initDate();

        initViews();
    }

    public void initDate() {
        // 接收数据
        Intent intent = getIntent();
        if (intent != null) {
            type = intent.getStringExtra("type");
        }
    }


    public void initViews() {
        mTitleView = (TitleView) findViewById(R.id.title);
        mTV1 = (TextView) findViewById(R.id.tv_classify1);
        mTV2 = (TextView) findViewById(R.id.tv_classify2);
        mTV3 = (TextView) findViewById(R.id.tv_classify3);
        mTV4 = (TextView) findViewById(R.id.tv_classify4);
        mTV5 = (TextView) findViewById(R.id.tv_classify5);
        mTV6 = (TextView) findViewById(R.id.tv_classify6);
        mTV7 = (TextView) findViewById(R.id.tv_classify7);
        mTV8 = (TextView) findViewById(R.id.tv_classify8);
        mTV9 = (TextView) findViewById(R.id.tv_classify9);
        mTV10 = (TextView) findViewById(R.id.tv_classify10);
        mTV11 = (TextView) findViewById(R.id.tv_classify11);
        mTV12 = (TextView) findViewById(R.id.tv_classify12);

        mTV1.setOnClickListener(this);
        mTV2.setOnClickListener(this);
        mTV3.setOnClickListener(this);
        mTV4.setOnClickListener(this);
        mTV5.setOnClickListener(this);
        mTV6.setOnClickListener(this);
        mTV7.setOnClickListener(this);
        mTV8.setOnClickListener(this);
        mTV9.setOnClickListener(this);
        mTV10.setOnClickListener(this);
        mTV11.setOnClickListener(this);
        mTV12.setOnClickListener(this);

        showView();
    }

    /**
     * 显示数据
     */
    private void showView() {
        // 设置顶部标题布局
        mTitleView.setTitle("账号密码设置");
        mTitleView.setLeftClickListener(new TitleLeftOnClickListener());

        if("0".equals(type)){
            mTitleView.setTitle(getResources().getStringArray(R.array.array0)[0]);
            mTV1.setText(getResources().getStringArray(R.array.array1)[0]);
            mTV1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_1), null, null);
            mTV2.setText(getResources().getStringArray(R.array.array1)[1]);
            mTV2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_2), null, null);
            mTV3.setText(getResources().getStringArray(R.array.array1)[2]);
            mTV3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_3), null, null);
            mTV4.setText(getResources().getStringArray(R.array.array1)[3]);
            mTV4.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_4), null, null);
            mTV5.setText(getResources().getStringArray(R.array.array1)[4]);
            mTV5.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_5), null, null);
            mTV6.setText(getResources().getStringArray(R.array.array1)[5]);
            mTV6.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_6), null, null);
            mTV7.setText(getResources().getStringArray(R.array.array1)[6]);
            mTV7.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_7), null, null);
            mTV8.setText(getResources().getStringArray(R.array.array1)[7]);
            mTV8.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_8), null, null);
            mTV9.setText(getResources().getStringArray(R.array.array1)[8]);
            mTV9.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_9), null, null);
            mTV10.setText(getResources().getStringArray(R.array.array1)[9]);
            mTV10.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_10), null, null);
            mTV11.setText(getResources().getStringArray(R.array.array1)[10]);
            mTV11.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_11), null, null);
            mTV12.setText(getResources().getStringArray(R.array.array1)[11]);
            mTV12.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic1_12), null, null);
        }else if("1".equals(type)){
            mTitleView.setTitle(getResources().getStringArray(R.array.array0)[1]);
            mTV1.setText(getResources().getStringArray(R.array.array2)[0]);
            mTV1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_1), null, null);
            mTV2.setText(getResources().getStringArray(R.array.array2)[1]);
            mTV2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_2), null, null);
            mTV3.setText(getResources().getStringArray(R.array.array2)[2]);
            mTV3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_3), null, null);
            mTV4.setText(getResources().getStringArray(R.array.array2)[3]);
            mTV4.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_4), null, null);
            mTV5.setText(getResources().getStringArray(R.array.array2)[4]);
            mTV5.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_5), null, null);
            mTV6.setText(getResources().getStringArray(R.array.array2)[5]);
            mTV6.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_6), null, null);
            mTV7.setText(getResources().getStringArray(R.array.array2)[6]);
            mTV7.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_7), null, null);
            mTV8.setText(getResources().getStringArray(R.array.array2)[7]);
            mTV8.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_8), null, null);
            mTV9.setText(getResources().getStringArray(R.array.array2)[8]);
            mTV9.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_9), null, null);
            mTV10.setText(getResources().getStringArray(R.array.array2)[9]);
            mTV10.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_10), null, null);
            mTV11.setText(getResources().getStringArray(R.array.array2)[10]);
            mTV11.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_11), null, null);
            mTV12.setText(getResources().getStringArray(R.array.array2)[11]);
            mTV12.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic2_12), null, null);
        }else if("2".equals(type)){
            mTitleView.setTitle(getResources().getStringArray(R.array.array0)[2]);
            mTV1.setText(getResources().getStringArray(R.array.array3)[0]);
            mTV1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_1), null, null);
            mTV2.setText(getResources().getStringArray(R.array.array3)[1]);
            mTV2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_2), null, null);
            mTV3.setText(getResources().getStringArray(R.array.array3)[2]);
            mTV3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_3), null, null);
            mTV4.setText(getResources().getStringArray(R.array.array3)[3]);
            mTV4.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_4), null, null);
            mTV5.setText(getResources().getStringArray(R.array.array3)[4]);
            mTV5.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_5), null, null);
            mTV6.setText(getResources().getStringArray(R.array.array3)[5]);
            mTV6.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_6), null, null);
            mTV7.setText(getResources().getStringArray(R.array.array3)[6]);
            mTV7.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_7), null, null);
            mTV8.setText(getResources().getStringArray(R.array.array3)[7]);
            mTV8.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_8), null, null);
            mTV9.setText(getResources().getStringArray(R.array.array3)[8]);
            mTV9.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_9), null, null);
            mTV10.setText(getResources().getStringArray(R.array.array3)[9]);
            mTV10.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_10), null, null);
            mTV11.setText(getResources().getStringArray(R.array.array3)[10]);
            mTV11.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_11), null, null);
            mTV12.setText(getResources().getStringArray(R.array.array3)[11]);
            mTV12.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic3_12), null, null);
        } else if("3".equals(type)){
            mTitleView.setTitle(getResources().getStringArray(R.array.array0)[3]);
            mTV1.setText(getResources().getStringArray(R.array.array4)[0]);
            mTV1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_1), null, null);
            mTV2.setText(getResources().getStringArray(R.array.array4)[1]);
            mTV2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_2), null, null);
            mTV3.setText(getResources().getStringArray(R.array.array4)[2]);
            mTV3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_3), null, null);
            mTV4.setText(getResources().getStringArray(R.array.array4)[3]);
            mTV4.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_4), null, null);
            mTV5.setText(getResources().getStringArray(R.array.array4)[4]);
            mTV5.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_5), null, null);
            mTV6.setText(getResources().getStringArray(R.array.array4)[5]);
            mTV6.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_6), null, null);
            mTV7.setText(getResources().getStringArray(R.array.array4)[6]);
            mTV7.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_7), null, null);
            mTV8.setText(getResources().getStringArray(R.array.array4)[7]);
            mTV8.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_8), null, null);
            mTV9.setText(getResources().getStringArray(R.array.array4)[8]);
            mTV9.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_9), null, null);
            mTV10.setText(getResources().getStringArray(R.array.array4)[9]);
            mTV10.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_10), null, null);
            mTV11.setText(getResources().getStringArray(R.array.array4)[10]);
            mTV11.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_11), null, null);
            mTV12.setText(getResources().getStringArray(R.array.array4)[11]);
            mTV12.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic4_12), null, null);
        }else if("4".equals(type)){
            mTitleView.setTitle(getResources().getStringArray(R.array.array0)[4]);
            mTV1.setText(getResources().getStringArray(R.array.array5)[0]);
            mTV1.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_1), null, null);
            mTV2.setText(getResources().getStringArray(R.array.array5)[1]);
            mTV2.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_2), null, null);
            mTV3.setText(getResources().getStringArray(R.array.array5)[2]);
            mTV3.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_3), null, null);
            mTV4.setText(getResources().getStringArray(R.array.array5)[3]);
            mTV4.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_4), null, null);
            mTV5.setText(getResources().getStringArray(R.array.array5)[4]);
            mTV5.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_5), null, null);
            mTV6.setText(getResources().getStringArray(R.array.array5)[5]);
            mTV6.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_6), null, null);
            mTV7.setText(getResources().getStringArray(R.array.array5)[6]);
            mTV7.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_7), null, null);
            mTV8.setText(getResources().getStringArray(R.array.array5)[7]);
            mTV8.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_8), null, null);
            mTV9.setText(getResources().getStringArray(R.array.array5)[8]);
            mTV9.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_9), null, null);
            mTV10.setText(getResources().getStringArray(R.array.array5)[9]);
            mTV10.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_10), null, null);
            mTV11.setText(getResources().getStringArray(R.array.array5)[10]);
            mTV11.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_11), null, null);
            mTV12.setText(getResources().getStringArray(R.array.array5)[11]);
            mTV12.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(R.drawable.pic5_12), null, null);
        }
    }

    /**
     * 顶部布局--按钮事件监听
     */
    public class TitleLeftOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        Intent intent;
        switch (v.getId()) {
            //
            case R.id.tv_classify1:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "1");
                startActivity(intent);
                break;
            //
            case R.id.tv_classify2:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "2");
                startActivity(intent);
                break;

            //
            case R.id.tv_classify3:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "3");
                startActivity(intent);
                break;

            //
            case R.id.tv_classify4:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "4");
                startActivity(intent);
                break;

            //
            case R.id.tv_classify5:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "5");
                startActivity(intent);
                break;

            //
            case R.id.tv_classify6:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "6");
                startActivity(intent);
                break;

            //
            case R.id.tv_classify7:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "7");
                startActivity(intent);
                break;

            //
            case R.id.tv_classify8:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "8");
                startActivity(intent);
                break;

            //
            case R.id.tv_classify9:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "9");
                startActivity(intent);
                break;

            //
            case R.id.tv_classify10:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "10");
                startActivity(intent);
                break;
            //
            case R.id.tv_classify11:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "11");
                startActivity(intent);
                break;

            //
            case R.id.tv_classify12:
                intent = new Intent(ClassifyActivity.this, BigListActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("classify", "12");
                startActivity(intent);
                break;

            default:
                break;
        }
    }

}
