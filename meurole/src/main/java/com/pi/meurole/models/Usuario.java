package com.pi.meurole.models;

import javax.persistence.*;

/**
 * Classe modelo que representa a entidade Usuarios da base de dados.
 */
@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "UsuarioId")
    private int id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @Column(name = "NoCelular")
    private String noCelular;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Idade")
    private int idade;

    @Column(name = "CPF")
    private int cpf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoCelular() {
        return noCelular;
    }

    public void setNoCelular(String noCelular) {
        this.noCelular = noCelular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}


