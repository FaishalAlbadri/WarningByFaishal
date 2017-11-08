package com.faishalbadri.instagramcoursebyfaishal.repository.verify_code;

import android.support.annotation.NonNull;

/**
 * Created by faishal on 11/8/17.
 */

public class VerifyCodeRepository implements VerifyCodeDataResource {

  VerifyCodeDataResource verifyCodeDataResource;

  public VerifyCodeRepository(
      VerifyCodeDataResource verifyCodeDataResource) {
    this.verifyCodeDataResource = verifyCodeDataResource;
  }

  @Override
  public void getVerifyCodeResult(String id_user, String user_verified_code,
      @NonNull VerifyCodeGetCallback verifyCodeGetCallback) {
    verifyCodeDataResource.getVerifyCodeResult(id_user, user_verified_code, verifyCodeGetCallback);
  }
}
