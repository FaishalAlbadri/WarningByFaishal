package com.faishalbadri.instagramcoursebyfaishal.ui.login_register.fragment.register;

import com.faishalbadri.instagramcoursebyfaishal.repository.register.RegisterDataResource.RegisterGetCallback;
import com.faishalbadri.instagramcoursebyfaishal.repository.register.RegisterRepository;
import com.faishalbadri.instagramcoursebyfaishal.ui.login_register.fragment.register.RegisterContract.registerView;

/**
 * Created by faishal on 11/6/17.
 */

public class RegisterPresenter implements RegisterContract.registerPresenter {

  RegisterContract.registerView registerView;
  RegisterRepository registerRepository;

  public RegisterPresenter(
      RegisterRepository registerRepository) {
    this.registerRepository = registerRepository;
  }

  @Override
  public void onAttachView(registerView view) {
    this.registerView = view;
  }

  @Override
  public void onDettachView() {

  }

  @Override
  public void getDataRegister(String user_name, String user_email, String user_password,
      String user_verify_code) {
    registerRepository.getRegisterResult(user_name, user_email, user_password, user_verify_code,
        new RegisterGetCallback() {
          @Override
          public void onSuccesRegister(String msg) {
            registerView.onSuccesRegister(msg);
          }

          @Override
          public void onWrongRegister(String msg) {
            registerView.onWrongRegister(msg);
          }

          @Override
          public void onErrorRegister(String msg) {
            registerView.onErrorRegister(msg);
          }
        });
  }
}
