package com.sj.b_3_view.d_scroll_conflict;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.sj.b_3_view.R;
import com.sj.commonres.adapter.BaseRVAdapter;

import java.util.List;

/**
 * Created by SJ on 2020/2/19.
 */
public class RvWithGvAdapter extends BaseRVAdapter<List<String>, RvWithGvAdapter.ViewHolder, BaseRVAdapter.RVItemClickListener> {

    public RvWithGvAdapter(Context context, List<List<String>> lists) {
        super(context, lists);
    }

    @Override
    protected int getResId() {
        return R.layout.item_rv;
    }

    @Override
    protected ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //导致内容显示不全的原因
        View view = LayoutInflater.from(context).inflate(getResId(), null);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.gv.setAdapter(new GvAdapter(context, getLists().get(position)));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private MyGridView gv;

        public ViewHolder(View itemView) {
            super(itemView);
            gv = (MyGridView) itemView.findViewById(R.id.gv);
        }
    }
}
