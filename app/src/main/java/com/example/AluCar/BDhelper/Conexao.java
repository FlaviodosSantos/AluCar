package com.example.AluCar.BDhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE veiculo(id integer PRIMARY KEY AUTOINCREMENT," +
                "marca varchar(25), modelo varchar(25), cor varchar(25), ano varchar(4)," +
                "placa varchar(7), status varchar(10))");

        db.execSQL("CREATE TABLE cliente(id integer PRIMARY KEY AUTOINCREMENT," +
                "nome varchar(50), cpf varchar(15), telefone varchar(15))");

        db.execSQL("CREATE TABLE locacao(id integer PRIMARY KEY AUTOINCREMENT," +
                "idVeic integer, marcaA varchar(25), modeloA varchar(25), corA varchar(25), " +
                "anoA varchar(25), placaA varchar(25)," +
                "nomeA varchar(25), cpfA varchar(15), telefoneA varchar(25), " +
                "data_aluguel varchar(25), data_devolucao varchar(25)," +
                "qtd_dias varchar(10), valor_aluguel varchar(10))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
