package com.example.AluCar.model;

import java.io.Serializable;

public class Alugueis implements Serializable {
    private Integer id;
    private Veiculo veiculo;
    private Clientes cliente;
    private String data_aluguel, data_devolucao, qtd_dias, valor_aluguel;


    public Alugueis() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getData_aluguel() {
        return data_aluguel;
    }

    public void setData_aluguel(String data_aluguel) {
        this.data_aluguel = data_aluguel;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getQtd_dias() {
        return qtd_dias;
    }

    public void setQtd_dias(String qtd_dias) {
        this.qtd_dias = qtd_dias;
    }

    public String getValor_aluguel() {
        return valor_aluguel;
    }

    public void setValor_aluguel(String valor_aluguel) {
        this.valor_aluguel = valor_aluguel;
    }
}
