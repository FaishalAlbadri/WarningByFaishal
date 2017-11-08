package com.faishalbadri.instagramcoursebyfaishal.ui.login_register.fragment.login;

import com.faishalbadri.instagramcoursebyfaishal.repository.login.LoginDataResource.LoginGetCallback;
import com.faishalbadri.instagramcoursebyfaishal.repository.login.LoginRepository;

/**
 * Created by faishal on 11/6/17.
 */

public class LoginPresenter implements LoginContract.loginPresenter {

  LoginContract.loginView loginView;
  LoginRepository loginRepository;

  public LoginPresenter(LoginRepository loginRepository) {
    this.loginRepository = loginRepository;
  }

  @Override
  public void onAttachView(LoginContract.loginView view) {
    this.loginView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataLogin(String user_name, String user_password) {
    loginRepository.getLoginResult(user_name, user_password, new LoginGetCallback() {
      @Override
      public void onSuccesLogin(String msg, String id_user, String user_name, String user_nickname,
          String user_following, String user_followers, String user_bio,
          String user_handphone_number,
          String user_email, String user_image, String user_password, String user_verify_code,
          String user_verified_code,
          String user_gender, String user_account_status) {
        loginView
            .onSuccesLogin(msg, id_user, user_name, user_nickname, user_following, user_followers,
                user_bio, user_handphone_number, user_email, user_image, user_password,
                user_verify_code, user_verified_code, user_gender, user_account_status);
      }

      @Override
      public void onWrongLogin(String msg) {
        loginView.onWrongLogin(msg);
      }

      @Override
      public void onErrorLogin(String msg) {
        loginView.onErrorLogin(msg);
      }
    });
  }
}
