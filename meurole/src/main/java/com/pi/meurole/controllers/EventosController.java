package com.pi.meurole.controllers;

import com.pi.meurole.exceptions.ForbbidenAccessError;
import com.pi.meurole.models.AmigoEvento;
import com.pi.meurole.models.Evento;
import com.pi.meurole.models.Idealizador;
import com.pi.meurole.models.Usuario;
import com.pi.meurole.repository.EventosRepository;
import com.pi.meurole.repository.IEventosRepository;
import com.pi.meurole.repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Classe controller responsável por apresentar e processar
 * dados relativos aos eventos.
 */
@Controller
@RequestMapping("eventos")
public class EventosController {

    @Autowired
    private final IEventosRepository eventosRepository;


    @Autowired
    private final IUsuarioRepository usuarioRepository;
    
    public EventosController(IEventosRepository eventosRepository, IUsuarioRepository usuarioRepository)
        this.eventosRepository = eventosRepository;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Apresenta os eventos de acordo com os dados selecionados pelo
     * usuario.
     * @param model dados dos eventos a serem apresentados
     * @return dados e tela a serem apresentados
     */
    @GetMapping("eventosDisponiveis")
    public ModelAndView eventosDisponiveis(Model model){

        var eventos = eventosRepository.BuscarEventos();
        model.addAttribute("eventos", eventos);

        return new ModelAndView("eventosDisponiveis");
    }

    /**
     * Processa os dados dos amigos a serem convidados. Redireciona o
     * usuario para eventos disponiveis.
     * @param usuarios lista de amigos a serem convidados.
     * @param evento evento para o convite está sendo realizado
     * @return
     */
    @PostMapping("convidarAmigos")
    public String convidarAmigos(List<Usuario> usuarios, Evento evento, HttpSession session){

        var authUser = (Usuario) session.getAttribute("authUser");
        var usuarioEvento = eventosRepository
            .BuscarUsuarioEvento(authUser.getId(), evento.getId());

        for (var usuario : usuarios){

            var amigoEvento = new AmigoEvento();

            amigoEvento.setFkUsuarioEvento(usuarioEvento);
            amigoEvento.setFkAmigo(usuario);

            eventosRepository.Criar(amigoEvento);
        }

        return "redirect:eventosDisponiveis";
    }

    /**
     * Apresenta a tela de criação de eventos.
     * @param httpSession dados do usuario armazenados na sessao.
     * @return tela e dados para criação de eventos.
     */
    @GetMapping("criarEvento")
    public String criarEvento(HttpSession httpSession){
        return "criarEvento";
    }

    /**
     * Processa os dados do evento criado e armazena no banco
     * de dados
     * @param evento dados o evento.
     * @return redireciona para tela inicial
     */
    @PostMapping("criarEvento")
    public String criarEvento(Evento evento, HttpSession session){
        var authUser = (Usuario) session.getAttribute("authUser");

        var idealizador = usuarioRepository.BuscarIdealizador(authUser.getId());

        if (idealizador == null){
            throw new ForbbidenAccessError();
        }

        if (evento != null){

            eventosRepository.Criar(evento);
        }

        return "redirect:/";
    }
}
