package com.dojos.crud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClick(View view){
        EditText password = ((EditText)findViewById(R.id.password));
        Intent intent = new Intent(this, GeralActivity.class);
    }
}
