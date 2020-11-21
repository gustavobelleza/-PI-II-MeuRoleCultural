package com.pi.meurole.controllers;

import com.pi.meurole.models.Usuario;
import com.pi.meurole.repository.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/**
 * Classe controller responsável por apresentar e processar
 * dados relativos à tela inicial.
 */
@Controller
@RequestMapping("/")
public class TelaInicialController {

    @Autowired
    private final EventosRepository eventosRepository;

    public TelaInicialController(EventosRepository eventosRepository){
        this.eventosRepository = eventosRepository;
    }

    /**
     * Verifica se o usuario já está logado. Apresenta uma tela
     * de acordo com estado do usuario.
     * @param httpSession dados da sessão nos quais sao persistidos temporiariamente
     *                    dados do usuario logdo.
     * @return tela a ser apresentada.
     */
    @GetMapping
    public String home(Model model, HttpSession httpSession){

        var authUser = (Usuario) httpSession.getAttribute("authUser");

        model.addAttribute("authUser", authUser);

        return "home";
    }

    /**
     * Processa os dados dos eventos a serem buscados e redireciona o
     * usuario para a tela de apresentação de eventos
     * @param model dados dos eventos a serem apresentados
     * @return controller para o qual será redirecionado.
     */
    @GetMapping("encontrarEventos")
    public ModelAndView encontrarEventos(Model model){

        var eventos = eventosRepository.BuscarEventos();
        model.addAttribute("eventos", eventos);

        return new ModelAndView("eventosDisponiveis", model.asMap());
    }

}
