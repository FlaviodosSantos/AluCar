package com.example.AluCar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.AluCar.BDhelper.ClienteDAO;
import com.example.AluCar.R;
import com.example.AluCar.model.Clientes;


public class Cadastrar_cliente extends AppCompatActivity {

    private EditText nome, cpf, telefone;
    private ClienteDAO cliDao;
    private Clientes clientes = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_cliente);

        nome = findViewById(R.id.editText_nome);
        cpf = findViewById(R.id.editText_cpf);
        telefone = findViewById(R.id.editText_Telefone);
        cliDao = new ClienteDAO(this);

        Intent it = getIntent();
        if(it.hasExtra("clienteAtu")){
            clientes = (Clientes) it.getSerializableExtra("clienteAtu");
            nome.setText(clientes.getNome());
            cpf.setText(clientes.getCpf());
            telefone.setText(clientes.getTelefone());
        }
    }

    public void salvarCliente(View view){

        if(clientes == null){
            Clientes clientes = new Clientes();
            clientes.setNome(nome.getText().toString());
            clientes.setCpf(cpf.getText().toString());
            clientes.setTelefone(telefone.getText().toString());
            long id = cliDao.inserirCliente(clientes);
            Toast.makeText(this, "Cliente inserido com id : " + id, Toast.LENGTH_SHORT).show();
            finish();
        } else {
            clientes.setNome(nome.getText().toString());
            clientes.setCpf(cpf.getText().toString());
            clientes.setTelefone(telefone.getText().toString());
            cliDao.atualizarCli(clientes);
            Toast.makeText(this, "Cliente atualizado !!!", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}