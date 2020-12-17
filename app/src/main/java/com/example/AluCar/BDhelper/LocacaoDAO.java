package com.example.AluCar.BDhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.AluCar.model.Alugueis;
import com.example.AluCar.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class LocacaoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;
    private Veiculo veiculo;

    public LocacaoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirLocacao(Alugueis alugueis){
        ContentValues val = new ContentValues();

        val.put("idVeic", alugueis.getIdVeic());
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

        //int id = alugueis.getIdVeic();
        ContentValues values = new ContentValues();
        values.put("status", "alugado");
        banco.update("veiculo", values, "id = ?",
                new String[]{alugueis.getIdVeic().toString()});

        return banco.insert("locacao", null, val);
    }

    public List<Alugueis> listarLocacoes(){
        List<Alugueis> alugueis = new ArrayList<>();
        String[] colunas = {"id", "idVeic","marcaA","modeloA","corA","anoA","placaA", "nomeA", "cpfA",
                "telefoneA", "data_aluguel", "data_devolucao", "qtd_dias", "valor_aluguel"};
        Cursor cursor = banco.query("locacao", colunas, null, null,
                null,null, null);
        while(cursor.moveToNext()){
            Alugueis a = new Alugueis();

            a.setId(cursor.getInt(0));
            a.setIdVeic(cursor.getInt(1));
            a.setMarcaA(cursor.getString(2));
            a.setModeloA(cursor.getString(3));
            a.setCorA(cursor.getString(4));
            a.setAnoA(cursor.getString(5));
            a.setPlacaA(cursor.getString(6));
            a.setNomeA(cursor.getString(7));
            a.setCpfA(cursor.getString(8));
            a.setTelefoneA(cursor.getString(9));
            a.setData_aluguel(cursor.getString(10));
            a.setData_devolucao(cursor.getString(11));
            a.setQtd_dias(cursor.getString(12));
            a.setValor_aluguel(cursor.getString(13));

            alugueis.add(a);
        }
        return alugueis;
    }

    public void deletarLocacao(Alugueis a){

        //atualizar mudança de status do veiculo
        ContentValues values = new ContentValues();
        values.put("status", "disponivel");
        banco.update("veiculo", values, "id = ?",
                new String[]{a.getIdVeic().toString()});

        //deleta locação do banco de dados
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
