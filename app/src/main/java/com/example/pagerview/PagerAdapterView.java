package com.example.pagerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/** https://developer.android.com/reference/androidx/viewpager/widget/PagerAdapter
 * When you implement a PagerAdapter, you must override the following methods at minimum:
 * instantiateItem(ViewGroup, int)
 * destroyItem(ViewGroup, int, Object)
 * getCount()
 * isViewFromObject(View, Object)
 * */

public class PagerAdapterView extends PagerAdapter {

    private Context mContext;
    private String[] content;

    public PagerAdapterView(Context mContext, String[] content) {
        this.mContext = mContext;
        this.content = content;
    }


    @NonNull
    // Create the page for the given position.
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View  instantView = LayoutInflater.from(mContext).inflate(R.layout.content_frg,container,false);
        String instantConent = content[position];

        TextView textView = instantView.findViewById(R.id.tvContent);
        textView.setText(instantConent);

        container.addView(instantView);

        return instantView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((View) object);
    }

    // Return the number of views available.
    @Override
    public int getCount() {
        return content.length;
    }

    /**
     * Determines whether a page View is associated with a specific key object as returned by instantiateItem(ViewGroup, int).
     * This method is required for a PagerAdapter to function properly, that is Object
     * Return true if view is associated with the key object
    **/
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
