package com.faishalbadri.instagramcoursebyfaishal.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.faishalbadri.instagramcoursebyfaishal.R;
import com.faishalbadri.instagramcoursebyfaishal.di.LoginRepositoryInject;
import com.faishalbadri.instagramcoursebyfaishal.ui.login_register.activity.LoginRegisterActivity;
import com.faishalbadri.instagramcoursebyfaishal.ui.login_register.fragment.login.LoginContract;
import com.faishalbadri.instagramcoursebyfaishal.ui.login_register.fragment.login.LoginPresenter;
import com.faishalbadri.instagramcoursebyfaishal.util.SessionManager;
import java.util.HashMap;

public class SplashScreenActivity extends AppCompatActivity implements LoginContract.loginView {

  SessionManager sessionManager;
  HashMap<String, String> user;
  String user_name, user_password;
  LoginPresenter loginPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,
        LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_splash_screen);
    sessionManager = new SessionManager(SplashScreenActivity.this);
    user = sessionManager.getUserData();
    user_name = user.get(SessionManager.key_user_name);
    user_password = user.get(SessionManager.key_user_password);

    loginPresenter = new LoginPresenter(LoginRepositoryInject.provideToLoginRepository(getApplicationContext()));
    loginPresenter.onAttachView(this);

    if (user_name != null && user_password !=null){
      loginPresenter.getDataLogin(user_name,user_password);
    }

    sessionManager.checkLogin();
    finish();
  }

  @Override
  public void onBackPressed() {

  }

  @Override
  public void onSuccesLogin(String msg, String id_user, String user_name, String user_nickname,
      String user_following, String user_followers, String user_bio, String user_handphone_number,
      String user_email, String user_image, String user_password, String user_verify_code,
      String user_verified_code, String user_gender, String user_account_status) {
   sessionManager.createSessionAll(id_user, user_name, user_nickname, user_following, user_followers, user_bio, user_handphone_number, user_email, user_image, user_password, user_verify_code, user_verified_code, user_gender, user_account_status);
  }

  @Override
  public void onWrongLogin(String msg) {

  }

  @Override
  public void onErrorLogin(String msg) {

  }
}
