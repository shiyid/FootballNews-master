package me.orange.football.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.orange.football.R;
import me.orange.football.fragment.FragmentFactory;
import me.orange.football.util.Utils;


/**
 * 主页的ViewPager适配器
 */
public class MainViewPager extends FragmentPagerAdapter {

    //tab标签的标题
    private String[] tabTitle;

    public MainViewPager(FragmentManager fm) {
        super(fm);
        tabTitle = Utils.getStringArray(R.array.tab_title);
    }

    //返回当前页面的Fragment
    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createFragment(position);
    }

    //Fragment的数量
    @Override
    public int getCount() {
        return tabTitle.length;
    }

    //返回Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
