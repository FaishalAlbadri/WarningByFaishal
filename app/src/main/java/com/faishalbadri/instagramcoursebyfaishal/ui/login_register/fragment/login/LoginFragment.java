package com.faishalbadri.instagramcoursebyfaishal.ui.login_register.fragment.login;


import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.faishalbadri.instagramcoursebyfaishal.R;
import com.faishalbadri.instagramcoursebyfaishal.di.LoginRepositoryInject;
import com.faishalbadri.instagramcoursebyfaishal.ui.home.activity.HomeActivity;
import com.faishalbadri.instagramcoursebyfaishal.ui.verify_email.VerifyCodeActivity;
import com.faishalbadri.instagramcoursebyfaishal.util.Server;
import com.faishalbadri.instagramcoursebyfaishal.util.SessionManager;
import com.rengwuxian.materialedittext.MaterialEditText;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginFragment extends Fragment implements LoginContract.loginView {


  @BindView(R.id.materialedittext_email_fragment_login)
  MaterialEditText materialedittextEmailFragmentLogin;
  @BindView(R.id.materialedittext_password_fragment_login)
  MaterialEditText materialedittextPasswordFragmentLogin;
  @BindView(R.id.button_login_fragment_login)
  Button buttonLoginFragmentLogin;
  LoginPresenter loginPresenter;
  String user_name, user_password;
  SessionManager sessionManagerLogin;
  ProgressDialog pd;

  public LoginFragment() {

  }

  public static LoginFragment instance() {
    return new LoginFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_login, container, false);
    ButterKnife.bind(this, view);
    sessionManagerLogin = new SessionManager(getActivity());
    pd = new ProgressDialog(getActivity());
    pd.setMessage("Loading");
    pd.setCancelable(false);
    pd.setCanceledOnTouchOutside(false);
    loginPresenter = new LoginPresenter(LoginRepositoryInject.provideToLoginRepository(getActivity()));
    loginPresenter.onAttachView(this);
    if (VERSION.SDK_INT >= VERSION_CODES.M) {
      buttonLoginFragmentLogin.setForeground(getSelectedItemDrawable());
    }
    buttonLoginFragmentLogin.setClickable(true);
    buttonLoginFragmentLogin.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        loginOnClick();
      }
    });

    return view;
  }

  private void loginOnClick() {
    materialedittextEmailFragmentLogin.setError(null);
    materialedittextPasswordFragmentLogin.setError(null);
    if (Server.isEmpty(materialedittextEmailFragmentLogin) && Server
        .isEmpty(materialedittextPasswordFragmentLogin)) {
      materialedittextEmailFragmentLogin.setError("Email tidak boleh kosong");
      materialedittextPasswordFragmentLogin.setError("Password tidak boleh kosong");
      materialedittextEmailFragmentLogin.requestFocus();
      materialedittextPasswordFragmentLogin.requestFocus();
    } else if (Server.isEmpty(materialedittextEmailFragmentLogin)) {
      materialedittextEmailFragmentLogin.setError("Email tidak boleh kosong");
      materialedittextEmailFragmentLogin.requestFocus();
    } else if (Server.isEmpty(materialedittextPasswordFragmentLogin)) {
      materialedittextPasswordFragmentLogin.setError("Password tidak boleh kosong");
      materialedittextPasswordFragmentLogin.requestFocus();
    } else {
      pd.show();
      user_name = materialedittextEmailFragmentLogin.getText().toString();
      user_password = convertPassMd5(materialedittextPasswordFragmentLogin.getText().toString());
      loginPresenter.getDataLogin(user_name, user_password);
    }
  }


  @Override
  public void onSuccesLogin(String msg, String id_user, String user_name, String user_nickname,
      String user_following, String user_followers, String user_bio, String user_handphone_number,
      String user_email, String user_image, String user_password, String user_verify_code,
      String user_verified_code,
      String user_gender, String user_account_status) {
    pd.dismiss();
    sessionManagerLogin
        .createSessionAll(id_user, user_name, user_nickname, user_following, user_followers,
            user_bio, user_handphone_number, user_email, user_image, user_password,
            user_verify_code, user_verified_code, user_gender, user_account_status);

    if (user_verified_code == null) {
      startActivity(new Intent(getActivity(), VerifyCodeActivity.class));
      getActivity().finish();
    } else if (user_verified_code.equals(user_verify_code)) {
      startActivity(new Intent(getActivity(), HomeActivity.class));
      getActivity().finish();
    }
  }

  @Override
  public void onWrongLogin(String msg) {
    pd.dismiss();
  }

  @Override
  public void onErrorLogin(String msg) {
    pd.dismiss();
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }

  public Drawable getSelectedItemDrawable() {
    int[] attrs = new int[]{R.attr.selectableItemBackground};
    TypedArray ta = getActivity().obtainStyledAttributes(attrs);
    Drawable selectedItemDrawable = ta.getDrawable(0);
    ta.recycle();
    return selectedItemDrawable;
  }

  public static String convertPassMd5(String pass) {
    String password = null;
    MessageDigest mdEnc;
    try {
      mdEnc = MessageDigest.getInstance("MD5");
      mdEnc.update(pass.getBytes(), 0, pass.length());
      pass = new BigInteger(1, mdEnc.digest()).toString(16);
      while (pass.length() < 32) {
        pass = "0" + pass;
      }
      password = pass;
    } catch (NoSuchAlgorithmException e1) {
      e1.printStackTrace();
    }
    return password;
  }

}
