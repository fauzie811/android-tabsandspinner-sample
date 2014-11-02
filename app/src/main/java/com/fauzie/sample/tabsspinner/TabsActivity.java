package com.fauzie.sample.tabsspinner;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fauzie.sample.tabsspinner.widget.SlidingTabLayout;

/**
 * Created by Fauzie on 11/2/2014.
 */
public class TabsActivity extends BaseActivity {
    ViewPager mViewPager = null;
    SampleViewPagerAdapter mViewPagerAdapter = null;
    SlidingTabLayout mSlidingTabLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPagerAdapter = new SampleViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);

        Resources res = getResources();
        mSlidingTabLayout.setSelectedIndicatorColors(res.getColor(R.color.tab_selected_strip));
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    private class SampleViewPagerAdapter extends FragmentPagerAdapter {

        public SampleViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            SampleFragment frag = new SampleFragment();
            Bundle args = new Bundle();
            args.putInt("pos", position);
            frag.setArguments(args);
            return frag;
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab item " + (position + 1);
        }
    }

    public static class SampleFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_sample, container, false);

            Bundle b = getArguments();
            if (b != null) {
                int pos = b.getInt("pos");
                TextView text1 = (TextView) v.findViewById(R.id.text1);
                text1.setText("Tab item " + (pos + 1));
            }

            return v;
        }
    }
}
