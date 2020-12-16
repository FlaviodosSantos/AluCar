package com.example.AluCar.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.AluCar.R;
import com.example.AluCar.model.Alugueis;

import java.util.List;

public class LocacaoAdapter extends BaseAdapter {

    private List<Alugueis> alugueis;
    private Activity activity;

    public LocacaoAdapter(Activity activity, List<Alugueis> alugueis) {
        this.activity = activity;
        this.alugueis = alugueis;
    }

    @Override
    public int getCount() {
        return alugueis.size();
    }

    @Override
    public Object getItem(int position) {
        return alugueis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alugueis.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View v = activity.getLayoutInflater().inflate(R.layout.item_locacao, parent, false);

        TextView marca = v.findViewById(R.id.TV_marcaA);
        TextView modelo = v.findViewById(R.id.TV_modelo);
        TextView cor = v.findViewById(R.id.TV_cor);
        TextView ano = v.findViewById(R.id.TV_ano);
        TextView placa = v.findViewById(R.id.TV_placa);
        TextView nome = v.findViewById(R.id.TV_nome);
        TextView cpf = v.findViewById(R.id.TV_cpf);
        TextView telefone = v.findViewById(R.id.TV_telefone);
        TextView dt_aluguel = v.findViewById(R.id.TV_data_aluguel);
        TextView dt_devolucao = v.findViewById(R.id.TV_data_devolucao);
        TextView qtd_dias = v.findViewById(R.id.TV_qtd_dias);
        TextView vr_aluguel = v.findViewById(R.id.TV_valor_aluguel);

        Alugueis a = alugueis.get(position);

        marca.setText(a.getMarcaA());
        modelo.setText(a.getModeloA());
        cor.setText(a.getCorA());
        ano.setText(a.getAnoA());
        placa.setText(a.getPlacaA());
        nome.setText(a.getNomeA());
        cpf.setText(a.getCpfA());
        telefone.setText(a.getTelefoneA());
        dt_aluguel.setText(a.getData_aluguel());
        dt_devolucao.setText(a.getData_devolucao());
        qtd_dias.setText(a.getQtd_dias());
        vr_aluguel.setText(a.getValor_aluguel());

        return v;
    }
}
