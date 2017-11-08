package com.faishalbadri.instagramcoursebyfaishal.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.faishalbadri.instagramcoursebyfaishal.R;
import com.faishalbadri.instagramcoursebyfaishal.ui.login_register.activity.LoginRegisterActivity;

public class SplashScreenActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,
        LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_splash_screen);
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
      @Override
      public void run() {
        startActivity(new Intent(getApplicationContext(), LoginRegisterActivity.class));
        finish();
      }
    }, 1000);


  }
}
