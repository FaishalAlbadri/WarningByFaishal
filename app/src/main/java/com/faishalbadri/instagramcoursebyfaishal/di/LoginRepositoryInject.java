package com.faishalbadri.instagramcoursebyfaishal.di;

import android.content.Context;
import com.faishalbadri.instagramcoursebyfaishal.repository.login.LoginRepository;
import com.faishalbadri.instagramcoursebyfaishal.repository.login.remote.LoginDataRemote;

/**
 * Created by faishal on 11/6/17.
 */

public class LoginRepositoryInject {
  public static LoginRepository provideToLoginRepository(Context context){
    return new LoginRepository(new LoginDataRemote(context));
  }
}
