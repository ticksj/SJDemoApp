package com.sj.g_2_materialdesign;


import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.sj.commonres.BaseActivity;
import com.sj.commonres.BaseFragment;
import com.sj.commonres.EmptyFragment;

import java.util.ArrayList;
import java.util.List;

public class MDDrawerTabNavigationVPActivity extends BaseActivity {
    private DrawerLayout dl;
    private TabLayout tablayout;
    private ViewPager vp;
    private NavigationView nv;



    @Override
    protected int setLayoutResID() {
        return R.layout.activity_md_drawer_tab_nav_vp;
    }

    @Override
    protected void initView() {
        dl = (DrawerLayout) findViewById(R.id.dl);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        vp = (ViewPager) findViewById(R.id.vp);
        nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                initViewPager(item.getTitle().toString());
                dl.closeDrawers();
                return true;
            }
        });
        initViewPager("Tab");
    }

    private void initViewPager(String name) {
        List<String> titles = new ArrayList<>();
        List<BaseFragment> fragments = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            titles.add(name + i);
            tablayout.addTab(tablayout.newTab().setText(name + i));
            fragments.add(new EmptyFragment());
        }
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), titles, fragments);
        vp.setAdapter(fragmentAdapter);
        tablayout.setupWithViewPager(vp);
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
