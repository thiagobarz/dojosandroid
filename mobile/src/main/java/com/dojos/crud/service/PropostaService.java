package com.dojos.crud.service;

import android.os.AsyncTask;

import com.dojos.crud.PrincipalActivity;
import com.dojos.crud.entidades.RetornoWebService;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by thiagobarz on 13/04/2016.
 */
public class PropostaService  extends AsyncTask<String, Integer, RetornoWebService> {


    public PropostaService(PrincipalActivity principalActivity) {
    }

    @Override
    protected RetornoWebService doInBackground(String... params) {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet("http://dojoandroid.getsandbox.com/obtempropostas");
        httpGet.setHeader("Content-type", "application/json");
        httpGet.addHeader("token", params[0]);

        try {
            HttpResponse response = httpclient.execute(httpGet);
            String responseText;
            responseText = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }



        return null;
    }
}
