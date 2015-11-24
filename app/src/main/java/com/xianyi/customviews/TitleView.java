package com.xianyi.customviews;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xianyi.R;
import com.xianyi.utils.Utils;


/**
 * 标题栏
 */
public class TitleView extends RelativeLayout {
    private TextView mTitle;
    private TextView mLeft;
    private TextView mRigh;
    private ImageView mRightImage;
    private Context mContext;
    private View v;

    /** title **/
    private String mTitleString;

    public TitleView(Context context) {
        super(context);
        mContext = context;
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = mInflater.inflate(R.layout.title_view, null);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        this.addView(v,layoutParams);
        mTitle = (TextView) v.findViewById(R.id.tv_title);
        mLeft = (TextView) v.findViewById(R.id.tv_back);
        mRigh = (TextView) v.findViewById(R.id.bt_right);
        mRightImage = (ImageView) v.findViewById(R.id.mRightImage);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
        mTitleString = title;
    }

    public void setTitle(int textId){
        mTitle.setText(textId);
    }

    public void setLeftText(String text){ mLeft.setText(text);}

    public void setLeftText(int resId){ mLeft.setText(resId);}

    public void setLeftClickListener(OnClickListener lis) {
        mLeft.setOnClickListener(lis);
    }

    public void setLeftVisiable(boolean visible) {
        mLeft.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setRightClickListener(OnClickListener lis, String text) {
        mRigh.setOnClickListener(lis);
        if (text != null) {
            mRigh.setText(text);
            mRigh.setVisibility(View.VISIBLE);
        } else {
            mRigh.setVisibility(View.GONE);
        }
    }

    public void setRightImageClickListener(OnClickListener lis,int drawid) {
        mRightImage.setOnClickListener(lis);
        if (drawid != 0) {
            mRightImage.setBackgroundResource(drawid);
            mRightImage.setVisibility(View.VISIBLE);
        } else {
            mRightImage.setVisibility(View.GONE);
        }
    }



    /**
     * 设置背景色
     * @param color
     */
    public void mSetBackgroundColor(int color) {
        findViewById(R.id.layout_content).setBackgroundColor(color);
    }

    /**
     * 设置右边文本的背景
     * @param mDrawable
     */
    public void setRightTextVBackgroud(Drawable mDrawable){
        mRigh.setBackgroundDrawable(mDrawable);
    }

    /**
     * 设置title栏下方的分割线，显示or隐藏
     */
    public void setBottomLineState(int status){
        findViewById(R.id.view_bottom_line).setVisibility(status);
    }

}