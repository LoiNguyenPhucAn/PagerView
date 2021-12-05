package com.example.pagerview;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String[] contentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentNumber = getResources().getStringArray(R.array.contentFrg);


        ViewPager viewPagerComponent = findViewById(R.id.viewPager);
        PagerAdapterView adapterView = new PagerAdapterView(this,contentNumber);
        viewPagerComponent.setAdapter(adapterView);
        viewPagerComponent.setCurrentItem(0,true);
        //Customize the animation using PageTransformer
        //https://developer.android.com/training/animation/screen-slide#pagetransformer
        viewPagerComponent.setPageTransformer(true,new ZoomOutPageTransformer());

    }
}