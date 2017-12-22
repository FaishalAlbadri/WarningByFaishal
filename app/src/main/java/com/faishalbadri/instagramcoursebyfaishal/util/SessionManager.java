package com.faishalbadri.instagramcoursebyfaishal.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.faishalbadri.instagramcoursebyfaishal.ui.home.activity.HomeActivity;
import com.faishalbadri.instagramcoursebyfaishal.ui.login_register.activity.LoginRegisterActivity;
import com.faishalbadri.instagramcoursebyfaishal.ui.verify_email.VerifyCodeActivity;
import java.util.HashMap;


public class SessionManager {

  SharedPreferences instaPref, instaPrefCode, instaPrefPassword, instaPrefFollowing, instaPrefFollowers;
  SharedPreferences.Editor editorIdUser, editorUserName, editorUserNickName, editorUserFollowing, editorUserFollowers, editorUserBio, editorHandphone, editorEmail, editorImage, editorPassword, editorUserVerifyCode, editorUserVerifiedCode, editorUserGender, editorUserStatus;
  Context context;
  int mode = 0;

  private static final String pref_name = "insta_indo_pref";
  private static final String pref_name_code = "code";
  private static final String pref_name_password = "password";
  private static final String pref_name_following = "following";
  private static final String pref_name_followers = "followers";
  private static final String is_login = "islogin";
  public static final String key_id_user = "keyidUser";
  public static final String key_user_name = "keyUserName";
  public static final String key_user_nickname = "keyUserNickname";
  public static final String key_user_following = "keyUserFollowing";
  public static final String key_user_followers = "keyUserFollowers";
  public static final String key_user_bio = "keyUserBio";
  public static final String key_user_handphone = "keyUserHandphone";
  public static final String key_user_email = "keyUserEmail";
  public static final String key_user_image = "keyUserImage";
  public static final String key_user_password = "keyUserPassword";
  public static final String key_user_verify_code = "keyUserVerifyCode";
  public static final String key_user_verified_code = "keyUserVerifiedCode";
  public static final String key_user_gender = "keyUserGender";
  public static final String key_user_status = "keyUserStatus";

  public SessionManager(Context context) {
    this.context = context;
    instaPref = context.getSharedPreferences(pref_name, mode);
    instaPrefCode = context.getSharedPreferences(pref_name_code, mode);
    instaPrefPassword = context.getSharedPreferences(pref_name_password, mode);
    instaPrefFollowers = context.getSharedPreferences(pref_name_followers, mode);
    instaPrefFollowing = context.getSharedPreferences(pref_name_following, mode);
    editorIdUser = instaPref.edit();
    editorUserName = instaPref.edit();
    editorUserNickName = instaPref.edit();
    editorUserFollowing = instaPrefFollowing.edit();
    editorUserFollowers = instaPrefFollowers.edit();
    editorUserBio = instaPref.edit();
    editorHandphone = instaPref.edit();
    editorEmail = instaPref.edit();
    editorImage = instaPref.edit();
    editorPassword = instaPrefPassword.edit();
    editorUserVerifyCode = instaPref.edit();
    editorUserVerifiedCode = instaPrefCode.edit();
    editorUserGender = instaPref.edit();
    editorUserStatus = instaPref.edit();
  }

  public void createSessionAll(String id_user, String user_name, String user_nickname,
      String user_following, String user_followers, String user_bio, String user_handphone_number,
      String user_email, String user_image, String user_password, String user_verify_code,
      String user_verified_code,
      String user_gender, String user_account_status) {

    editorIdUser.putBoolean(is_login, true);
    editorIdUser.putString(key_id_user, id_user);
    editorUserName.putString(key_user_name, user_name);
    editorUserNickName.putString(key_user_nickname, user_nickname);
    editorUserFollowing.putString(key_user_following, user_following);
    editorUserFollowers.putString(key_user_followers, user_followers);
    editorUserBio.putString(key_user_bio, user_bio);
    editorHandphone.putString(key_user_handphone, user_handphone_number);
    editorEmail.putString(key_user_email, user_email);
    editorImage.putString(key_user_image, user_image);
    editorPassword.putString(key_user_password, user_password);
    editorUserVerifyCode.putString(key_user_verify_code, user_verify_code);
    editorUserVerifiedCode.putString(key_user_verified_code, user_verified_code);
    editorUserGender.putString(key_user_gender, user_gender);
    editorUserStatus.putString(key_user_status, user_account_status);

    editorIdUser.commit();
    editorUserName.commit();
    editorUserNickName.commit();
    editorUserFollowing.commit();
    editorUserFollowers.commit();
    editorUserBio.commit();
    editorHandphone.commit();
    editorEmail.commit();
    editorImage.commit();
    editorPassword.commit();
    editorUserVerifyCode.commit();
    editorUserVerifiedCode.commit();
    editorUserGender.commit();
    editorUserStatus.commit();
  }


