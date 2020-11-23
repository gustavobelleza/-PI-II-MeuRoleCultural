package com.pi.meurole.repository;

import javax.sql.DataSource;

import com.pi.meurole.models.Idealizador;
import com.pi.meurole.models.Usuario;

import org.springframework.jdbc.core.JdbcTemplate;

public class UsuarioRepository implements IUsuarioRepository
    
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Usuario BuscarUsuario(Usuario u){
        return jdbcTemplate.queryForObject(
            "SELECT * FROM Usuarios WHERE UsuarioId = ?",
            new Object[]{u.getId()}, Usuario.class);
    }

    public Idealizador buscarIdealizador(int idUsuario){
        return jdbcTemplate.queryForObject(
            "SELECT * FROM Usuarios WHERE UsuarioId = ?",
            new Object[]{idUsuario}, Idealizador.class);
    }
}
