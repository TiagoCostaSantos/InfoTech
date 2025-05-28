package br.com.infotech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String AbrirHome(){
        return "index";
    }

    @GetMapping("/listar-produto")
    public String AbrirListagemProduto(){
        return "listar-produtos";
    }

    @GetMapping("/cadastro")
    public String CadastrarPessoa(){
        return "cadastro";
    }
}
