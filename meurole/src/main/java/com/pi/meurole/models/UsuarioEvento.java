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
    private Usuario fkEvento;
}
