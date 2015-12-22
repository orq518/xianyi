package com.xianyi.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xianyi.R;
import com.xianyi.customviews.TitleView;
import com.xianyi.utils.LogUtil;
import com.xianyi.utils.PictureUtil;
import com.xianyi.utils.TestData;
import com.xianyi.utils.Utils;

import java.util.ArrayList;

/**
 * 发布分类
 */
public class PublishSelectTypeActivity extends BaseActivity {
    /**
     * 上下文
     **/
    private Context mContext;
    /**
     * 顶部布局
     **/
    private TitleView mTitleView;
    ListView listview;
    ListViewAdapter adapter;
    ArrayList<TypeClass> listData = new ArrayList<TypeClass>();
    /**
     * 页面来源  type：是分类过来的   want：代表想要啥 过来的
     */
    String from;
    /***
     * 全部分类，左布局图片
     **/
    private int[] listviewImg = new int[]{
            R.drawable.classify_all_left_clothes, R.drawable.classify_all_left_living,
            R.drawable.classify_all_left_toy, R.drawable.classify_all_left_teaching,
            R.drawable.classify_all_left_mama};
    int GETDATA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_selecttype_layout);
        mContext = this;
        from=getIntent().getStringExtra("from");
        mTitleView = (TitleView) findViewById(R.id.title);
        mTitleView.setTitle("选择发布分类");
        mTitleView.setLeftClickListener(new TitleLeftOnClickListener());
        listview = (ListView) findViewById(R.id.listview);
        adapter = new ListViewAdapter(this);
        listview.setAdapter(adapter);
        setData();
        adapter.setData(listData);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, SelectType2Activity.class);
                if("type".equals(from)){
                    intent.putExtra("isMultiple", false);
                }else if("want".equals(from)){
                    intent.putExtra("isMultiple", true);
                }else {
                    intent.putExtra("isMultiple", true);
                }
                intent.putExtra("title", ((TypeClass) (adapter.getItem(position))).name);
                startActivityForResult(intent, GETDATA);
            }
        });
    }


    public void setData() {
        for (int i = 0; i < listviewImg.length; i++) {
            TypeClass typeClass = new TypeClass();
            typeClass.name = TestData.fenlei[i];
            typeClass.id = listviewImg[i];
            listData.add(typeClass);
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d("PublishActivity--onDestroy");
    }

    final int SELECTDATA = 1;

    String selectedData;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case SELECTDATA:
                if (data != null&&resultCode==RESULT_OK) {
                    selectedData=data.getStringExtra("data");
                    goBack();
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
            goBack();
        }

    }

    public class ListViewAdapter extends BaseAdapter {

        private LayoutInflater mInflater;
        ArrayList<TypeClass> data = new ArrayList<TypeClass>();

        public ListViewAdapter(Context mCtx) {
            mInflater = LayoutInflater.from(mCtx);
        }

        public void setData(ArrayList<TypeClass> listdata) {
            data.clear();
            data.addAll(listdata);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.type_list_item, null);
                viewHolder = new ViewHolder();
                viewHolder.left_ic = (ImageView) convertView.findViewById(R.id.left_ic);
                viewHolder.name = (TextView) convertView.findViewById(R.id.name);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.name.setText(data.get(position).name);
            viewHolder.left_ic.setImageResource(data.get(position).id);
            return convertView;
        }


        class ViewHolder {
            ImageView left_ic;
            TextView name;
        }

    }

    class TypeClass {
        String name;
        int id;
    }
    public void goBack(){
        LogUtil.d("###selectedData:"+selectedData);
        Intent intent=new Intent();
        intent.putExtra("data",selectedData);
        setResult(RESULT_OK,intent);
        finish();
    }
    @Override
    public void onBack() {
        goBack();
    }
}
