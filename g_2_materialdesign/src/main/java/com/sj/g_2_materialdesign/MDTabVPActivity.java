package com.sj.g_2_materialdesign;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.sj.commonres.BaseActivity;
import com.sj.commonres.BaseFragment;
import com.sj.commonres.EmptyFragment;

import java.util.ArrayList;
import java.util.List;

public class MDTabVPActivity extends BaseActivity {
    private TabLayout tablayout;
    private ViewPager vp;

    @Override
    protected int setLayoutResID() {
        return R.layout.activity_md_tab_vp;
    }

    @Override
    protected void initView() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        vp = (ViewPager) findViewById(R.id.vp);
        initViewPager();
    }

    private void initViewPager() {
        List<String> titles = new ArrayList<>();
        List<BaseFragment> fragments = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            titles.add("Tab" + i);
            tablayout.addTab(tablayout.newTab().setText("Tab" + i));
            fragments.add(new EmptyFragment());
        }
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), titles, fragments);
        vp.setAdapter(fragmentAdapter);
        tablayout.setupWithViewPager(vp);
        tablayout.setTabsFromPagerAdapter(fragmentAdapter);
    }

    public class FragmentAdapter extends FragmentStatePagerAdapter{
        List<String> titles;
        List<BaseFragment> fragments;

        public FragmentAdapter(@NonNull FragmentManager fm, List<String> titles, List<BaseFragment> fragments) {
            super(fm);
            this.titles = titles;
            this.fragments = fragments;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}
