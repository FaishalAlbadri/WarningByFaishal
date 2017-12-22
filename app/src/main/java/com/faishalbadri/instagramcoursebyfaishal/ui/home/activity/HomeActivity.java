package com.faishalbadri.instagramcoursebyfaishal.ui.home.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.instagramcoursebyfaishal.R;
import com.faishalbadri.instagramcoursebyfaishal.ui.home.fragment.activity.ActivityFragment;
import com.faishalbadri.instagramcoursebyfaishal.ui.home.fragment.home.HomeFragment;
import com.faishalbadri.instagramcoursebyfaishal.ui.home.fragment.post.PostFragment;
import com.faishalbadri.instagramcoursebyfaishal.ui.home.fragment.profile.ProfileFragment;
import com.faishalbadri.instagramcoursebyfaishal.ui.home.fragment.search.SearchFragment;
import com.faishalbadri.instagramcoursebyfaishal.util.ActivityUtil;

public class HomeActivity extends AppCompatActivity {


  @BindView(R.id.imagebutton_home_home)
  ImageButton imagebuttonHomeHome;
  @BindView(R.id.imagebutton_home_search)
  ImageButton imagebuttonHomeSearch;
  @BindView(R.id.imagebutton_home_post)
  ImageButton imagebuttonHomePost;
  @BindView(R.id.imagebutton_home_activity)
  ImageButton imagebuttonHomeActivity;
  @BindView(R.id.imagebutton_home_profile)
  ImageButton imagebuttonHomeProfile;
  ActivityUtil activityUtil;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);
    activityUtil = ActivityUtil.getInstance(getApplicationContext());
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_home, HomeFragment.instance());

  }

  @OnClick(R.id.imagebutton_home_home)
  public void onImagebuttonHomeHomeClicked() {
    homeClicked();
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_home, HomeFragment.instance());
  }

  @OnClick(R.id.imagebutton_home_search)
  public void onImagebuttonHomeSearchClicked() {
    searchClicked();
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_home, SearchFragment.instance());
  }

  @OnClick(R.id.imagebutton_home_post)
  public void onImagebuttonHomePostClicked() {
    postClicked();
    activityUtil
        .addFragment(getSupportFragmentManager(), R.id.framelayout_home, PostFragment.instance());
  }

  @OnClick(R.id.imagebutton_home_activity)
  public void onImagebuttonHomeActivityClicked() {
    activityClicked();
    activityUtil.addFragment(getSupportFragmentManager(), R.id.framelayout_home,
        ActivityFragment.instance());
  }

  @OnClick(R.id.imagebutton_home_profile)
  public void onImagebuttonHomeProfileClicked() {
    profileClicked();
    activityUtil.addFragment(getSupportFragmentManager(), R.id.framelayout_home,
        ProfileFragment.instance());
  }

  @Override
  public void onBackPressed() {
    if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
      getFragmentManager().popBackStack();
      super.onBackPressed();
      greyColor();
      if (getSupportFragmentManager().getBackStackEntryCount() == 1){
        homeClicked();
      }
    } else {

    }
  }

  private void greyColor() {
    imagebuttonHomeHome.setImageResource(R.drawable.ic_home_grey);
    imagebuttonHomeSearch.setImageResource(R.drawable.ic_search_grey);
    imagebuttonHomePost.setImageResource(R.drawable.ic_add_grey);
    imagebuttonHomeActivity.setImageResource(R.drawable.ic_activity_grey);
    imagebuttonHomeProfile.setImageResource(R.drawable.ic_profile_grey);

  }
  private void profileClicked() {
    imagebuttonHomeHome.setImageResource(R.drawable.ic_home_grey);
    imagebuttonHomeSearch.setImageResource(R.drawable.ic_search_grey);
    imagebuttonHomePost.setImageResource(R.drawable.ic_add_grey);
    imagebuttonHomeActivity.setImageResource(R.drawable.ic_activity_grey);
    imagebuttonHomeProfile.setImageResource(R.drawable.ic_profile_black);
  }
  private void activityClicked() {
    imagebuttonHomeHome.setImageResource(R.drawable.ic_home_grey);
    imagebuttonHomeSearch.setImageResource(R.drawable.ic_search_grey);
    imagebuttonHomePost.setImageResource(R.drawable.ic_add_grey);
    imagebuttonHomeActivity.setImageResource(R.drawable.ic_activity_black);
    imagebuttonHomeProfile.setImageResource(R.drawable.ic_profile_grey);
  }
  private void postClicked() {
    imagebuttonHomeHome.setImageResource(R.drawable.ic_home_grey);
    imagebuttonHomeSearch.setImageResource(R.drawable.ic_search_grey);
    imagebuttonHomePost.setImageResource(R.drawable.ic_add_black);
    imagebuttonHomeActivity.setImageResource(R.drawable.ic_activity_grey);
    imagebuttonHomeProfile.setImageResource(R.drawable.ic_profile_grey);
  }
  private void searchClicked() {
    imagebuttonHomeHome.setImageResource(R.drawable.ic_home_grey);
    imagebuttonHomeSearch.setImageResource(R.drawable.ic_search_black);
    imagebuttonHomePost.setImageResource(R.drawable.ic_add_grey);
    imagebuttonHomeActivity.setImageResource(R.drawable.ic_activity_grey);
    imagebuttonHomeProfile.setImageResource(R.drawable.ic_profile_grey);
  }
  private void homeClicked() {
    imagebuttonHomeHome.setImageResource(R.drawable.ic_home_black);
    imagebuttonHomeSearch.setImageResource(R.drawable.ic_search_grey);
    imagebuttonHomePost.setImageResource(R.drawable.ic_add_grey);
    imagebuttonHomeActivity.setImageResource(R.drawable.ic_activity_grey);
    imagebuttonHomeProfile.setImageResource(R.drawable.ic_profile_grey);
  }
}

