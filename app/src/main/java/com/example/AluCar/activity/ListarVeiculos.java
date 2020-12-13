package com.example.AluCar.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.AluCar.BDhelper.VeiculoDAO;
import com.example.AluCar.R;
import com.example.AluCar.adapter.VeiculoAdapter;
import com.example.AluCar.model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class ListarVeiculos extends AppCompatActivity {

    private ListView listView;
    private VeiculoDAO dao;
    private List<Veiculo> veiculos;
    private List<Veiculo> veiculosFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_veiculos);

        listView = findViewById(R.id.lista_veiculos_diponiveis);
        dao = new VeiculoDAO(this);
        veiculos = dao.veiculosDiponiveis();
        veiculosFiltrados.addAll(veiculos);
        //ArrayAdapter<Veiculo> adapter = new ArrayAdapter<Veiculo>(this,
         //       android.R.layout.simple_list_item_1, veiculosFiltrados);
        VeiculoAdapter adapter = new VeiculoAdapter(this, veiculosFiltrados);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_veic_diponiveis, menu);

        SearchView sv = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                procuraVeiculo(s);
                return false;
            }
        });
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contexto, menu);
    }


    public void procuraVeiculo(String modelo){
        veiculosFiltrados.clear();
        for(Veiculo v : veiculos){
            if(v.getModelo().toLowerCase().contains(modelo.toLowerCase())){
                veiculosFiltrados.add(v);
            }
        }
        listView.invalidateViews();
    }

    public void cadastrarVeiculo(MenuItem item){
        Intent it = new Intent(this,
                Cadastrar_veiculo.class);
        startActivity(it);
    }

    public void excluirVeiculo(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Veiculo veiculoExcluir = veiculosFiltrados.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente deseja excluir o veículo ?")
                .setNegativeButton("NÃO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        veiculosFiltrados.remove(veiculoExcluir);
                        veiculos.remove(veiculoExcluir);
                        dao.excluirVeiculo(veiculoExcluir);
                        listView.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    public void atualizarVeiculo(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Veiculo veiculoAtualizar = veiculosFiltrados.get(menuInfo.position);
        Intent it = new Intent(this, Cadastrar_veiculo.class);
        it.putExtra("veiculo", veiculoAtualizar);
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