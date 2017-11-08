package com.faishalbadri.instagramcoursebyfaishal.di;

import android.content.Context;
import com.faishalbadri.instagramcoursebyfaishal.repository.register.RegisterRepository;
import com.faishalbadri.instagramcoursebyfaishal.repository.register.remote.RegisterDataRemote;

/**
 * Created by faishal on 11/6/17.
 */

public class RegisterRepositoryInject {
  public static RegisterRepository provideToRegisterRepository(Context context){
    return new RegisterRepository(new RegisterDataRemote(context));
  }
}