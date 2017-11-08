package com.faishalbadri.instagramcoursebyfaishal.ui.verify_email;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.faishalbadri.instagramcoursebyfaishal.R;
import com.faishalbadri.instagramcoursebyfaishal.di.VerifyCodeRepositoryInject;
import com.faishalbadri.instagramcoursebyfaishal.ui.home.HomeActivity;
import com.faishalbadri.instagramcoursebyfaishal.ui.login_register.activity.LoginRegisterActivity;
import com.faishalbadri.instagramcoursebyfaishal.util.SessionManager;
import java.util.HashMap;

public class VerifyCodeActivity extends AppCompatActivity implements
    VerifyCodeContract.verifyCodeView {

  SessionManager sessionManager;
  String verifiedcode, code, id;
  VerifyCodePresenter verifyCodePresenter;
  @BindView(R.id.edittext_verify_code)
  PinEntryEditText edittextVerifyCode;
  @BindView(R.id.button_next_verify_code)
  Button buttonNextVerifyCode;
  ProgressDialog pd;
  HashMap<String, String> user;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verify_code);
    ButterKnife.bind(this);
    sessionManager = new SessionManager(VerifyCodeActivity.this);
    user = sessionManager.getUserData();
    code = user.get(SessionManager.key_user_verify_code);
    verifiedcode = user.get(SessionManager.key_user_verified_code);
    id = user.get(SessionManager.key_id_user);

    Toast.makeText(this, id, Toast.LENGTH_SHORT).show();

    if (id != null && verifiedcode != null){
      startActivity(new Intent(getApplicationContext(), HomeActivity.class));
      finish();
    }

    pd = new ProgressDialog(this);
    pd.setMessage("Loading");
    pd.setCancelable(false);
    pd.setCanceledOnTouchOutside(false);
    verifyCodePresenter = new VerifyCodePresenter(VerifyCodeRepositoryInject.provideToVerifyCodeRepository(getApplicationContext()));
    verifyCodePresenter.onAttachView(this);
    buttonNextVerifyCode.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        pd.show();
        btnClick();
      }
    });
  }

  private void btnClick() {
    if (edittextVerifyCode.getText().toString().equals(code)) {
      verifyCodePresenter.getDataVerifyCode(id, code);
    } else {
      Toast.makeText(VerifyCodeActivity.this, "Pin salah", Toast.LENGTH_SHORT).show();
      pd.dismiss();
    }
  }

  @Override
  public void onBackPressed() {
    sessionManager.logout();
    startActivity(new Intent(getApplicationContext(), LoginRegisterActivity.class));
    finish();
  }

  @Override
  public void onSuccesVerifyCode(String msg) {
    pd.dismiss();
    sessionManager.editVerifiedCode(code);
  }

  @Override
  public void onErrorVerifyCode(String msg) {
    pd.dismiss();
    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
  }

}
