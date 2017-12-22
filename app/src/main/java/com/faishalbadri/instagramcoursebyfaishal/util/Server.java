package com.faishalbadri.instagramcoursebyfaishal.util;

import com.rengwuxian.materialedittext.MaterialEditText;


public class Server {

  public final static String BASE_URL = "http://api.santriprogrammer.com/instaindo/library/";
  public final static String BASE_IMG_USER_PROFILE = "http://api.santriprogrammer.com/instaindo/image_user_profile/";
  public final static String BASE_IMG_USER_POST = "http://api.santriprogrammer.com/instaindo/image_user_post/";

  public static final String EMAIL = "instagramofficialcourse@gmail.com";
  public static final String PASSWORD = "instaindo";

  public static final String PASSWORD_MARK_ZUCKERBERG ="asdasda";

  public static boolean isEmpty(MaterialEditText materialEditText) {

    if (materialEditText.getText().toString().trim().length() > 0) {

      return false;
    } else {

      return true;
    }
  }
}