package com.example.myapplication.model;

public class Alarme {

    private String nomeMedicamento;
    private String dataFinal;
    private String horarios;


    public Alarme(String nome, String data, String horarios){
        this.nomeMedicamento = nome;
        this.dataFinal = data;
        this.horarios = horarios;
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

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }
}
