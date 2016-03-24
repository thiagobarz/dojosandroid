package com.dojos.crud.service;

import android.os.AsyncTask;

/**
 * Created by thiagobarz on 24/03/2016.
 */
public class LoginService extends AsyncTask<String, Integer, Long> {

    @Override
    protected Long doInBackground(String... params) {
        String login = params[0];
        String senha = params[1];

        return null;
    }

    public boolean getToken(String login, String senha) {
        doInBackground(login, senha);
        return false;
    }
}
