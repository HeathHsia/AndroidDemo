package listview.heath.com.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context mContext;
    private List<Brand> dataList;

    public MyListAdapter (Context context, List<Brand> brandList) {
        inflater = LayoutInflater.from(context);
        dataList = brandList;
        mContext = context;
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        // 在自定义Adapter中的getView为item控件赋值
        if (view == null) {
            view = inflater.inflate(R.layout.item, viewGroup, false); // 加载item布局
            holder = new ViewHolder();
            holder.itemImg = view.findViewById(R.id.itemImg);
            holder.itemTitle = view.findViewById(R.id.itemTitle);
            view.setTag(holder);
        }else {
            holder = (ViewHolder)view.getTag();
        }
        Brand brand = dataList.get(i);
        holder.itemTitle.setText(brand.itemTitle);
        Glide.with(mContext).load(brand.itemImgUrl).into(holder.itemImg);
        return view;
    }

    private class ViewHolder {
        TextView itemTitle;
        ImageView itemImg;
    }
}
