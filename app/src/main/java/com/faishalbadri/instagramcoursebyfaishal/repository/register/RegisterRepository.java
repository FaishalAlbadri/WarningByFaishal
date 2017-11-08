package com.faishalbadri.instagramcoursebyfaishal.repository.register;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/6/17.
 */

public class RegisterRepository implements RegisterDataResource {

  RegisterDataResource registerDataResource;

  public RegisterRepository(
      RegisterDataResource registerDataResource) {
    this.registerDataResource = registerDataResource;
  }

  @Override
  public void getRegisterResult(String user_name, String user_email, String user_password,
      String user_verify_code, @NonNull RegisterGetCallback registerGetCallback) {
    registerDataResource.getRegisterResult(user_name, user_email, user_password, user_verify_code, registerGetCallback);
  }
}
