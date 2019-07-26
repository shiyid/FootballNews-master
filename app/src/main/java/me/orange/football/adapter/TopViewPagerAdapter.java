package me.orange.football.adapter;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.orange.football.activity.WebViewActivity;
import me.orange.football.bean.Top;
import me.orange.football.util.Utils;

/**
 * 头条viewPager适配器
 */
public class TopViewPagerAdapter extends PagerAdapter {

    private List<Top.Recommend> recommends;

    public TopViewPagerAdapter(List<Top.Recommend> recommends) {
        this.recommends = recommends;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE; //无限循环
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        final int newPosition = position % recommends.size();
        ImageView imageView = new ImageView(Utils.getContext());
        Glide.with(Utils.getContext())
                .load(recommends.get(newPosition).thumb)
                .centerCrop()
                .into(imageView);

        //viewpager点击事件
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Utils.getContext(), WebViewActivity.class);
                intent.putExtra("url", recommends.get(newPosition).url);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Utils.getContext().startActivity(intent);
            }
        });

        container.addView(imageView);

        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
