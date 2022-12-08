package com.example.myapplication.model;

public class Alarme {
    private Integer id;
    private String nomeMedicamento;
    private String dataFinal;
    private String horarioSelecionado;
    private int frequancia;

    public Alarme() {

    }

    public Alarme(String nome, String data, String horarioSelecionado, int frequancia) {
        this.nomeMedicamento = nome;
        this.dataFinal = data;
        this.horarioSelecionado = horarioSelecionado;
        frequancia = frequancia;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getHorarioSelecionado() {
        return horarioSelecionado;
    }

    public void setHorarioSelecionado(String horarioSelecionado) {
        this.horarioSelecionado = horarioSelecionado;
    }

    public int getFrequancia() {
        return frequancia;
    }

    public void setFrequancia(int frequancia) {
        this.frequancia = frequancia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
