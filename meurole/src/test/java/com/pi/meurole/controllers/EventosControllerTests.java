package com.pi.meurole.controllers;

import com.pi.meurole.StubModel;
import com.pi.meurole.models.Evento;
import com.pi.meurole.models.Usuario;
import com.pi.meurole.repository.EventosRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
        var response = controller.eventosDisponiveis(stubModel);

        // Assert
        List<Evento> modelEventos = (ArrayList) stubModel.getAttribute("eventos");
        Assert.assertNotNull(modelEventos);
        Assert.assertEquals(mockEventos().toArray().length, modelEventos.toArray().length);
        verify(eventosRepository, times(1)).BuscarEventos();
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
