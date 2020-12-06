package com.example.AluCar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.AluCar.BDhelper.VeiculoDAO;
import com.example.AluCar.R;
import com.example.AluCar.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class ListarDisponiveis extends AppCompatActivity {

    private ListView listView;
    private VeiculoDAO dao;
    private List<Veiculo> veiculos;
    private List<Veiculo> veiculosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_disponiveis);

        listView = findViewById(R.id.lista_veiculos_diponiveis);
        dao = new VeiculoDAO(this);
        veiculos = dao.veiculosDiponiveis();
        veiculosFiltrados.addAll(veiculos);
        ArrayAdapter<Veiculo> adapter = new ArrayAdapter<Veiculo>(this,
                android.R.layout.simple_list_item_1, veiculosFiltrados);
        listView.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_veic_diponiveis, menu);
        return true;
    }

    public void cadastrarVeiculo(MenuItem item){
        Intent it = new Intent(this,
                cadastrar_veiculo.class);
        startActivity(it);
    }

    @Override
    public void onResume(){
        super.onResume();
        veiculos = dao.veiculosDiponiveis();
        veiculosFiltrados.clear();
        veiculosFiltrados.addAll(veiculos);
        listView.invalidateViews();
    }

}