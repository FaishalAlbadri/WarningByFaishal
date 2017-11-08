package com.faishalbadri.instagramcoursebyfaishal.repository.register;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/6/17.
 */

public interface RegisterDataResource {

  public interface RegisterGetCallback {

    void onSuccesRegister(String msg);

    void onWrongRegister(String msg);

    void onErrorRegister(String msg);
  }

  void getRegisterResult(String user_name, String user_email, String user_password, String user_verify_code, @NonNull RegisterGetCallback registerGetCallback);

}
