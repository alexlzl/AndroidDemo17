package com.xyliwp.tablayoutdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {


    private TabLayout tabLayout_shouye;
    private ViewPager viewPager_shouye;
    private List<String> strings = new ArrayList<String>();;
    private List<Fragment> fragments = new ArrayList<Fragment>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdate();
        initView();
    }


    private void initView(){
        tabLayout_shouye = (TabLayout)findViewById(R.id.tablayout_shouye);
        viewPager_shouye = (ViewPager)findViewById(R.id.viewpager_ShouYe);
        TabFragmentShouYeAdapter pagerAdapter=new TabFragmentShouYeAdapter(fragments,strings,
                getSupportFragmentManager(),this);
        viewPager_shouye.setAdapter(pagerAdapter);
        tabLayout_shouye.setupWithViewPager(viewPager_shouye);
//        tabLayout_shouye.setTabTextColors(getResources().getColor(R.color.radiobutton)
//                ,getResources().getColor(R.color.colorPrimaryDark));
        tabLayout_shouye.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < tabLayout_shouye.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout_shouye.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }
        tabLayout_shouye.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_shouye.setCurrentItem(tab.getPosition(),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager_shouye.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this,position+1+"",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initdate(){
        Fragment1 fragment1 = new Fragment1();
        fragments.add(fragment1);
        strings.add("推荐");
        Fragement2 fragment2 = new Fragement2();
        fragments.add(fragment2);
        strings.add("热点");

        Fragement3 fragment3 = new Fragement3();
        fragments.add(fragment3);
        strings.add("视频");
        Fragment4 fragment4 = new Fragment4();
        fragments.add(fragment4);
        strings.add("西安");
        Fragment5 fragment5 = new Fragment5();
        fragments.add(fragment5);
        strings.add("社会");
        Fragment6 fragment6 = new Fragment6();
        fragments.add(fragment6);
        strings.add("娱乐");
        Fragment7 fragment7 = new Fragment7();
        fragments.add(fragment7);
        strings.add("图片");
    }

}
