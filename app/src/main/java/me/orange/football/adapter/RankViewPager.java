package me.orange.football.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.orange.football.R;
import me.orange.football.fragment.RankFragmentFactory;
import me.orange.football.util.Utils;

/**
 * 积分榜Viewpager适配器
 */
public class RankViewPager extends FragmentPagerAdapter {

    //tab标签的标题
    private String[] tabTitle;

    public RankViewPager(FragmentManager fm) {
        super(fm);
        tabTitle = Utils.getStringArray(R.array.tab_league_title);
    }

    @Override
    public Fragment getItem(int position) {
        return RankFragmentFactory.createFragment(position);
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
