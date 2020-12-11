package com.example.AluCar.BDhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE veiculo(id integer PRIMARY KEY AUTOINCREMENT," +
                "marca varchar(25), modelo varchar(25), cor varchar(25), ano varchar(4)," +
                "placa varchar(7), status varchar(10))");

        db.execSQL("CREATE TABLE cliente(id integer PRIMARY KEY AUTOINCREMENT," +
                "nome varchar(50), cpf varchar(15), telefone varchar(15))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
