package com.xianyi.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xianyi.R;
import com.xianyi.customviews.TitleView;
import com.xianyi.utils.LogUtil;
import com.xianyi.utils.TestData;
import com.xianyi.utils.Utils;

import java.util.ArrayList;

/**
 * 发布分类
 */
public class SelectType2Activity extends BaseActivity {
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
     * 是否能多选
     */
    boolean isMultiple = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_selecttype_layout);
        mContext = this;
        mTitleView = (TitleView) findViewById(R.id.title);
        String title = getIntent().getStringExtra("title");
        isMultiple = getIntent().getBooleanExtra("isMultiple", false);
        mTitleView.setTitle(title);
        mTitleView.setLeftClickListener(new TitleLeftOnClickListener());
        listview = (ListView) findViewById(R.id.listview);
        adapter = new ListViewAdapter(this);
        listview.setAdapter(adapter);
        setTestData();
        adapter.setData(listData);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!isMultiple) {
                    Intent intent = new Intent();
                    intent.putExtra("data", ((TypeClass)adapter.getItem(position)).name);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });
    }


    public void setTestData() {
        for (int i = 0; i < TestData.yingtongfushi.length; i++) {
            TypeClass typeClass = new TypeClass();
            typeClass.name = TestData.yingtongfushi[i];
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (resultCode) {
            case SELECTDATA:
                if (data != null) {

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

        public ArrayList<TypeClass> getData() {
            return data;
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
                convertView = mInflater.inflate(R.layout.type_list_item2, null);
                viewHolder = new ViewHolder();
                viewHolder.name = (TextView) convertView.findViewById(R.id.name);
                viewHolder.select = (CheckBox) convertView.findViewById(R.id.checkbox);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.name.setText(data.get(position).name);
            if (isMultiple) {
                viewHolder.select.setVisibility(View.VISIBLE);
                if (data.get(position).isSelected) {
                    viewHolder.select.setChecked(true);
                } else {
                    viewHolder.select.setChecked(false);
                }
                viewHolder.select.setTag("" + position);
                viewHolder.select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        String idString = (String) buttonView.getTag();
                        int index = Integer.parseInt(idString);
                        data.get(index).isSelected = isChecked;
                    }
                });
            } else {
                viewHolder.select.setVisibility(View.GONE);
            }
            return convertView;
        }


        class ViewHolder {
            TextView name;
            CheckBox select;
        }

    }

    class TypeClass {
        String name;
        boolean isSelected;
    }

    public void goBack() {
        String dataString = "";
        if (isMultiple) {
            for (int i = 0; i < adapter.getData().size(); i++) {
                TypeClass typeClass = adapter.getData().get(i);
                if (typeClass.isSelected) {
                    dataString = Utils.isEmpty(dataString)?dataString+ typeClass.name:dataString+"/" + typeClass.name;
                }
            }
        }
        Intent intent = new Intent();
        intent.putExtra("data", dataString);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onBack() {
        goBack();
    }
}
