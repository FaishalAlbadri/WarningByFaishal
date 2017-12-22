package com.faishalbadri.instagramcoursebyfaishal.zz_package_trash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.faishalbadri.instagramcoursebyfaishal.repository.home_tab_list.HomeTabList;
import java.util.List;

/**
 * Created by faishal on 11/12/17.
 */

public class HomeTabAdapter extends FragmentPagerAdapter {

  List<HomeTabList> data;
  Context context;

  public HomeTabAdapter(FragmentManager fm, List<HomeTabList> data, Context context) {
    super(fm);
    this.data = data;
    this.context = context;
  }

  @Override
  public Fragment getItem(int position) {
    Fragment fragment = null;
    fragment= data.get(position).getFragmentTab();
    return fragment;
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public CharSequence getPageTitle(int position) {
    Drawable image = context.getResources().getDrawable(data.get(position).getImageTab());
    image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
    SpannableString sb = new SpannableString(" ");
    ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
    sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    return sb;
  }
}


//  int[] image;
//  Fragment[] fragments;
//  ArrayList<HomeTabList> data = new ArrayList<>();
//  HomeTabAdapter homeTabAdapter = new HomeTabAdapter(getSupportFragmentManager(), data, HomeActivity.this);
//  @BindView(R.id.viewpager_home)
//  ViewPager viewpagerHome;
//  @BindView(R.id.tablayout_home)
//  TabLayout tablayoutHome;

//  private void setDataTab() {
//    image = new int[]{
//        R.drawable.ic_home_black,
//        R.drawable.ic_search_black,
//        R.drawable.ic_add_black,
//        R.drawable.ic_activity_black,
//        R.drawable.ic_profile_black
//    };
//
//    fragments = new Fragment[]{
//        new HomeFragment(),
//        new SearchFragment(),
//        new PostFragment(),
//        new ActivityFragment(),
//        new ProfileFragment()
//    };
//
//    data.add(new HomeTabList(fragments[0], image[0]));
//    data.add(new HomeTabList(fragments[1], image[1]));
//    data.add(new HomeTabList(fragments[2], image[2]));
//    data.add(new HomeTabList(fragments[3], image[3]));
//    data.add(new HomeTabList(fragments[4], image[4]));
//  }


//    setDataTab();
//    viewpagerHome.setAdapter(homeTabAdapter);
//    tablayoutHome.setupWithViewPager(viewpagerHome);
