package com.xyliwp.tablayoutdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lwp940118 on 2016/11/25.
 */
public class TabFragmentShouYeAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragments;
    private List<String> strings;
    private int[] imageResId = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.one,
            R.drawable.two,
            R.drawable.three
            ,  R.drawable.two
    };
    public TabFragmentShouYeAdapter(List<Fragment> fragments, List<String> strings, FragmentManager fragmentManager, Context context){
        super(fragmentManager);
        this.strings = strings;
        this.context = context;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return strings.get(position);
//        Drawable image = context.getResources().getDrawable(imageResId[position]);
//        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
//        SpannableString sb = new SpannableString("dddde ");
//        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return sb;
        return null;
    }

    public View getTabView(int position){
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        TextView tv= (TextView) view.findViewById(R.id.textView);
        tv.setText(strings.get(position));
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        img.setImageResource(imageResId[position]);
        return view;
    }
}
