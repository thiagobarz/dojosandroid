package com.dojos.crud.service;

import android.os.AsyncTask;
import android.util.Log;

import com.dojos.crud.PrincipalActivity;
import com.dojos.crud.entidades.Proposta;
import com.dojos.crud.entidades.PropostaResponse;
import com.dojos.crud.entidades.RetornoWebService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiagobarz on 13/04/2016.
 */
public class PropostaService  extends AsyncTask<String, Integer, RetornoWebService> {

    private ServiceResponse listener;

    public PropostaService(PrincipalActivity principalActivity) {

    }

    // required methods
    @Override
    protected void onPostExecute(RetornoWebService retornoWebService) {
        listener.onTaskCompleted(retornoWebService);
    }

    @Override
    protected RetornoWebService doInBackground(String... params) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        RetornoWebService retornoWebService;
        retornoWebService = new RetornoWebService();

        JSONObject jsonobj = new JSONObject();
        JSONObject jsonResponse;

        Object retorno;

        HttpGet httpGet = new HttpGet("http://dojoandroid.getsandbox.com/obtempropostas");
        httpGet.setHeader("Content-type", "application/json");
        httpGet.addHeader("token", params[0]);

        try {
            HttpResponse response = httpclient.execute(httpGet);
            String responseText;
            responseText = EntityUtils.toString(response.getEntity());
            if (response.getStatusLine().getStatusCode() == 200) {

                retornoWebService.setRetornoWs(true);

                jsonResponse = new JSONObject(responseText);

                if (jsonResponse.has("propostas")) {
                    Gson gson = new Gson();
//                    Type listType = new TypeToken<ArrayList<Proposta>>() {
//                    }.getType();
                    PropostaResponse res = gson.fromJson(jsonResponse.toString(), PropostaResponse.class);
//                    Log.i("CWebServicePropostas",res.get(0).getCodigo());

         //           tokenRetornado = jsonResponse.get("token").toString();
                }
                else
                    retorno = null;

//                retornoWebService.setMensagemRetorno(httpresponse.getStatusLine().getReasonPhrase());
//                retornoWebService.setRetorno(tokenRetornado);
            } else {
//                retornoWebService.setRetornoWs(false);
//                retornoWebService.setMensagemRetorno(httpresponse.getStatusLine().getReasonPhrase());
//                tokenRetornado = null;
//                retornoWebService.setRetorno(tokenRetornado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return null;
    }
}
