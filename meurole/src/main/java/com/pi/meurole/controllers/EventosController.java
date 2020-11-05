package com.pi.meurole.controllers;

import com.pi.meurole.models.Usuario;
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

    /**
     * Apresenta os eventos de acordo com os dados selecionados pelo
     * usuario.
     * @param model dados dos eventos a serem apresentados
     * @return dados e tela a serem apresentados
     */
    @GetMapping("eventosDisponiveis")
    public ModelAndView eventosDisponiveis(Model model){
        return new ModelAndView("eventosDisponiveis");
    }

    /**
     * Processa os dados dos amigos a serem convidados. Redireciona o
     * usuario para eventos disponiveis.
     * @param model lista de amigos a serem convidados.
     * @return
     */
    @PostMapping("convidarAmigos")
    public String convidarAmigos(List<Usuario> model){
        return "redirect:eventosDisponiveis";
    }

    /**
     * Apresenta a tela de criação de eventos.
     * @param httpSession dados do usuario armazenados na sessao.
     * @return tela e dados para criação de eventos.
     */
    @GetMapping("criarEvento")
    public ModelAndView criarEvento(HttpSession httpSession){
        return new ModelAndView("criarEvento");
    }

    /**
     * Processa os dados do evento criado e armazena no banco
     * de dados
     * @param model dados o evento.
     * @return redireciona para tela inicial
     */
    @PostMapping("criarEvento")
    public String criarEvento(){
        return "redirect:/";
    }
}
