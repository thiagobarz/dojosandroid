package com.dojos.crud;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dojos.crud.entidades.RetornoWebService;
import com.dojos.crud.service.LoginService;
import com.dojos.crud.service.LoginServiceResponse;

public class LoginActivity extends AppCompatActivity implements LoginServiceResponse {

    private LoginServiceResponse listener;
    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = ((EditText) findViewById(R.id.usuario));
        senha = ((EditText) findViewById(R.id.senha));
    }

    /**
     * Valida se os campos foram preenchidos e abre a tela principal.
     *
     * @param view View de onde esse método está sendo chamado.
     */
    public void realizarLogin(View view) {
        if (!isCamposPreenchidos()) {
            Toast.makeText(this, getString(R.string.toastPreenchaUsuarioSenha), Toast.LENGTH_LONG).show();
        } else {
            LoginService service = new LoginService(this);
            //service.getToken(usuario.getText().toString(), senha.getText().toString());
            service.execute(usuario.getText().toString(), senha.getText().toString());



        }
    }

    /**
     * Verifica se os campos obrigatórios foram preenchidos.
     *
     * @return TRUE se foram preenchidos e FALSE em caso contrário.
     */
    private Boolean isCamposPreenchidos() {
        return (!usuario.getText().toString().isEmpty() && !senha.getText().toString().isEmpty());
    }

    @Override
    public void onTaskCompleted(RetornoWebService retornoWebService) {
        Log.i("DojoAndroid", retornoWebService.getMensagemRetorno());
        if (retornoWebService.isRetornoWs() && retornoWebService.getRetorno() != null) {

            //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("DojoAndroid", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(getString(R.string.TOKEN), (String) retornoWebService.getRetorno());
            editor.putString(getString(R.string.USUARIO), usuario.getText().toString());
            editor.commit();

            Intent intentTelaGeral = new Intent(this, PrincipalActivity.class);
            startActivity(intentTelaGeral);
        } else {
            Toast.makeText(this, getString(R.string.toastUsuarioSenhaInvalido), Toast.LENGTH_LONG).show();
        }

    }
}
