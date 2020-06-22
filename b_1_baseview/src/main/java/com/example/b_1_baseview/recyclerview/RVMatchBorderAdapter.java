package com.example.b_1_baseview.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b_1_baseview.R;
import com.sj.commonres.adapter.BaseRVAdapter;

import java.util.List;

/**
 * Created by SJ on 2020/5/14.
 */
public class RVMatchBorderAdapter extends BaseRVAdapter<String, RVMatchBorderAdapter.ViewHolder, BaseRVAdapter.RVItemClickListener> {


    public RVMatchBorderAdapter(Context context, List<String> lists) {
        super(context, lists);
    }

    @Override
    protected int getResId() {
        return R.layout.item_content_match_border;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getResId(), parent, false);
        view.getLayoutParams().height = parent.getHeight() / 3;
        return getViewHolder(view);
    }

    @Override
    protected ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        super.onBindViewHolder(holder, position);
        holder.tvContent.setText(getLists().get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content);
            Log.e("TAG", "itemView:" + itemView.toString());//复用的部分
            Log.e("TAG", "ViewHolder:" + this.toString());//提升效率的部分
        }
    }
}
