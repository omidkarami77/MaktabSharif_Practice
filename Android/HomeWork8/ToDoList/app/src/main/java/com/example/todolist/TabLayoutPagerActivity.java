package com.example.todolist;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.omid.hw88.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutPagerActivity extends AppCompatActivity {
    private ViewPagerAdapter adapter;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        updateUI();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                TabLayoutPagerActivity.this.adapter.getItem(i).onResume();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mTabLayout.setupWithViewPager(this.mViewPager);
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments = new ArrayList();
        private List<String> titles = new ArrayList();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            return (Fragment) this.fragments.get(position);
        }

        public int getCount() {
            return this.fragments.size();
        }

        public CharSequence getPageTitle(int position) {
            return (CharSequence) this.titles.get(position);
        }

        public void addFragment(Fragment fragment, String title) {
            this.fragments.add(fragment);
            this.titles.add(title);
        }
    }


    private void updateUI() {
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AllTasksListFragment(), "ALL");
        adapter.addFragment(new DoneTaskListFragment(), "DONE");
        adapter.addFragment(new UndoneTaskListFragment(), "UNDONE");
        mViewPager.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }
}