package com.github.ssferraz.fit_it.data.model;

public class Paciente {
    private int id;
    private String nome;
    private String cidade;
    private String telefone;
    private String email;
    private String senha;

    public Paciente(String nome, String cidade, String telefone, String email, String senha) {
        this.nome = nome;
        this.cidade = cidade;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Paciente(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
