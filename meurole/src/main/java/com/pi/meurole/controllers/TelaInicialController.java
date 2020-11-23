package com.pi.meurole.controllers;

import com.pi.meurole.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String home(Model model, HttpSession httpSession){

        var authUser = (Usuario) httpSession.getAttribute("authUser");

        model.addAttribute("authUser", authUser);

        return "home";
    }
}
