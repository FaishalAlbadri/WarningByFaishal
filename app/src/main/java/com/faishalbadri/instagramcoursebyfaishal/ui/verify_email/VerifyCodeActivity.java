package com.faishalbadri.instagramcoursebyfaishal.ui.verify_email;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.faishalbadri.instagramcoursebyfaishal.R;

public class VerifyCodeActivity extends AppCompatActivity {

  String code;
  @BindView(R.id.edittext_verify_code)
  PinEntryEditText edittextVerifyCode;
  @BindView(R.id.button_next_verify_code)
  Button buttonNextVerifyCode;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_verify_code);
    ButterKnife.bind(this);
    code = getIntent().getStringExtra("code");
    if (edittextVerifyCode.getText().toString().equals(code)){
      Toast.makeText(this, "Succes", Toast.LENGTH_SHORT).show();
    } else {
      Toast.makeText(this, "Pin salah", Toast.LENGTH_SHORT).show();
    }
  }
}
