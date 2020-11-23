package com.pi.meurole.controllers;
import com.pi.meurole.StubModel;
import com.pi.meurole.models.Usuario;
import com.pi.meurole.repository.EventosRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TelaInicialControllerTests {

    @Autowired
    private TelaInicialController controller;

    @MockBean
    DataSource dataSource;

    @Before
    public void before(){
        controller = new TelaInicialController();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void home_userLogged_sessionHasAuthUser(){

        // Arrange
        HttpSession session = new MockHttpSession();

        Usuario usuario = new Usuario();

        usuario.setId(1);
        usuario.setNome("Fulano");
        usuario.setNome("NomeUsuario");
        usuario.setPassword("332211");

        session.setAttribute("authUser", usuario);

        StubModel stubModel = new StubModel();

        // Act
        controller.home(stubModel, session);

        // Assert
        Usuario modelUser = (Usuario) stubModel.getAttribute("authUser");
        assertNotNull(modelUser);
        assertEquals(modelUser.getNome(), usuario.getNome());
        assertEquals(modelUser.getUsername(), usuario.getUsername());
        assertEquals(modelUser.getPassword(), usuario.getPassword());
    }
}
