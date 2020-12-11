package com.example.AluCar.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.AluCar.R;
import com.example.AluCar.model.Clientes;

import java.util.List;

public class ClienteAdapter extends BaseAdapter {

    private List<Clientes> clientes;
    private Activity activity;

    public ClienteAdapter(Activity activity, List<Clientes> clientes){
        this.activity = activity;
        this.clientes = clientes;
    }


    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int position) {
        return clientes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return clientes.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View view = activity.getLayoutInflater().inflate(R.layout.item_cliente, viewGroup, false);
        TextView nome = view.findViewById(R.id.txt_nome);
        TextView cpf = view.findViewById(R.id.txt_cpf);
        TextView telefone = view.findViewById(R.id.txt_telefone);

        Clientes c = clientes.get(position);

        nome.setText(c.getNome());
        cpf.setText(c.getCpf());
        telefone.setText(c.getTelefone());

        return view;
    }
}
