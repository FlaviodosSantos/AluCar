package com.example.AluCar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ListarDisponiveis(android.view.View view){
        Intent it = new Intent(this,
                ListarDisponiveis.class);
        startActivity(it);
    }

    public void ListarAlugados(android.view.View view){
        Intent it = new Intent(this,
                ListarAlugados.class);
        startActivity(it);
    }

    public void Historico(View view){
        Intent it = new Intent(this, Historico.class);
        startActivity(it);
    }

}