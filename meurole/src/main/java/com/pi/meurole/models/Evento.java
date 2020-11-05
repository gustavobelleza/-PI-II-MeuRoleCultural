package com.pi.meurole.models;
import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Classe modelo que representa a entidade Eventos da base de dados.
 * Participa de uma relaçao de muitos para um entre Eventos e Idealizadoes.
 * E de uma relação de um para muitos entre Eventos e UsuarioEvento
 */
@Entity
@Table(name = "Eventos")
public class Evento {

    @Id @GeneratedValue
    @Column(name = "EventoId")
    private int id;

    @Column(name = "NomeEvento")
    private String nomeEvento;

    @Column(name = "DataInicio")
    private LocalDateTime dataInicio;

    @Column(name = "DataFim")
    private LocalDateTime dataFim;

    @Column(name = "Endereco")
    private String endereco;

    @Column(name = "MaxLotacao")
    private int maxLotacao;

    @Column(name = "MinLotacao")
    private int minLotacao;

    @Column(name = "ClassificacaoEtaria")
    private int classificacaoEtaria;

    @Column(name = "Gratuito")
    private boolean gratuito;

    @Column(name = "Gratuito")

    @ManyToOne
    @JoinColumn(name = "fkIdealizador", referencedColumnName = "IdealizadorId")
    private Idealizador fkIdealizador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getMaxLotacao() {
        return maxLotacao;
    }

    public void setMaxLotacao(int maxLotacao) {
        this.maxLotacao = maxLotacao;
    }

    public int getMinLotacao() {
        return minLotacao;
    }

    public void setMinLotacao(int minLotacao) {
        this.minLotacao = minLotacao;
    }

    public int getClassificacaoEtaria() {
        return classificacaoEtaria;
    }

    public void setClassificacaoEtaria(int classificacaoEtaria) {
        this.classificacaoEtaria = classificacaoEtaria;
    }

    public boolean isGratuito() {
        return gratuito;
    }

    public void setGratuito(boolean gratuito) {
        this.gratuito = gratuito;
    }

    public Idealizador getFkIdealizador() {
        return fkIdealizador;
    }

    public void setFkIdealizador(Idealizador fkIdealizador) {
        this.fkIdealizador = fkIdealizador;
    }
}


