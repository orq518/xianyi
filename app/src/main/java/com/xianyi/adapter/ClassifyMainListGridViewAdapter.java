package com.xianyi.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.xianyi.R;

import java.util.List;

/**
 * ${todo}<自定义适配器 >
 *
 * @author lht
 * @data: on 15/12/17 14:34
 */
public class ClassifyMainListGridViewAdapter extends BaseAdapter {
    private Context context;
    // 里面所有的方法表示的是可以根据指定的显示图片的数量,进行每个图片的处理
    private int[] image = new int[]{
            R.drawable.mainlist_more_1, R.drawable.mainlist_more_2,
            R.drawable.mainlist_more_1, R.drawable.mainlist_more_2};

    public ClassifyMainListGridViewAdapter(Context context) {
        this.context = context;
    }

    public int getCount() { // 取得要显示内容的数量
        return image.length;
    }

    public Object getItem(int position) { // 每个资源的位置
        return image[position];
    }

    public long getItemId(int position) { // 取得每个项的ID
        return image[position];
    }

    // 将资源设置到一个组件之中，很明显这个组件是ImageView
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(context);
        iv.setBackgroundColor(0xFFFFFFFF);
        iv.setImageResource(image[position]);// 给ImageView设置资源
        iv.setScaleType(ImageView.ScaleType.CENTER);// 设置对齐方式
        iv.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return iv;
    }
}

///**GirdView 数据适配器*/
//public class ClassifyMainListGridViewAdapter extends BaseAdapter {
//    Context context;
//    private int[] image = new int[]{
//            R.drawable.mainlist_more_1, R.drawable.mainlist_more_2,
//            R.drawable.mainlist_more_1, R.drawable.mainlist_more_2};
//
//    public ClassifyMainListGridViewAdapter(Context _context) {
//        this.context = _context;
//    }
//
//    @Override
//    public int getCount() {
//        return image.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return image[position];
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater layoutInflater = LayoutInflater.from(context);
//        convertView = layoutInflater.inflate(R.layout.classify_main_list_more_gridview, null);
//        ImageView img = (ImageView) convertView.findViewById(R.id.ItemImage);
//        img.setImageResource(image[position]);
//        return convertView;
//
//    }
//}