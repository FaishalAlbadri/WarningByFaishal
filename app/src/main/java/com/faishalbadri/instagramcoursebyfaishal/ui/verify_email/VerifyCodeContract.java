package com.faishalbadri.instagramcoursebyfaishal.ui.verify_email;

import com.faishalbadri.instagramcoursebyfaishal.base.BasePresenter;

/**
 * Created by faishal on 11/8/17.
 */

public class VerifyCodeContract {

  public interface verifyCodeView {

    void onSuccesVerifyCode(String msg);

    void onErrorVerifyCode(String msg);
  }

  public interface verifyCodePresenter extends BasePresenter<verifyCodeView> {

    void getDataVerifyCode(String id_user, String user_verified_code);
  }

}
