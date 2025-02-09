package com.produtos.entity;

import java.io.Serializable;

public class Cliente implements Identifiable, Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String nome;
    private String email;
    
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
