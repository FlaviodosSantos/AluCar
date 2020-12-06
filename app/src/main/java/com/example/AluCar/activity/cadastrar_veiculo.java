package com.example.AluCar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.AluCar.BDhelper.VeiculoDAO;
import com.example.AluCar.R;
import com.example.AluCar.model.Veiculo;

public class cadastrar_veiculo extends AppCompatActivity {

    private EditText marca, modelo, cor, ano, placa;
    private VeiculoDAO dao;

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
    }

    public void salvarVeic(View view){
        Veiculo veic = new Veiculo();
        veic.setMarca(marca.getText().toString());
        veic.setModelo(modelo.getText().toString());
        veic.setCor(cor.getText().toString());
        veic.setAno(ano.getText().toString());
        veic.setPlaca(placa.getText().toString());
        veic.setStatus("disponivel");
        long id = dao.inserirVeiculo(veic);
        Toast.makeText(this, "Veiculo inserido com id : "+ id, Toast.LENGTH_SHORT).show();
        finish();
    }
}