package com.sj.b_3_view.d_scroll_conflict;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sj.b_3_view.R;

import java.util.List;

public class GvAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private String[] roomStatusColor = null;
    private int[] diagramSize = null;
    private int TYPE_MODE = 1;


    private List<String> strings;
    private int length = 0;

    public GvAdapter(Context context, List<String> strings) {
        inflater = LayoutInflater.from(context);
        this.strings = strings;
    }

    public int getCount() {
        return strings.size();
    }

    public String getItem(int position) {
        return  strings.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    //	房态日志列表界面入口
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_gv, parent, false);
            holder = new ViewHolder();
            holder.tv = convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(getItem(position));
        return convertView;
    }


    private static class ViewHolder {
        TextView tv;
    }

}
