package com.faishalbadri.instagramcoursebyfaishal.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.faishalbadri.instagramcoursebyfaishal.R;
import com.faishalbadri.instagramcoursebyfaishal.util.SessionManager;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

  SessionManager sessionManager;
  @BindView(R.id.text)
  TextView text;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);

    sessionManager = new SessionManager(HomeActivity.this);

  }

  @OnClick(R.id.text)
  public void onViewClicked() {
    sessionManager.logout();
  }

  @Override
  public void onBackPressed() {

  }
}
