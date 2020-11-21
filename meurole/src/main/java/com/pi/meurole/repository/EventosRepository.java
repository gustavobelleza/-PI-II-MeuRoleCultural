package com.pi.meurole.repository;

import com.pi.meurole.models.Evento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
