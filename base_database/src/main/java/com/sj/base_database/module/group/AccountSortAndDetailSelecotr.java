package com.sj.base_database.module.group;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.sj.base_database.bean.AccountDetail;
import com.sj.base_database.bean.AccountSort;
import com.sj.base_database.module.base.HorizontalSelector;

public class AccountSortAndDetailSelecotr {
    private final Context context;
    private RecyclerView sortRv;
    private RecyclerView detailRv;
    HorizontalSelector<AccountSort> sortSelector;
    HorizontalSelector<AccountDetail> sortDetailSelector;
    private SelectorListener listener;

    public AccountSortAndDetailSelecotr(Context context, RecyclerView sortRv, RecyclerView detailRv, SelectorListener listener) {
        this.context = context;
        this.sortRv = sortRv;
        this.detailRv = detailRv;
        this.listener = listener;
        init();
    }

    private void init() {

//        sortSelector = new HorizontalSelector<>(context, sortRv, sortList, sortDesList, new HorizontalSelector.HorizontalSelectorListener<AccountSort>() {
//            @Override
//            public void selectObject(final AccountSort accountSort) {
//                List<AccountDetail> detailList = accountSort.getDefaultDetails();
//                List<String> detailDesList = new ArrayList<>();
//                for (AccountDetail detail : detailList) {
//                    detailDesList.add(detail.getName());
//                }
//                sortDetailSelector = new HorizontalSelector<>(context, detailRv, detailList, detailDesList, new HorizontalSelector.HorizontalSelectorListener<AccountDetail>() {
//                    @Override
//                    public void selectObject(AccountDetail accountDetail) {
//                        listener.selectAccount(accountSort,accountDetail);
//                    }
//                });
//            }
//        });
        sortSelector.setDefaultPosition(0);
    }

    public interface SelectorListener{
        void selectAccount(AccountSort accountSort, AccountDetail accountDetail);
    }


}
