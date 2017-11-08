package com.faishalbadri.instagramcoursebyfaishal.repository.login;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/6/17.
 */

public class LoginRepository implements LoginDataResource {

  private LoginDataResource loginDataResource;

  public LoginRepository(LoginDataResource loginDataResource) {
    this.loginDataResource = loginDataResource;
  }



  @Override
  public void getLoginResult(String user_name, String user_password, @NonNull LoginGetCallback loginGetCallback) {
    loginDataResource.getLoginResult(user_name, user_password, loginGetCallback);
  }
}

