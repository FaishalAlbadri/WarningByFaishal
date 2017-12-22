package com.faishalbadri.instagramcoursebyfaishal.ui.home.fragment.profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.faishalbadri.instagramcoursebyfaishal.R;
import com.faishalbadri.instagramcoursebyfaishal.util.SessionManager;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


  public ProfileFragment() {
    // Required empty public constructor
  }

  public static ProfileFragment instance() {
    return new ProfileFragment();
  }

  SessionManager sessionManager;
  HashMap<String, String> user;
  String id_user, user_name, user_nickname, user_following, user_followers, user_bio,
      user_handphone_number, user_email, user_image, user_password, user_gender, user_account_status;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_profile, container, false);
    sessionManager = new SessionManager(getActivity());
    user = sessionManager.getUserData();
    setString();

    return v;
  }

  private void setString() {
    id_user = user.get(SessionManager.key_id_user);
    user_name = user.get(SessionManager.key_user_name);
    user_nickname = user.get(SessionManager.key_user_nickname);
    user_following = user.get(SessionManager.key_user_following);
    user_followers = user.get(SessionManager.key_user_followers);
    user_bio = user.get(SessionManager.key_user_bio);
    user_handphone_number = user.get(SessionManager.key_user_handphone);
    user_email = user.get(SessionManager.key_user_email);
    user_image = user.get(SessionManager.key_user_image);
    user_password = user.get(SessionManager.key_user_password);
    user_gender = user.get(SessionManager.key_user_gender);
    user_account_status = user.get(SessionManager.key_user_status);
  }

}