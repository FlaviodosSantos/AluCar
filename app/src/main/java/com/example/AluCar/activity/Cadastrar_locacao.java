package com.example.AluCar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.AluCar.BDhelper.LocacaoDAO;
import com.example.AluCar.R;
import com.example.AluCar.model.Alugueis;

public class Cadastrar_locacao extends AppCompatActivity {

    private EditText marcaA, modeloA, corA, anoA, placaA;
    private EditText nomeA, cpfA, telefoneA;
    private EditText data_aluguel, data_devolucao, qtd_dias, valor_aluguel;
    private LocacaoDAO locaDao;
    private Alugueis aluguel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_locacao);

        marcaA = findViewById(R.id.edit_marca);
        modeloA = findViewById(R.id.edit_modelo);
        corA = findViewById(R.id.edit_cor);
        anoA = findViewById(R.id.edit_ano);
        placaA = findViewById(R.id.edit_placa);

        nomeA = findViewById(R.id.edit_nome);
        cpfA = findViewById(R.id.edit_cpf);
        telefoneA = findViewById(R.id.edit_telefone);

        data_aluguel = findViewById(R.id.edit_data_aluguel);
        data_devolucao = findViewById(R.id.edit_data_devolucao);
        qtd_dias = findViewById(R.id.edit_qtd_dias);
        valor_aluguel = findViewById(R.id.edit_valor);

        locaDao = new LocacaoDAO(this);

        Intent it = getIntent();
        if (it.hasExtra("aluguel")){
            aluguel = (Alugueis) it.getSerializableExtra("aluguel");
            marcaA.setText(aluguel.getMarcaA());
            modeloA.setText(aluguel.getModeloA());
            corA.setText(aluguel.getCorA());
            anoA.setText(aluguel.getAnoA());
            placaA.setText(aluguel.getPlacaA());
            nomeA.setText(aluguel.getNomeA());
            cpfA.setText(aluguel.getCpfA());
            telefoneA.setText(aluguel.getTelefoneA());
            data_aluguel.setText(aluguel.getData_aluguel());
            data_devolucao.setText(aluguel.getData_devolucao());
            qtd_dias.setText(aluguel.getQtd_dias());
            valor_aluguel.setText(aluguel.getValor_aluguel());
        }
    }

    public void adicionarVeiculo(android.view.View view){
        Intent i = new Intent(this, ListarVeiculos.class);
        startActivity(i);

    }

    public void adicionarCliente(android.view.View view){
        Intent i = new Intent(this, ListarClientes.class);
        startActivity(i);

    }

    public void salvarLocacao(View view){

        if(aluguel == null) {
            Alugueis alugueis = new Alugueis();
            //veiculo
            alugueis.setMarcaA(marcaA.getText().toString());
            alugueis.setModeloA(modeloA.getText().toString());
            alugueis.setCorA(corA.getText().toString());
            alugueis.setAnoA(anoA.getText().toString());
            alugueis.setPlacaA(placaA.getText().toString());
            //cliente
            alugueis.setNomeA(nomeA.getText().toString());
            alugueis.setCpfA(cpfA.getText().toString());
            alugueis.setTelefoneA(telefoneA.getText().toString());
            //aluguel
            alugueis.setData_aluguel(data_aluguel.getText().toString());
            alugueis.setData_devolucao(data_devolucao.getText().toString());
            alugueis.setQtd_dias(qtd_dias.getText().toString());
            alugueis.setValor_aluguel(valor_aluguel.getText().toString());

            long id = locaDao.inserirLocacao(alugueis);
            Toast.makeText(this, "Locação inserida com id : " + id, Toast.LENGTH_SHORT).show();

        } else {
            //veiculo
            aluguel.setMarcaA(marcaA.getText().toString());
            aluguel.setModeloA(modeloA.getText().toString());
            aluguel.setCorA(corA.getText().toString());
            aluguel.setAnoA(anoA.getText().toString());
            aluguel.setPlacaA(placaA.getText().toString());
            //cliente
            aluguel.setNomeA(nomeA.getText().toString());
            aluguel.setCpfA(cpfA.getText().toString());
            aluguel.setTelefoneA(telefoneA.getText().toString());
            //aluguel
            aluguel.setData_aluguel(data_aluguel.getText().toString());
            aluguel.setData_devolucao(data_devolucao.getText().toString());
            aluguel.setQtd_dias(qtd_dias.getText().toString());
            aluguel.setValor_aluguel(valor_aluguel.getText().toString());

            locaDao.atualizarLocacao(aluguel);
            Toast.makeText(this, "Locação atualizada", Toast.LENGTH_SHORT).show();
        }
        finish();
    }


}