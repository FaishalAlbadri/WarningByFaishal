package com.faishalbadri.instagramcoursebyfaishal.repository.verify_code;

import android.support.annotation.NonNull;
import com.faishalbadri.instagramcoursebyfaishal.repository.login.LoginDataResource.LoginGetCallback;

/**
 * Created by faishal on 11/8/17.
 */

public interface VerifyCodeDataResource {

  interface VerifyCodeGetCallback {

    void onSuccesVerifyCode(String msg);

    void onErrorVerifyCode(String msg);

  }

  void getVerifyCodeResult(String id_user, String user_verified_code,
      @NonNull VerifyCodeGetCallback verifyCodeGetCallback);

}
