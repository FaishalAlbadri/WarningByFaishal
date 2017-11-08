package com.faishalbadri.instagramcoursebyfaishal.repository.verify_code.remote;

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
import com.faishalbadri.instagramcoursebyfaishal.repository.verify_code.VerifyCodeDataResource;
import com.faishalbadri.instagramcoursebyfaishal.util.Server;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by faishal on 11/8/17.
 */

public class VerifyCodeDataRemote implements VerifyCodeDataResource {

  Context context;
  private static final String URL = Server.BASE_URL + "user_verified_code.php";


  public VerifyCodeDataRemote(Context context) {
    this.context = context;
  }

  @Override
  public void getVerifyCodeResult(final String id_user, final String user_verified_code,
      @NonNull final VerifyCodeGetCallback verifyCodeGetCallback) {

    RequestQueue requestQueue = Volley.newRequestQueue(context);
    StringRequest stringRequest = new StringRequest(
        Method.POST, String.valueOf(URL), new Listener<String>() {
      @Override
      public void onResponse(String response) {
        try {
          if (String.valueOf(new JSONObject(response).getString("msg")).equals("Berhasil")) {
            try {
              verifyCodeGetCallback.onSuccesVerifyCode("Succes");
            } catch (Exception e) {
              e.printStackTrace();
            }
          } else {

          }
        } catch (JSONException e) {

        } catch (Exception e) {

        }

      }
    }, new ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        verifyCodeGetCallback.onErrorVerifyCode("Internet Nyari Masalah");
      }
    }) {
      @Override
      protected Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        params.put("id_user", id_user);
        params.put("user_verified_code", user_verified_code);
        return params;
      }
    };
    requestQueue.add(stringRequest);
  }
}
