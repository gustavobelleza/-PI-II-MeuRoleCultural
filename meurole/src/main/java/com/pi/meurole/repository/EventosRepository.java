package com.pi.meurole.repository;

import com.pi.meurole.models.AmigoEvento;
import com.pi.meurole.models.Evento;
import com.pi.meurole.models.UsuarioEvento;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import aj.org.objectweb.asm.Type;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Repository
public class EventosRepository implements IEventosRepository{

    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Evento> BuscarEventos() {
        List<Evento> eventos = new ArrayList<>();
        var rows = jdbcTemplate.queryForList(
                "SELECT * FROM Eventos", new Evento());

        for (var row : rows){
            var evento = new Evento();
            evento.setId((int)row.get("id"));
            evento.setClassificacaoEtaria((int)row.get("classificacaoEtaria"));
            evento.setDataFim((LocalDateTime) row.get("dataFim"));
            evento.setDataInicio((LocalDateTime) row.get("dataInicio"));
            evento.setEndereco((String) row.get("endereco"));
            evento.setGratuito((boolean) row.get("gratuito"));
            eventos.add(evento);
        }
        return eventos;
    }

    public void Criar(Evento evento){
        jdbcTemplate.update(
            "INSERT INTO Eventos " + 
            "(EventoId, NomeEvento, DataInicio, DataFim, Endereco, MaxLotacao, " +
            "MinLotacao, ClassificacaoEtaria, Gratuito, IdealizadorId) " + 
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
            new Object[]{evento.getId(), evento.getNomeEvento(), evento.getDataInicio(), evento.getDataFim(),
                evento.getEndereco(), evento.getMaxLotacao(), evento.getMinLotacao(), evento.getClassificacaoEtaria(),
                evento.isGratuito(), evento.getFkIdealizador());
    }

    @Override
    public void Criar(AmigoEvento amigoEvento){
        jdbcTemplate.update(
            "INSERT INTO AmigoEvento (UsuarioEventoId, AmigoUsuarioId) VALUES (?, ?)", 
            new Object[]{amigoEvento.getFkUsuarioEvento(), amigoEvento.getFkAmigo()});
    }

    public UsuarioEvento BuscarUsuarioEvento(int idUsuario, int idEvento){
        return jdbcTemplate.queryForObject(
            "SELECT * FROM UsuarioEvento WHERE UsuarioId = ? AND EventoId == ?",
             new Object[] {idUsuario, idEvento}, UsuarioEvento.class);
    }

}
