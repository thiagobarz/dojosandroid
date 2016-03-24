package com.dojos.crud.service;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by thiagobarz on 24/03/2016.
 */
public class LoginService extends AsyncTask<String, Integer, Long> {

    @Override
    protected Long doInBackground(String... params) {
        String login = params[0];
        String senha = params[1];
        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://example.com/service");
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            String body = "username=user1&locationname=location1";
            OutputStream output = new BufferedOutputStream(conn.getOutputStream());
            output.write(body.getBytes());
            output.flush();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return null;
    }

}

    public boolean getToken(String login, String senha) {
        doInBackground(login, senha);
    }
}
