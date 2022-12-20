package com.github.ssferraz.fit_it.data.model;

import java.util.Date;

public class Reserva {

    private int id;
    private String nome;
    private Date timestamp;
    private double valor;

    public Reserva(int id, String nome, Date timestamp, double valor) {
        this.id = id;
        this.nome = nome;
        this.timestamp = timestamp;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
