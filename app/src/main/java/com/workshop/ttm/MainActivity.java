package com.workshop.ttm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import com.workshop.ttm.Adapters.FragmentAdapter;

public class MainActivity extends AppCompatActivity {

    TabLayout tablayout;
    ViewPager2 viewPager2;
    FragmentAdapter adap;
    private String[] title= new String[]{"Tasks","Postponed","+","Status","Profile"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        tablayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);
        adap=new FragmentAdapter(this);

        viewPager2.setAdapter(adap);

       new TabLayoutMediator(tablayout, viewPager2, ((tab, position) -> tab.setText(title[position]))).attach();
    }
}