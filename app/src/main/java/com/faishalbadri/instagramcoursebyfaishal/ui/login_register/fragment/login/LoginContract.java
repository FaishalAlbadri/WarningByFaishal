package com.faishalbadri.instagramcoursebyfaishal.ui.login_register.fragment.login;

import com.faishalbadri.instagramcoursebyfaishal.base.BasePresenter;

/**
 * Created by faishal on 11/6/17.
 */

public class LoginContract {

  public interface loginView {

    void onSuccesLogin(String msg, String id_user, String user_name, String user_nickname,
        String user_following, String user_followers, String user_bio, String user_handphone_number,
        String user_email, String user_image, String user_password, String user_verify_code, String user_verified_code,
        String user_gender, String user_account_status);

    void onWrongLogin(String msg);

    void onErrorLogin(String msg);
  }

  public interface loginPresenter extends BasePresenter<loginView> {

    void getDataLogin(String user_name, String user_password);
  }

}
