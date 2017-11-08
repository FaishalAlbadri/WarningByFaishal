package com.faishalbadri.instagramcoursebyfaishal.data;

import java.util.List;

/**
 * Created by faishal on 11/6/17.
 */

public class PojoUser {

  /**
   * user : [{"id_user":"2","user_name":"faishal","user_nickname":"FAnonymous","user_following":"0","user_followers":"0","user_bio":"ape lo liat liat gw...","user_handphone_number":"085857803720","user_email":"faishalihbs7c@gmail.com","user_image":"myFace.jpg","user_password":"2b96704682681c327f8cc134b1537639","user_verify_code":"123456","user_verified_code":"123456","user_gender":"Male","user_account_status":"Private"}]
   * result : true
   * msg : Berhasil
   */

  private boolean result;
  private String msg;
  private List<UserBean> user;

  public boolean isResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<UserBean> getUser() {
    return user;
  }

  public void setUser(List<UserBean> user) {
    this.user = user;
  }

  public static class UserBean {

    /**
     * id_user : 2
     * user_name : faishal
     * user_nickname : FAnonymous
     * user_following : 0
     * user_followers : 0
     * user_bio : ape lo liat liat gw...
     * user_handphone_number : 085857803720
     * user_email : faishalihbs7c@gmail.com
     * user_image : myFace.jpg
     * user_password : 2b96704682681c327f8cc134b1537639
     * user_verify_code : 123456
     * user_verified_code : 123456
     * user_gender : Male
     * user_account_status : Private
     */

    private String id_user;
    private String user_name;
    private String user_nickname;
    private String user_following;
    private String user_followers;
    private String user_bio;
    private String user_handphone_number;
    private String user_email;
    private String user_image;
    private String user_password;
    private String user_verify_code;
    private String user_verified_code;
    private String user_gender;
    private String user_account_status;

    public String getId_user() {
      return id_user;
    }

    public void setId_user(String id_user) {
      this.id_user = id_user;
    }

    public String getUser_name() {
      return user_name;
    }

    public void setUser_name(String user_name) {
      this.user_name = user_name;
    }

    public String getUser_nickname() {
      return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
      this.user_nickname = user_nickname;
    }

    public String getUser_following() {
      return user_following;
    }

    public void setUser_following(String user_following) {
      this.user_following = user_following;
    }

    public String getUser_followers() {
      return user_followers;
    }

    public void setUser_followers(String user_followers) {
      this.user_followers = user_followers;
    }

    public String getUser_bio() {
      return user_bio;
    }

    public void setUser_bio(String user_bio) {
      this.user_bio = user_bio;
    }

    public String getUser_handphone_number() {
      return user_handphone_number;
    }

    public void setUser_handphone_number(String user_handphone_number) {
      this.user_handphone_number = user_handphone_number;
    }

    public String getUser_email() {
      return user_email;
    }

    public void setUser_email(String user_email) {
      this.user_email = user_email;
    }

    public String getUser_image() {
      return user_image;
    }

    public void setUser_image(String user_image) {
      this.user_image = user_image;
    }

    public String getUser_password() {
      return user_password;
    }

    public void setUser_password(String user_password) {
      this.user_password = user_password;
    }

    public String getUser_verify_code() {
      return user_verify_code;
    }

    public void setUser_verify_code(String user_verify_code) {
      this.user_verify_code = user_verify_code;
    }

    public String getUser_verified_code() {
      return user_verified_code;
    }

    public void setUser_verified_code(String user_verified_code) {
      this.user_verified_code = user_verified_code;
    }

    public String getUser_gender() {
      return user_gender;
    }

    public void setUser_gender(String user_gender) {
      this.user_gender = user_gender;
    }

    public String getUser_account_status() {
      return user_account_status;
    }

    public void setUser_account_status(String user_account_status) {
      this.user_account_status = user_account_status;
    }
  }
}
