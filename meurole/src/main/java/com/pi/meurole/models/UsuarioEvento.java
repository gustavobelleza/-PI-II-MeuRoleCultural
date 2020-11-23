package com.pi.meurole.models;

import javax.persistence.*;


/**
 * Classe modelo que implementa a relação de muitos para muitos
 * enre Usuarios e Eventos.
 */
public class UsuarioEvento {

    @Id
    @GeneratedValue
    @Column(name = "UsuarioEventoId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "fkUsuario", referencedColumnName = "UsuarioId")
    private Usuario fkUsuario;

    @ManyToOne
    @JoinColumn(name = "fkEvento", referencedColumnName = "EventoId")
    private Evento fkEvento;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public Usuario getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuario u){
        this.fkUsuario = u;
    }

    public Evento getFkEvento(){
        return fkEvento;
    }

    public void setFkEvento(Evento evento){
        this.fkEvento = evento;
    }
}
