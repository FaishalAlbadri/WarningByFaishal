package com.faishalbadri.instagramcoursebyfaishal.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by faishal on 11/6/17.
 */

public class ActivityUtil {

  private static ActivityUtil INSTANCE;
  Context context;


  public static ActivityUtil getInstance(Context context) {
    if (INSTANCE == null) {
      INSTANCE = new ActivityUtil(context);
    }

    return INSTANCE;
  }

  public ActivityUtil(Context context) {
    this.context = context;
  }

  public void addFragment(FragmentManager fm, int frame_layout, Fragment fragment) {
    FragmentTransaction fragmentTransaction = fm.beginTransaction();
    fragmentTransaction.replace(frame_layout, fragment);
    fragmentTransaction.addToBackStack(null);
    fragmentTransaction.commit();
  }

}
