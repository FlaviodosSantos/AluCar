package com.example.AluCar.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.AluCar.R;
import com.example.AluCar.model.Veiculo;

import java.util.List;

public class VeiculoAdapter extends BaseAdapter {

    private List<Veiculo> veiculos;
    private Activity activity;

    public VeiculoAdapter(Activity activity, List<Veiculo> veiculos) {
        this.activity = activity;
        this.veiculos = veiculos;
    }

    @Override
    public int getCount() {
        return veiculos.size();
    }

    @Override
    public Object getItem(int position) {
        return veiculos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return veiculos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View view = activity.getLayoutInflater().inflate(R.layout.item_veiculo, viewGroup, false);
        TextView marca = view.findViewById(R.id.txt_marcaA);
        TextView modelo = view.findViewById(R.id.txt_modeloA);
        TextView cor = view.findViewById(R.id.txt_corA);
        TextView ano = view.findViewById(R.id.txt_anoA);
        TextView placa = view.findViewById(R.id.txt_placaA);

        Veiculo v = veiculos.get(position);

        marca.setText(v.getMarca());
        modelo.setText(v.getModelo());
        cor.setText(v.getCor());
        ano.setText(v.getAno());
        placa.setText(v.getPlaca());

        return view;
    }
}
