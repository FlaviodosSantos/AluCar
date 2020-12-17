package com.example.AluCar.model;

import java.io.Serializable;

public class Alugueis implements Serializable {

    private Integer id, idVeic;
    private String marcaA, modeloA, corA, anoA, placaA;
    private String nomeA, cpfA, telefoneA;
    private String data_aluguel, data_devolucao, qtd_dias, valor_aluguel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdVeic() {
        return idVeic;
    }

    public void setIdVeic(Integer idVeic) {
        this.idVeic = idVeic;
    }

    public String getMarcaA() {
        return marcaA;
    }

    public void setMarcaA(String marcaA) {
        this.marcaA = marcaA;
    }

    public String getModeloA() {
        return modeloA;
    }

    public void setModeloA(String modeloA) {
        this.modeloA = modeloA;
    }

    public String getCorA() {
        return corA;
    }

    public void setCorA(String corA) {
        this.corA = corA;
    }

    public String getAnoA() {
        return anoA;
    }

    public void setAnoA(String anoA) {
        this.anoA = anoA;
    }

    public String getPlacaA() {
        return placaA;
    }

    public void setPlacaA(String placaA) {
        this.placaA = placaA;
    }

    public String getNomeA() {
        return nomeA;
    }

    public void setNomeA(String nomeA) {
        this.nomeA = nomeA;
    }

    public String getCpfA() {
        return cpfA;
    }

    public void setCpfA(String cpfA) {
        this.cpfA = cpfA;
    }

    public String getTelefoneA() {
        return telefoneA;
    }

    public void setTelefoneA(String telefoneA) {
        this.telefoneA = telefoneA;
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

    @Override
    public String toString(){
        return marcaA;
    }

}
