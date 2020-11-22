package com.pi.meurole.models;

import javax.persistence.*;

public class AmigoUsuario {

    @Id
    @GeneratedValue
    @Column(name = "AmigoUsuarioId")
    private int id;

    @OneToOne
    @JoinColumn(name = "fkUsuario", referencedColumnName = "UsuarioId")
    private Usuario fkUsuario;

    @OneToOne
    @JoinColumn(name = "fkAmigo", referencedColumnName = "UsuarioId")
    private Usuario fkAmigo;
}
