package com.dojos.crud.service;

import android.os.AsyncTask;

import com.dojos.crud.entidades.RetornoWebService;

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
public class LoginService extends AsyncTask<String, Integer, RetornoWebService> {


    private ServiceResponse listener;

    public LoginService(ServiceResponse listener) {
        this.listener = listener;
    }

    // required methods
    @Override
    protected void onPostExecute(RetornoWebService retornoWebService) {
        listener.onTaskCompleted(retornoWebService);
    }


    @Override
    protected RetornoWebService doInBackground(String... params) {

        RetornoWebService retornoWebService;

        String login = params[0];
        String senha = params[1];
        JSONObject jsonobj = new JSONObject();
        JSONObject jsonResponse;
        String tokenRetornado;

        tokenRetornado = "";
        retornoWebService = new RetornoWebService();

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

                retornoWebService.setRetornoWs(true);

                jsonResponse = new JSONObject(responseText);

                if (jsonResponse.has("token"))
                    tokenRetornado = jsonResponse.get("token").toString();
                else
                    tokenRetornado = null;
                retornoWebService.setMensagemRetorno(httpresponse.getStatusLine().getReasonPhrase());
                retornoWebService.setRetorno(tokenRetornado);
            } else {
                retornoWebService.setRetornoWs(false);
                retornoWebService.setMensagemRetorno(httpresponse.getStatusLine().getReasonPhrase());
                tokenRetornado = null;
                retornoWebService.setRetorno(tokenRetornado);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return retornoWebService;
    }


}
