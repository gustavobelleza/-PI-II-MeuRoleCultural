package com.pi.meurole.repository;

import javax.sql.DataSource;

import com.pi.meurole.models.Idealizador;
import com.pi.meurole.models.Usuario;

public interface IUsuarioRepository {
    public void setDataSource(DataSource dataSource);
    public Usuario BuscarUsuario(Usuario u);
    public Idealizador BuscarIdealizador(int idUsuario);

}
