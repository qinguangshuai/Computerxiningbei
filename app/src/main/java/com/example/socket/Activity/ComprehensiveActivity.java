package com.example.socket.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.socket.R;
import com.example.socket.adapter.MyFragmentPagerAdapter;
import com.example.socket.fragment.AdjustmentFragment;
import com.example.socket.fragment.LocationFragment;

import java.util.ArrayList;

/**
 * 嵌套两个fragment
 * 1.调单显示界面
 * 2.机车运行轨迹界面
 */
public class ComprehensiveActivity extends AppCompatActivity{

    private RadioGroup mComRG;
    private RadioButton mComRB1;
    private RadioButton mComRB2;
    private ViewPager mPager;
    private AdjustmentFragment mAdjustmentFragment;
    private LocationFragment mLocationFragment;
    private ArrayList<Fragment> mFragmentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprehensive);

        initView();
        initListener();
    }

    private void initView() {
        mComRG = findViewById(R.id.com_rg);
        mComRB1 = findViewById(R.id.rb_adjust);
        mComRB2 = findViewById(R.id.rb_locat);
        mPager = findViewById(R.id.viewpager);
        //RadioGroup选中状态改变监听
        mComRG.setOnCheckedChangeListener(new myCheckChangeListener());
    }

    private void initListener() {
        /*AdjustmentFragment adjustmentFragment = new AdjustmentFragment();
        LocationFragment locationFragment = new LocationFragment();
        mFragmentsList = new ArrayList<>();
        mFragmentsList.add(adjustmentFragment);
        mFragmentsList.add(locationFragment);
        mPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),mFragmentsList));
        mPager.setCurrentItem(0);
        mPager.setOnPageChangeListener(new myOnPageChangeListener());*/
    }

    /**
     *RadioButton切换Fragment
     */
    private class myCheckChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_adjust:
                    //ViewPager显示第一个Fragment且关闭页面切换动画效果
                    mPager.setCurrentItem(0,false);
                    break;
                case R.id.rb_locat:
                    mPager.setCurrentItem(1,false);
                    break;
            }
        }
    }

    /**
     *ViewPager切换Fragment,RadioGroup做相应变化
     */
    private class myOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position){
                case 0:
                    mComRG.check(R.id.rb_adjust);
                    break;
                case 1:
                    mComRG.check(R.id.rb_locat);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}