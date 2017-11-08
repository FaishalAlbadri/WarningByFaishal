package com.faishalbadri.instagramcoursebyfaishal.repository.login;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/6/17.
 */

public interface LoginDataResource {

  public interface LoginGetCallback {

    void onSuccesLogin(String msg, String id_user, String user_name, String user_nickname,
        String user_following, String user_followers, String user_bio, String user_handphone_number,
        String user_email, String user_image, String user_password, String user_verify_code, String user_verified_code,
        String user_gender, String user_account_status);

    void onWrongLogin(String msg);

    void onErrorLogin(String msg);

  }

  void getLoginResult(String user_name, String user_password, @NonNull LoginGetCallback loginGetCallback);

}
