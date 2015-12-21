package com.xianyi.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.xianyi.R;
import com.xianyi.customviews.TitleView;
import com.xianyi.customviews.residelayout.SlidingMenu;
import com.xianyi.fragment.BaseFragment;
import com.xianyi.fragment.ClassifyFragment;
import com.xianyi.fragment.FindFragment;
import com.xianyi.interfaces.IRecordFinish;
import com.xianyi.utils.LogUtil;
import com.xianyi.utils.PictureUtil;
import com.xianyi.utils.RecordMediaPlayer;
import com.xianyi.utils.RecordTools;
import com.xianyi.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class PublishActivity extends BaseActivity implements IRecordFinish {
    /**
     * 上下文
     **/
    private Context mContext;
    /**
     * 顶部布局
     **/
    private TitleView mTitleView;
    MediaAdapter adapter;
    GridView add_detail_gridview;
    private List<MeidaType> meidaTypeList = new ArrayList<MeidaType>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_layout);
        mContext = this;
        mTitleView = (TitleView) findViewById(R.id.title);
        mTitleView.setTitle("");
        mTitleView.setLeftClickListener(new TitleLeftOnClickListener());
        add_detail_gridview = (GridView) findViewById(R.id.add_detail_gridview);
        adapter = new MediaAdapter(this);
        add_detail_gridview.setAdapter(adapter);
        add_detail_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MeidaType meidaType = meidaTypeList.get(position);
                if (meidaType.type.equals("1")) {//图片
                    Intent intent = new Intent(PublishActivity.this, PicLookActivity.class);
                    intent.putExtra("picpath", meidaType.pathString);
                    startActivity(intent);
                } else if (meidaType.type.equals("2")) {//语音
                    RecordMediaPlayer player = RecordMediaPlayer.getInstance();
                    player.play(meidaType.pathString);
                } else if (meidaType.type.equals("3")) {//添加图片
                    //使用startActivityForResult启动SelectPicPopupWindow当返回到此Activity的时候就会调用onActivityResult函数
                    Intent intent1 = new Intent(mContext,
                            SelectPicPopupWindow.class);
                    startActivityForResult(intent1, PICKPHOTO);
                } else if (meidaType.type.equals("4")) {//添加语音
//                    RecordMediaPlayer player = RecordMediaPlayer.getInstance();
//                    player.play(meidaType.pathString);

                    RecordTools recordTools = new RecordTools(mContext, PublishActivity.this);
                    recordTools.showVoiceDialog();
                }
            }
        });
        initPicData();
    }

    public void initPicData() {
        MeidaType meidaType_pic = new MeidaType();
        meidaType_pic.type = "3";
        MeidaType meidaType_voice = new MeidaType();
        meidaType_voice.type = "4";
        meidaTypeList.add(meidaType_pic);
        meidaTypeList.add(meidaType_voice);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("PublishActivity--onDestroy");
    }

    @Override
    public void RecondSuccess(String voicePath) {

    }
    final int PICKPHOTO = 1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (resultCode) {
            case PICKPHOTO:
                if (data != null) {
                    LogUtil.d("ouou", "#####path:" + data.getStringExtra("path"));
                    String picPath = data.getStringExtra("path");
                    if (!Utils.isEmpty(picPath)) {
                        Bitmap image = PictureUtil
                                .getSmallBitmap(picPath);
                        if (image != null) {
                            MeidaType meidaType = new MeidaType();
                            meidaType.type = "1";
                            meidaType.bitmap = image;
                            meidaType.pathString = picPath;
                            meidaTypeList.add(0,meidaType);
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
                break;
            default:
                break;

        }
    }
    /**
     * 顶部布局--左按钮事件监听
     */
    public class TitleLeftOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            finish();
        }

    }

    //自定义适配器
    class MediaAdapter extends BaseAdapter {
        private LayoutInflater inflater;

        public MediaAdapter(Context context) {
            super();
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (null != meidaTypeList) {
                return meidaTypeList.size();
            } else {
                return 0;
            }
        }

        @Override
        public Object getItem(int position) {
            return meidaTypeList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.media_layout, null);
                viewHolder = new ViewHolder();
                viewHolder.play = (ImageView) convertView.findViewById(R.id.play);
                viewHolder.delete = (ImageView) convertView.findViewById(R.id.delete);
                viewHolder.tv_info = (TextView) convertView.findViewById(R.id.info_tv);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            MeidaType meidaType = meidaTypeList.get(position);
            if (meidaType.type.equals("1")) {//图片
                viewHolder.play.setImageBitmap(meidaType.bitmap);
                viewHolder.tv_info.setVisibility(View.GONE);
            } else if (meidaType.type.equals("2")) {//语音
                viewHolder.play.setImageResource(R.drawable.voice_play);
                viewHolder.tv_info.setVisibility(View.GONE);
            } else if (meidaType.type.equals("3")) {//添加图片
                viewHolder.play.setImageResource(R.drawable.btn_addpic);
                viewHolder.tv_info.setVisibility(View.VISIBLE);
            } else if (meidaType.type.equals("4")) {//添加语音
                viewHolder.play.setImageResource(R.drawable.btn_record);
                viewHolder.tv_info.setVisibility(View.VISIBLE);
            }
            viewHolder.delete.setTag(meidaType.pathString);

//            viewHolder.delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    String tag = (String) v.getTag();
//                    int index = -1;
//                    MeidaType curType = null;
//                    for (int i = 0; i < meidaTypeList.size(); i++) {
//                        if (tag.equals(meidaTypeList.get(i).pathString)) {
//                            curType = meidaTypeList.get(i);
//                            index = i;
//
//                            break;
//                        }
//                    }
//                    if (curType != null && index >= 0 && curType.type.equals("2")) {
//                        RecordMediaPlayer player = RecordMediaPlayer.getInstance();
//                        player.deleteFile(curType.pathString);
//                    }
//                    meidaTypeList.remove(index);
//                    adapter.notifyDataSetChanged();
//
//
//                }
//            });

            return convertView;
        }

    }

    class ViewHolder {
        public ImageView play;
        public ImageView delete;
        public TextView tv_info;
    }

    class MeidaType {
        /**
         * 1：图片  2：语音  3:添加图片  4：添加语音
         */
        String type;
        Bitmap bitmap;
        String pathString;
    }

}
