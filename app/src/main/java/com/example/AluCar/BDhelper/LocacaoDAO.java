package com.example.AluCar.BDhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.AluCar.model.Alugueis;

import java.util.ArrayList;
import java.util.List;

public class LocacaoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public LocacaoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirLocacao(Alugueis alugueis){
        ContentValues val = new ContentValues();

        val.put("marcaA", alugueis.getMarcaA());
        val.put("modeloA", alugueis.getModeloA());
        val.put("corA", alugueis.getCorA());
        val.put("anoA", alugueis.getAnoA());
        val.put("placaA", alugueis.getPlacaA());

        val.put("nomeA", alugueis.getNomeA());
        val.put("cpfA", alugueis.getCpfA());
        val.put("telefoneA", alugueis.getTelefoneA());

        val.put("data_aluguel", alugueis.getData_aluguel());
        val.put("data_devolucao", alugueis.getData_devolucao());
        val.put("qtd_dias", alugueis.getQtd_dias());
        val.put("valor_aluguel", alugueis.getValor_aluguel());

        return banco.insert("locacao", null, val);
    }

    public List<Alugueis> listarLocacoes(){
        List<Alugueis> alugueis = new ArrayList<>();
        String[] colunas = {"id", "marcaA","modeloA","corA","anoA","placaA", "nomeA", "cpfA",
                "telefoneA", "data_aluguel", "data_devolucao", "qtd_dias", "valor_aluguel"};
        Cursor cursor = banco.query("locacao", colunas, null, null,
                null,null, null);
        while(cursor.moveToNext()){
            Alugueis a = new Alugueis();

            a.setId(cursor.getInt(0));
            a.setMarcaA(cursor.getString(1));
            a.setModeloA(cursor.getString(2));
            a.setCorA(cursor.getString(3));
            a.setAnoA(cursor.getString(4));
            a.setPlacaA(cursor.getString(5));
            a.setNomeA(cursor.getString(6));
            a.setCpfA(cursor.getString(7));
            a.setTelefoneA(cursor.getString(8));
            a.setData_aluguel(cursor.getString(9));
            a.setData_devolucao(cursor.getString(10));
            a.setQtd_dias(cursor.getString(11));
            a.setValor_aluguel(cursor.getString(12));

            alugueis.add(a);
        }
        return alugueis;
    }

    public void deletarLocacao(Alugueis a){
        banco.delete("locacao","id = ?", new String[]{a.getId().toString()});
    }

    public void atualizarLocacao(Alugueis alugueis){
        ContentValues val = new ContentValues();

        val.put("marcaA", alugueis.getMarcaA());
        val.put("modeloA", alugueis.getModeloA());
        val.put("corA", alugueis.getCorA());
        val.put("anoA", alugueis.getAnoA());
        val.put("placaA", alugueis.getPlacaA());

        val.put("nomeA", alugueis.getNomeA());
        val.put("cpfA", alugueis.getCpfA());
        val.put("telefoneA", alugueis.getTelefoneA());

        val.put("data_aluguel", alugueis.getData_aluguel());
        val.put("data_devolucao", alugueis.getData_devolucao());
        val.put("qtd_dias", alugueis.getQtd_dias());
        val.put("valor_aluguel", alugueis.getValor_aluguel());

        banco.update("locacao", val, "id = ?",
                new String[]{alugueis.getId().toString()});
    }

}
