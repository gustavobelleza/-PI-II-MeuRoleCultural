package com.pi.meurole.models;

import javax.persistence.*;

public class AmigoEvento {
    @Id
    @GeneratedValue
    @Column(name = "AmigoEventoId")
    private int id;

    @OneToOne
    @JoinColumn(name = "fkUsuarioEvento", referencedColumnName = "UsuarioEventoId")
    private UsuarioEvento fkUsuarioEvento;

    @OneToOne
    @JoinColumn(name = "fkAmigo", referencedColumnName = "AmigoUsuarioId")
    private Usuario fkAmigo;

    public UsuarioEvento getFkUsuarioEvento(){
        return fkUsuarioEvento;
    }

    public void setFkUsuarioEvento(UsuarioEvento usuarioEvento){
        fkUsuarioEvento = usuarioEvento;
    }


    public Usuario getFkAmigo(){
        return fkAmigo;
    }

    public void setFkAmigo(Usuario amigo){
        fkAmigo = amigo;
    }

}