  public void checkLogin() {
    if (!this.is_login()) {
      context.startActivity(new Intent(context, LoginRegisterActivity.class)
          .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
      ((Activity) context).finish();
    } else {
      context.startActivity(new Intent(context, VerifyCodeActivity.class)
          .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
      ((Activity) context).finish();
    }
  }

  private boolean is_login() {
    return instaPref.getBoolean(is_login, false);
  }

  public void editProfile(String user_name, String user_nickname, String user_bio,
      String user_handphone_number, String user_email, String user_image, String user_gender,
      String user_account_status) {
    editorUserName.clear();
    editorUserNickName.clear();
    editorUserBio.clear();
    editorHandphone.clear();
    editorEmail.clear();
    editorImage.clear();
    editorUserGender.clear();
    editorUserStatus.clear();
    editorUserName.putString(key_user_name, user_name);
    editorUserNickName.putString(key_user_nickname, user_nickname);
    editorUserBio.putString(key_user_bio, user_bio);
    editorHandphone.putString(key_user_handphone, user_handphone_number);
    editorEmail.putString(key_user_email, user_email);
    editorImage.putString(key_user_image, user_image);
    editorUserGender.putString(key_user_gender, user_gender);
    editorUserStatus.putString(key_user_status, user_account_status);
    editorUserName.commit();
    editorUserNickName.commit();
    editorUserBio.commit();
    editorHandphone.commit();
    editorEmail.commit();
    editorImage.commit();
    editorUserGender.commit();
    editorUserStatus.commit();
  }

  public void editPassword(String user_password) {
    editorPassword.clear();
    editorPassword.putString(key_user_password, user_password);
    editorPassword.commit();
  }

  public void editFollowing(String user_following) {
    editorUserFollowing.clear();
    editorUserFollowing.putString(key_user_following, user_following);
    editorUserFollowing.commit();
  }

  public void editFollowers(String user_followers) {
    editorUserFollowers.clear();
    editorUserFollowers.putString(key_user_followers, user_followers);
    editorUserFollowers.commit();
  }

  public void editVerifiedCode(String user_verified_code) {
    editorUserVerifiedCode.clear();
    editorUserVerifiedCode.putString(key_user_verified_code, user_verified_code);
    editorUserVerifiedCode.commit();
    context.startActivity(new Intent(context, HomeActivity.class)
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
    ((Activity) context).finish();
  }

  public void logout() {
    editorIdUser.clear();
    editorUserName.clear();
    editorUserNickName.clear();
    editorUserFollowing.clear();
    editorUserFollowers.clear();
    editorUserBio.clear();
    editorHandphone.clear();
    editorEmail.clear();
    editorImage.clear();
    editorPassword.clear();
    editorUserVerifyCode.clear();
    editorUserVerifiedCode.clear();
    editorUserGender.clear();
    editorUserStatus.clear();

    editorIdUser.commit();
    editorUserName.commit();
    editorUserNickName.commit();
    editorUserFollowing.commit();
    editorUserFollowers.commit();
    editorUserBio.commit();
    editorHandphone.commit();
    editorEmail.commit();
    editorImage.commit();
    editorPassword.commit();
    editorUserVerifyCode.commit();
    editorUserVerifiedCode.commit();
    editorUserGender.commit();
    editorUserStatus.commit();

    context.startActivity(new Intent(context, LoginRegisterActivity.class)
        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
    ((Activity) context).finish();
  }

  public HashMap<String, String> getUserData() {
    HashMap<String, String> user = new HashMap<>();
    user.put(key_id_user, instaPref.getString(key_id_user, null));
    user.put(key_user_name, instaPref.getString(key_user_name, null));
    user.put(key_user_nickname, instaPref.getString(key_user_nickname, null));
    user.put(key_user_following, instaPrefFollowing.getString(key_user_following, null));
    user.put(key_user_followers, instaPrefFollowers.getString(key_user_followers, null));
    user.put(key_user_bio, instaPref.getString(key_user_bio, null));
    user.put(key_user_handphone, instaPref.getString(key_user_handphone, null));
    user.put(key_user_email, instaPref.getString(key_user_email, null));
    user.put(key_user_image, instaPref.getString(key_user_image, null));
    user.put(key_user_password, instaPrefPassword.getString(key_user_password, null));
    user.put(key_user_verify_code, instaPref.getString(key_user_verify_code, null));
    user.put(key_user_verified_code, instaPrefCode.getString(key_user_verified_code, null));
    user.put(key_user_gender, instaPref.getString(key_user_gender, null));
    user.put(key_user_status, instaPref.getString(key_user_status, null));
    return user;
  }

}
