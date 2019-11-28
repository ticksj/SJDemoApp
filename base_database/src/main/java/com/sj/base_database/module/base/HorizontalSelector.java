package com.sj.base_database.module.base;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sj.base_database.R;

import java.util.List;

public class HorizontalSelector<T> {
    private final Context context;
    private RecyclerView recyclerView;
    List<T> lists;
    List<String> desList;
    private HorizontalSelectorAdapter adapter;
    private HorizontalSelectorListener<T> listener;

    public HorizontalSelector(Context context, RecyclerView recyclerView, List<T> lists,List<String> desList,HorizontalSelectorListener<T> listener) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.lists = lists;
        this.desList = desList;
        this.listener = listener;
        init();
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        adapter = new HorizontalSelectorAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void setDefaultPosition(int position){
        adapter.setSelectPosition(position);
    }


    class HorizontalSelectorAdapter extends RecyclerView.Adapter<HorizontalSelectorAdapter.ViewHolder>{
        int selectPosition = -1;

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_horizontal_selector,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            holder.tv.setText(desList.get(position));
            if (selectPosition==position) {
                holder.tv.setBackgroundColor(Color.parseColor("#ff0000"));
            }else {
                holder.tv.setBackgroundColor(Color.parseColor("#00ff00"));
            }
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setSelectPosition(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return lists.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView tv;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tv);
            }
        }

        public void setSelectPosition(int selectPosition) {
            this.selectPosition = selectPosition;
            notifyDataSetChanged();
            listener.selectObject(lists.get(selectPosition));
        }
    }
    public interface HorizontalSelectorListener<T>{
        void selectObject(T t);
    }

}
