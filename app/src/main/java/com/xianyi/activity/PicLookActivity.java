package com.xianyi.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.xianyi.R;
import com.xianyi.utils.PictureUtil;
import com.xianyi.utils.Utils;


/**
 * @data: on 15/11/2 16:35
 */
public class PicLookActivity extends BaseActivity implements OnClickListener {
    /**
     * 上下文
     **/
    private Context mContext;
    ImageView im_icon;
    String pathString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_piclook);
        initViews();
    }


    public void initViews() {
        im_icon = (ImageView) findViewById(R.id.im_icon);
        pathString = getIntent().getStringExtra("picpath");
        if (!Utils.isEmpty(pathString)) {
            Bitmap image = PictureUtil
                    .getSmallBitmap(pathString);
            im_icon.setImageBitmap(image);
        }
    }


}
