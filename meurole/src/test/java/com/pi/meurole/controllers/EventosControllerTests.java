package com.pi.meurole.controllers;

import com.pi.meurole.StubModel;
import com.pi.meurole.models.AmigoEvento;
import com.pi.meurole.models.Evento;
import com.pi.meurole.models.Usuario;
import com.pi.meurole.models.UsuarioEvento;
import com.pi.meurole.repository.EventosRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EventosControllerTests {

    @Autowired
    private EventosController controller;

    @MockBean
    DataSource dataSource;

    @MockBean(answer = Answers.RETURNS_SMART_NULLS)
    EventosRepository eventosRepository;

    @Autowired
    HttpSession session;

    @Before
    public void before(){
        controller = new EventosController(eventosRepository);
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void encontrarEventos_eventosExistem_modelAddEventos(){
        // Arrange
        doReturn(mockEventos()).when(eventosRepository).BuscarEventos();
        StubModel stubModel = new StubModel();

        // Act
        controller.eventosDisponiveis(stubModel);

        // Assert
        List<Evento> modelEventos = (List<Evento>) stubModel.getAttribute("eventos");

        Assert.assertNotNull(modelEventos);
        Assert.assertEquals(mockEventos().toArray().length, modelEventos.toArray().length);

        verify(eventosRepository, times(1)).BuscarEventos();
    }

    @Test
    public void convidarAmigos_amigosExistem_amigosConvidados(){

        // Arrange
        var authUser = new Usuario();
        authUser.setId(990);
        authUser.setUsername("usuarioAutorizado");
        session.setAttribute("authUser", authUser);

        Evento evento = new Evento();
        evento.setId(991);
        evento.setNomeEvento("Um Evento");

        var amigos = mockUsuarios();

        var eventoUsuario = new UsuarioEvento();
        eventoUsuario.setFkUsuario(authUser);
        eventoUsuario.setFkEvento(evento);

        doReturn(eventoUsuario)
            .when(eventosRepository)
            .BuscarUsuarioEvento(authUser.getId(), evento.getId());

        // Act
        controller.convidarAmigos(amigos, evento, session);

        // Assert
        verify(eventosRepository, times(1))
            .BuscarUsuarioEvento(authUser.getId(), evento.getId());

        verify(eventosRepository, times(3))
            .Criar(any(AmigoEvento.class));

    }

    private List<Usuario> mockUsuarios(){
        var usuarios = new ArrayList<Usuario>();

        var amigo1 = new Usuario();
        amigo1.setId(992);
        amigo1.setUsername("amigo1");

        var amigo2 = new Usuario();
        amigo1.setId(993);
        amigo1.setUsername("amigo2");
      
        var amigo3 = new Usuario();
        amigo1.setId(993);
        amigo1.setUsername("amigo3");
        
        usuarios.add(amigo1);
        usuarios.add(amigo2);
        usuarios.add(amigo3);
        
        return usuarios;
    } 

    private List<Evento> mockEventos(){
        var eventos = new ArrayList<Evento>();

        var evento = new Evento();
        evento.setId(1);
        evento.setNomeEvento("evento1");
        eventos.add(evento);

        evento = new Evento();
        evento.setId(2);
        evento.setNomeEvento("evento2");
        eventos.add(evento);

        evento = new Evento();
        evento.setId(3);
        evento.setNomeEvento("evento3");
        eventos.add(evento);

        return eventos;
    }
}
