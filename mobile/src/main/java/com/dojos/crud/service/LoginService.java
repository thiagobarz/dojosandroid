package com.dojos.crud.service;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by thiagobarz on 24/03/2016.
 */
public class LoginService extends AsyncTask<String, Integer, String> {


    private LoginServiceResponse listener;

    public LoginService(LoginServiceResponse listener) {
        this.listener = listener;
    }

    // required methods

    protected void onPostExecute(String... params) {
        // your stuff
        listener.onTaskCompleted();
    }

    @Override
    protected String doInBackground(String... params) {

        String login = params[0];
        String senha = params[1];
        JSONObject jsonobj = new JSONObject();
        JSONObject jsonResponse;
        try {
            jsonobj.put("usuario", login);
            jsonobj.put("senha", senha);
            DefaultHttpClient httpclient = new DefaultHttpClient();
            HttpPost httppostreq = new HttpPost("http://dojoandroid.getsandbox.com/login");
            StringEntity se = new StringEntity(jsonobj.toString());
            se.setContentType("application/json;charset=UTF-8");
            se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
            httppostreq.setEntity(se);
            HttpResponse httpresponse = httpclient.execute(httppostreq);
            String responseText;
            responseText = EntityUtils.toString(httpresponse.getEntity());
            if (httpresponse.getStatusLine().getStatusCode() == 200) {
                jsonResponse = new JSONObject(responseText);
                return (String) jsonResponse.get("token");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
