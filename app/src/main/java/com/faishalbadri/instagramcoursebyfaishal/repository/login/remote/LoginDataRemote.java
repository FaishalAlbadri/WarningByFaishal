package com.faishalbadri.instagramcoursebyfaishal.repository.login.remote;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.faishalbadri.instagramcoursebyfaishal.data.PojoUser;
import com.faishalbadri.instagramcoursebyfaishal.repository.login.LoginDataResource;
import com.faishalbadri.instagramcoursebyfaishal.util.Server;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/6/17.
 */

public class LoginDataRemote implements LoginDataResource {

  Context context;
  private static final String URL = Server.BASE_URL + "login_user.php";

  public LoginDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getLoginResult(final String user_name, final String user_password,
      @NonNull final LoginGetCallback loginGetCallback) {
    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(
        Method.POST, String.valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        try {
          if (String.valueOf(new JSONObject(response).getString("msg")).equals("Berhasil")) {
            try {
              final PojoUser pojoUser = new Gson().fromJson(response, PojoUser.class);
              for (int a = 0; a < pojoUser.getUser().size(); a++) {
                String id_user = pojoUser.getUser().get(a).getId_user();
                String user_name = pojoUser.getUser().get(a).getUser_name();
                String user_nickname = pojoUser.getUser().get(a).getUser_nickname();
                String user_following = pojoUser.getUser().get(a).getUser_following();
                String user_followers = pojoUser.getUser().get(a).getUser_followers();
                String user_bio = pojoUser.getUser().get(a).getUser_bio();
                String user_handphone_number = pojoUser.getUser().get(a).getUser_handphone_number();
                String user_email = pojoUser.getUser().get(a).getUser_email();
                String user_image = pojoUser.getUser().get(a).getUser_image();
                String user_password = pojoUser.getUser().get(a).getUser_password();
                String user_verify_code = pojoUser.getUser().get(a).getUser_verify_code();
                String user_verified_code = pojoUser.getUser().get(a).getUser_verified_code();
                String user_gender = pojoUser.getUser().get(a).getUser_gender();
                String user_account_status = pojoUser.getUser().get(a).getUser_account_status();
                loginGetCallback
                    .onSuccesLogin("succes", id_user, user_name, user_nickname, user_following,
                        user_followers, user_bio, user_handphone_number, user_email, user_image,
                        user_password, user_verify_code,user_verified_code, user_gender, user_account_status);
              }
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {
            Toast.makeText(context, "Wrong Email or Password", Toast.LENGTH_SHORT).show();
            loginGetCallback.onWrongLogin("Gagal");
          }
        } catch (JSONException e) {

        } catch (Exception e) {

        }

      }
    }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        loginGetCallback.onErrorLogin(String.valueOf(error));
      }
    }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("user_name", user_name);
        params.put("user_password", user_password);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
