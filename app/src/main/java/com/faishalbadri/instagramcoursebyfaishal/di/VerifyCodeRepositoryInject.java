package com.faishalbadri.instagramcoursebyfaishal.di;

import android.content.Context;
import com.faishalbadri.instagramcoursebyfaishal.repository.verify_code.VerifyCodeRepository;
import com.faishalbadri.instagramcoursebyfaishal.repository.verify_code.remote.VerifyCodeDataRemote;

/**
 * Created by faishal on 11/8/17.
 */

public class VerifyCodeRepositoryInject {
  public static VerifyCodeRepository provideToVerifyCodeRepository(Context context){
    return new VerifyCodeRepository(new VerifyCodeDataRemote(context));
  }
}
