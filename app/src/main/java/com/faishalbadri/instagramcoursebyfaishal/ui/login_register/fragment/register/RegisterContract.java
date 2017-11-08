package com.faishalbadri.instagramcoursebyfaishal.ui.login_register.fragment.register;

import com.faishalbadri.instagramcoursebyfaishal.base.BasePresenter;

/**
 * Created by faishal on 11/6/17.
 */

public class RegisterContract {

  public interface registerView {

    void onSuccesRegister(String msg);

    void onWrongRegister(String msg);

    void onErrorRegister(String msg);
  }

  public interface registerPresenter extends BasePresenter<registerView> {

    void getDataRegister(String user_name, String user_email, String user_password, String user_verify_code);
  }

}
