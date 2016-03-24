package com.dojos.crud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

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
            Toast.makeText(this, getString(R.string.toastPreenchaUsuarioSenha), Toast.LENGTH_LONG);
        } else {
            Intent intentTelaGeral = new Intent(this, GeralActivity.class);
            startActivity(intentTelaGeral);
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
}
