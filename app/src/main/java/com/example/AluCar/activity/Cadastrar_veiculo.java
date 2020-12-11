package com.example.AluCar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.AluCar.BDhelper.VeiculoDAO;
import com.example.AluCar.R;
import com.example.AluCar.model.Veiculo;

public class Cadastrar_veiculo extends AppCompatActivity {

    private EditText marca, modelo, cor, ano, placa;
    private VeiculoDAO dao;
    private Veiculo veiculo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_veiculo);

        marca = findViewById(R.id.editMarca);
        modelo = findViewById(R.id.editModelo);
        cor = findViewById(R.id.editCor);
        ano = findViewById(R.id.editAno);
        placa = findViewById(R.id.editPlaca);
        dao = new VeiculoDAO(this);

        Intent it = getIntent();
        if(it.hasExtra("veiculo")){
            veiculo = (Veiculo) it.getSerializableExtra("veiculo");
            marca.setText(veiculo.getMarca());
            modelo.setText(veiculo.getModelo());
            cor.setText(veiculo.getCor());
            ano.setText(veiculo.getAno());
            placa.setText(veiculo.getPlaca());
        }
    }

    public void salvarVeic(View view){

        if(veiculo == null){
            Veiculo veiculo = new Veiculo();
            veiculo.setMarca(marca.getText().toString());
            veiculo.setModelo(modelo.getText().toString());
            veiculo.setCor(cor.getText().toString());
            veiculo.setAno(ano.getText().toString());
            veiculo.setPlaca(placa.getText().toString());
            veiculo.setStatus("disponivel");
            long id = dao.inserirVeiculo(veiculo);
            Toast.makeText(this, "Veiculo inserido com id : "+ id, Toast.LENGTH_SHORT).show();
        }else {
            veiculo.setMarca(marca.getText().toString());
            veiculo.setModelo(modelo.getText().toString());
            veiculo.setCor(cor.getText().toString());
            veiculo.setAno(ano.getText().toString());
            veiculo.setPlaca(placa.getText().toString());
            dao.atualizarVeiculo(veiculo);
            Toast.makeText(this, "Veiculo Atualizado ", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}