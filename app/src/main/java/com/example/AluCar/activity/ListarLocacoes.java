package com.example.AluCar.activity;

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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.AluCar.BDhelper.LocacaoDAO;
import com.example.AluCar.R;
import com.example.AluCar.adapter.LocacaoAdapter;
import com.example.AluCar.model.Alugueis;

import java.util.ArrayList;
import java.util.List;

public class ListarLocacoes extends AppCompatActivity {

    private ListView listView;
    private LocacaoDAO locacaoDAO;
    private List<Alugueis> alugueis;
    private List<Alugueis> alugueisFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litar_locacoes);

        listView = findViewById(R.id.lista_locacoes);
        locacaoDAO = new LocacaoDAO(this);
        alugueis = locacaoDAO.listarLocacoes();
        alugueisFiltrados.addAll(alugueis);

        LocacaoAdapter adapter = new LocacaoAdapter(this, alugueisFiltrados);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_lista_locacoes, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search_locacoes).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                pesquisarLocacao(s);
                return false;
            }
        });

        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contexto_locacoes, menu);
    }

    public void pesquisarLocacao(String modeloA){
        alugueisFiltrados.clear();
        for (Alugueis a : alugueis){
            if(a.getModeloA().toLowerCase().contains(modeloA.toLowerCase())){
                alugueisFiltrados.add(a);
            }
        }
        listView.invalidateViews();
    }

    public void excluirLocacao(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Alugueis aluguelEcluir = alugueisFiltrados.get(menuInfo.position);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Deseja excluir a locação ?")
                .setNegativeButton("NÃO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        alugueisFiltrados.remove(aluguelEcluir);
                        alugueis.remove(aluguelEcluir);
                        locacaoDAO.deletarLocacao(aluguelEcluir);
                        listView.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    public void cadastrar_locacao(MenuItem item){
        Intent it = new Intent(this, Cadastrar_locacao.class);
        startActivity(it);
    }

    public void atualizarLocacao(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Alugueis aluguelAtualiza = alugueisFiltrados.get(menuInfo.position);
        Intent it = new Intent(this, Cadastrar_locacao.class);
        it.putExtra("aluguel", aluguelAtualiza);
        startActivity(it);
    }

    @Override
    public void onResume(){
        super.onResume();
        alugueis = locacaoDAO.listarLocacoes();
        alugueisFiltrados.clear();
        alugueisFiltrados.addAll(alugueis);
        listView.invalidateViews();
    }
}