package com.pi.meurole.models;

import org.hibernate.mapping.UnionSubclass;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Classe modelo que repsenta a classe Idealizadores - usuarios que podem
 * criar novos eventos.
 * Participa de uma relação de um para muitos entre Idealizadores e Eventos.
 * E de uma relação de um para um com Usuarios.
 */
@Entity
@Table(name = "Idealizadores")
public class Idealizador {

    @Id
    @GeneratedValue
    @Column(name = "IdealizadorId")
    private int id;

    @Column(name = "Email")
    private String email;

    @Column(name = "NoCelular")
    private String noCelular;

    @Column(name = "CNPJ")
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "fkUsuario", referencedColumnName = "UsuarioId")
    private Usuario fkUsuario;

}
