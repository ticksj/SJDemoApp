package com.example.b_1_baseview.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.b_1_baseview.R;
import com.sj.commonres.adapter.BaseRVAdapter;

import java.util.List;

/**
 * Created by SJ on 2020/5/14.
 */
public class RVAdapter extends BaseRVAdapter<String, RVAdapter.ViewHolder, BaseRVAdapter.RVItemClickListener> {


    public RVAdapter(Context context, List<String> lists) {
        super(context, lists);
    }

    @Override
    protected int getResId() {
        return R.layout.item_content;
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

    /**
     *
     * @param holder
     * @param position
     * @param payloads 增量更新
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        }else {

        }
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
