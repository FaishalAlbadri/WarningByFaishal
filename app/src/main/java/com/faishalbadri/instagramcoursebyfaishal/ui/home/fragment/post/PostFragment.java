package com.faishalbadri.instagramcoursebyfaishal.ui.home.fragment.post;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.faishalbadri.instagramcoursebyfaishal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends Fragment {


  public PostFragment() {
    // Required empty public constructor
  }

  public static PostFragment instance() {
    return new PostFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_post, container, false);
  }

}
