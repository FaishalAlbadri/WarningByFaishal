package com.faishalbadri.instagramcoursebyfaishal.repository.home_tab_list;

import android.support.v4.app.Fragment;

/**
 * Created by faishal on 11/12/17.
 */

public class HomeTabList {

  Fragment fragmentTab;
  int imageTab;

  public HomeTabList(Fragment fragmentTab, int imageTab) {
    this.fragmentTab = fragmentTab;
    this.imageTab = imageTab;
  }

  public Fragment getFragmentTab() {
    return fragmentTab;
  }

  public void setFragmentTab(Fragment fragmentTab) {
    this.fragmentTab = fragmentTab;
  }

  public int getImageTab() {
    return imageTab;
  }

  public void setImageTab(int imageTab) {
    this.imageTab = imageTab;
  }
}
