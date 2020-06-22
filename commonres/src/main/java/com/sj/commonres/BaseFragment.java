package com.sj.commonres;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by SJ on 2020/6/22.
 */
public abstract class BaseFragment extends Fragment {

    private View contentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(setResId(), container, false);
        return contentView;
    }

    protected abstract int setResId();
}
