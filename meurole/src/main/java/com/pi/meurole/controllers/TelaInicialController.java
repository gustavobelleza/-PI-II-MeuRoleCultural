package com.pi.meurole.controllers;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpSession;


/**
 * Classe controller responsável por apresentar e processar
 * dados relativos à tela inicial.
 */
@Controller
@RequestMapping("/")
public class TelaInicialController {

    /**
     * Verifica se o usuario já está logado. Apresenta uma tela
     * de acordo com estado do usuario.
     * @param httpSession dados da sessão nos quais sao persistidos temporiariamente
     *                    dados do usuario logdo.
     * @return tela a ser apresentada.
     */
    @GetMapping
    public ModelAndView home(HttpSession httpSession){
        return new ModelAndView("home");
    }

    /**
     * Processa os dados dos eventos a serem buscados e redireciona o
     * usuario para a tela de apresentação de eventos
     * @param model dados dos eventos a serem apresentados
     * @return controller para o qual será redirecionado.
     */
    @PostMapping("encontrarEventos")
    public String encontrarEventos(Model model){
        return "redirect:eventosDisponiveis";
    }

}
