package com.faishalbadri.instagramcoursebyfaishal.ui.verify_email;

import com.faishalbadri.instagramcoursebyfaishal.repository.verify_code.VerifyCodeDataResource.VerifyCodeGetCallback;
import com.faishalbadri.instagramcoursebyfaishal.repository.verify_code.VerifyCodeRepository;
import com.faishalbadri.instagramcoursebyfaishal.ui.verify_email.VerifyCodeContract.verifyCodeView;

/**
 * Created by faishal on 11/8/17.
 */

public class VerifyCodePresenter implements VerifyCodeContract.verifyCodePresenter {

  VerifyCodeContract.verifyCodeView verifyCodeView;
  VerifyCodeRepository verifyCodeRepository;

  public VerifyCodePresenter(
      VerifyCodeRepository verifyCodeRepository) {
    this.verifyCodeRepository = verifyCodeRepository;
  }

  @Override
  public void onAttachView(verifyCodeView view) {
    this.verifyCodeView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataVerifyCode(String id_user, String user_verified_code) {
    verifyCodeRepository.getVerifyCodeResult(id_user, user_verified_code,
        new VerifyCodeGetCallback() {
          @Override
          public void onSuccesVerifyCode(String msg) {
            verifyCodeView.onSuccesVerifyCode(msg);
          }

          @Override
          public void onErrorVerifyCode(String msg) {
            verifyCodeView.onErrorVerifyCode(msg);
          }
        });
  }
}
