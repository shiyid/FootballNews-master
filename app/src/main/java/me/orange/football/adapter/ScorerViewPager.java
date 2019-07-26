package me.orange.football.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.orange.football.R;
import me.orange.football.fragment.ScorerFragmentFactory;
import me.orange.football.util.Utils;

/**
 * 射手榜viewpager适配器
 */
public class ScorerViewPager extends FragmentPagerAdapter {

    //tab标签的标题
    private String[] tabTitle;

    public ScorerViewPager(FragmentManager fm) {
        super(fm);
        tabTitle = Utils.getStringArray(R.array.tab_league_title);
    }

    @Override
    public Fragment getItem(int position) {
        return ScorerFragmentFactory.createFragment(position);
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
