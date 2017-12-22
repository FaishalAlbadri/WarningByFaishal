package com.faishalbadri.instagramcoursebyfaishal.ui.home.fragment.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.faishalbadri.instagramcoursebyfaishal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivityFragment extends Fragment {


  public ActivityFragment() {
    // Required empty public constructor
  }

  public static ActivityFragment instance() {
    return new ActivityFragment();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_activity, container, false);
  }

}
