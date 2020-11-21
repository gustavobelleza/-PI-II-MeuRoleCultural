package com.pi.meurole.repository;

import com.pi.meurole.models.Evento;

import javax.sql.DataSource;
import java.util.List;

public interface IEventosRepository {
    public void setDataSource(DataSource dataSource);
    public List<Evento> BuscarEventos();
}
