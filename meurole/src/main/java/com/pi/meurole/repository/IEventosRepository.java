package com.pi.meurole.repository;

import com.pi.meurole.models.AmigoEvento;
import com.pi.meurole.models.Evento;
import com.pi.meurole.models.UsuarioEvento;

import javax.sql.DataSource;
import java.util.List;

public interface IEventosRepository {
    public void setDataSource(DataSource dataSource);
    public List<Evento> BuscarEventos();
    public void Criar(AmigoEvento amigoEvento);
    public UsuarioEvento BuscarUsuarioEvento(int idUsuario, int idEvento);
    public void Criar(Evento evento);
}
