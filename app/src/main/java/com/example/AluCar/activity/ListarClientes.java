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

import com.example.AluCar.BDhelper.ClienteDAO;
import com.example.AluCar.R;
import com.example.AluCar.adapter.ClienteAdapter;
import com.example.AluCar.model.Clientes;


import java.util.ArrayList;
import java.util.List;

public class ListarClientes extends AppCompatActivity {

    private ListView listView;
    private ClienteDAO clienteDAO;
    private List<Clientes> clientes;
    private List<Clientes> clientesFiltrados = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_clientes);

        listView = findViewById(R.id.lista_cliente);
        clienteDAO = new ClienteDAO(this);
        clientes = clienteDAO.obterTodosClientes();
        clientesFiltrados.addAll(clientes);
        //ArrayAdapter<Clientes> adapter = new ArrayAdapter<>(this,
        //        android.R.layout.simple_list_item_1, clientesFiltrados);
        ClienteAdapter adapter = new ClienteAdapter(this, clientesFiltrados);

        listView.setAdapter(adapter);

        registerForContextMenu(listView);



    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_lista_clientes, menu);

        SearchView sv_nome = (SearchView) menu.findItem(R.id.app_bar_search_cliente_nome).getActionView();
        SearchView sv_cpf = (SearchView) menu.findItem(R.id.app_bar_search_cliente_cpf).getActionView();
        sv_nome.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                pesquisaClientePorNome(s);
                return false;
            }
        });
        sv_cpf.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                pesquisaClientePorCpf(s);
                return false;
            }
        });
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater i = getMenuInflater();
        i.inflate(R.menu.menu_contexto_clientes, menu);
    }

    public void pesquisaClientePorNome(String nome){
        clientesFiltrados.clear();
        for(Clientes c : clientes){
            if(c.getNome().toLowerCase().contains(nome.toLowerCase())){
                clientesFiltrados.add(c);
            }
        }
        listView.invalidateViews();
    }

    public void pesquisaClientePorCpf(String cpf){
        clientesFiltrados.clear();
        for(Clientes c : clientes){
            if(c.getCpf().toLowerCase().contains(cpf.toLowerCase())){
                clientesFiltrados.add(c);
            }
        }
        listView.invalidateViews();
    }

    public void cadastrarCliente(MenuItem item){
        Intent it = new Intent(this,
                Cadastrar_cliente.class);
        startActivity(it);
    }

    public void excluirCliente(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Clientes clienteExcluir = clientesFiltrados.get(menuInfo.position);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Realmente deseja excluir o veículo ?")
                .setNegativeButton("NÃO", null)
                .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        clientesFiltrados.remove(clienteExcluir);
                        clientes.remove(clienteExcluir);
                        clienteDAO.excluirCli(clienteExcluir);
                        listView.invalidateViews();
                    }
                }).create();
        dialog.show();
    }

    public void atualizarCliente(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Clientes clienteAtualizar = clientesFiltrados.get(menuInfo.position);
        Intent it = new Intent(this, Cadastrar_cliente.class);
        it.putExtra("clienteAtu", clienteAtualizar );
        startActivity(it);
    }

    public void enviarCliente(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final Clientes clienteEnviar = clientesFiltrados.get(menuInfo.position);
        Intent it = new Intent(this, Cadastrar_locacao.class);
        it.putExtra("clienteEnv", clienteEnviar);
        startActivity(it);
        finish();
    }



    @Override
    public void onResume(){
        super.onResume();
        clientes = clienteDAO.obterTodosClientes();
        clientesFiltrados.clear();
        clientesFiltrados.addAll(clientes);
        listView.invalidateViews();
    }

}