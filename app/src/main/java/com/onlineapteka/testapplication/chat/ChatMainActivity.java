package com.onlineapteka.testapplication.chat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.onlineapteka.testapplication.MainActivity;
import com.onlineapteka.testapplication.R;
import com.onlineapteka.testapplication.chat.fragments.ChatFragment;
import com.onlineapteka.testapplication.chat.fragments.DoctorsFragment;
import com.onlineapteka.testapplication.professions.ProfessionsInMedicineActivity;

import java.util.ArrayList;

public class ChatMainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    public static void start(Context context){
        context.startActivity(new Intent(context, ChatMainActivity.class));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_main);
        initViews();
    }

    private void initViews() {
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.chat_view_pager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ChatFragment(),"Чаты");
        viewPagerAdapter.addFragment(new DoctorsFragment(),"Докторы");
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        private ArrayList<Fragment>  mFragments;
        private ArrayList<String> mTitles;


        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            this.mFragments = new ArrayList<>();
            this.mTitles = new ArrayList<>();
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title){
            mFragments.add(fragment);
            mTitles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }
    }
}