package com.example.AluCar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.AluCar.R;

public class Cadastrar_locacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_locacao);
    }

    public void adicionarVeiculo(android.view.View view){
        Intent i = new Intent(this, ListarVeiculos.class);
        startActivity(i);

    }

    public void adicionarCliente(android.view.View view){
        Intent i = new Intent(this, ListarClientes.class);
        startActivity(i);

    }

}