package com.example.AluCar.BDhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.AluCar.model.Alugueis;

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

}
