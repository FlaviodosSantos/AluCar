package com.example.AluCar.BDhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.AluCar.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public VeiculoDAO(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserirVeiculo(Veiculo veiculo){
        ContentValues values = new ContentValues();
        values.put("marca", veiculo.getMarca());
        values.put("modelo", veiculo.getModelo());
        values.put("cor", veiculo.getCor());
        values.put("ano", veiculo.getAno());
        values.put("placa", veiculo.getPlaca());
        values.put("status", veiculo.getStatus());
        return banco.insert("veiculo", null, values);
    }

    public List<Veiculo> veiculosDiponiveis(){
        List<Veiculo> veiculos = new ArrayList<>();
        String table = "veiculo";
        String[] colunas = {"id", "marca","modelo","cor","ano","placa"};
        String where = " status = ?";
        String[] args = {"disponivel"};
        Cursor cursor = banco.query(table, colunas, where, args, null,null,null);
        while(cursor.moveToNext()){
            Veiculo v = new Veiculo();
            v.setId(cursor.getInt(0));
            v.setMarca(cursor.getString(1));
            v.setModelo(cursor.getString(2));
            v.setCor(cursor.getString(3));
            v.setAno(cursor.getString(4));
            v.setPlaca(cursor.getString(5));
            veiculos.add(v);
        }

        return veiculos;
    }

    public void excluirVeiculo(Veiculo v){
        banco.delete("veiculo", "id = ?", new String[]{v.getId().toString()});
    }

    public void atualizarVeiculo(Veiculo veiculo){
        ContentValues values = new ContentValues();
        values.put("marca", veiculo.getMarca());
        values.put("modelo", veiculo.getModelo());
        values.put("cor", veiculo.getCor());
        values.put("ano", veiculo.getAno());
        values.put("placa", veiculo.getPlaca());
        //values.put("status", veiculo.getStatus());
        banco.update("veiculo", values, "id = ?",
                new String[]{veiculo.getId().toString()});
    }

}
