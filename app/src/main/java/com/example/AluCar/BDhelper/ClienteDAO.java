package com.example.AluCar.BDhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.AluCar.model.Clientes;


import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ClienteDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirCliente(Clientes clientes){
        ContentValues values = new ContentValues();
        values.put("nome", clientes.getNome());
        values.put("cpf", clientes.getCpf());
        values.put("telefone", clientes.getTelefone());
        return banco.insert("cliente", null, values);
    }

    public List<Clientes> obterTodosClientes(){
        List<Clientes> clientes = new ArrayList<>();
        Cursor cursor = banco.query("cliente", new String[]{"id", "nome","cpf", "telefone"},
                null, null,null, null, null);
        while (cursor.moveToNext()){
            Clientes c = new Clientes();
            c.setId(cursor.getInt(0));
            c.setNome(cursor.getString(1));
            c.setCpf(cursor.getString(2));
            c.setTelefone(cursor.getString(3));
            clientes.add(c);
        }
        return clientes;
    }

    public void excluirCli(Clientes clienteExcluir) {
        banco.delete("cliente", "id = ?",
                new String[]{clienteExcluir.getId().toString()});
    }

    public void atualizarCli(Clientes cliente){
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("cpf", cliente.getCpf());
        values.put("telefone", cliente.getTelefone());

        banco.update("cliente", values, "id = ?",
                new String[]{cliente.getId().toString()});
    }
}
