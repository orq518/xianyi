package com.xianyi.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.xianyi.bean.BannerBean;
import com.xianyi.customviews.CycleImageLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * ${todo}<顶部的banner轮播>
 *
 * @author lht
 * @data: on 15/11/24 14:49
 */
public class BannerManager {

    private Context mCtx;
    private CycleImageLayout mBannerView;

    private CycleImageLayout.ImageCycleViewListener mBannerListener;

    public List<BannerBean.Licai_banner> mBannerlist;

    private ArrayList<String> mBannerUrl = new ArrayList<String>();
    private ArrayList<String> mBannerDetailUrl = new ArrayList<String>();
    private ArrayList<String> mBannerTitle = new ArrayList<String>();

    public BannerManager(Context mCtx, CycleImageLayout mBannerView, CycleImageLayout.ImageCycleViewListener mBannerListener) {
        this.mBannerView = mBannerView;
        this.mCtx = mCtx;
        this.mBannerListener = mBannerListener;

    }

    public void setBannerData(List<BannerBean.Licai_banner> slides) {
        this.mBannerlist = slides;
        if (null != mBannerlist) {
            mBannerUrl.clear();
            mBannerDetailUrl.clear();
            mBannerTitle.clear();
            for (BannerBean.Licai_banner bean : slides) {
                mBannerUrl.add(bean.img_url);
                mBannerDetailUrl.add(bean.url);
            }
        }

        initBanner();
    }

    /**
     * 初始化banner
     */
    private void initBanner() {
        if (getBannerCount() != 0) {
            mBannerView.setImageResources(getImageUrlList(), getDetailUrlList(), mBannerListener);
        } else {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mBannerView.getLayoutParams();
        }

    }

    /**
     * 点击某一图片
     *
     * @param position
     * @param imageView
     */
    public void clickImage(int position, View imageView) {
        String url = (String) getDetailUrlList().get(position);
        if (Utils.isEmpty(url)) {
            return;
        }
        // 进入webview

    }

    /**
     * 显示image
     *
     * @param imageURL
     * @param imageView
     */
    public void displayImage(String imageURL, ImageView imageView) {
        ImageManager.getInstance(mCtx).getBitmap(imageURL,
                new ImageManager.ImageCallBack() {
                    @Override
                    public void loadImage(ImageView imageView, Bitmap bitmap) {
                        if (bitmap != null && imageView != null) {
                            imageView.setImageBitmap(bitmap);
                            imageView
                                    .setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                    }
                }, imageView);
    }

    /**
     * banner 个数
     *
     * @return
     */
    public int getBannerCount() {
        if (null != mBannerlist) {
            return mBannerlist.size();
        } else {
            return 0;
        }
    }

    public ArrayList getImageUrlList() {
        return mBannerUrl;
    }


    public ArrayList getDetailUrlList() {
        return mBannerDetailUrl;
    }

    public ArrayList getImageTitleList() {return mBannerTitle;   }

}
