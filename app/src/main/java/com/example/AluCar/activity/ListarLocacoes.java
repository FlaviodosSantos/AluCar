package com.example.AluCar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.AluCar.R;

public class ListarLocacoes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litar_locacoes);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_lista_locacoes, menu);

        return true;
    }

    public void cadastrar_locacao(MenuItem item){
        Intent it = new Intent(this, Cadastrar_locacao.class);
        startActivity(it);
    }
}