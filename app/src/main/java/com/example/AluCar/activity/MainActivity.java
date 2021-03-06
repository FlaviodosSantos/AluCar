package com.example.AluCar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.AluCar.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ListarDisponiveis(android.view.View view){
        Intent it = new Intent(this,
                ListarVeiculos.class);
        startActivity(it);
    }

    public void ListarClientes(android.view.View view){
        Intent it = new Intent(this,
                ListarClientes.class);
        startActivity(it);
    }

    public void Historico(View view){
        Intent it = new Intent(this, ListarLocacoes.class);
        startActivity(it);
    }

}