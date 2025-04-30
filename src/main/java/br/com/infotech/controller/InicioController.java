package br.com.infotech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String AbrirHome(){
        return "index";
    }

    @GetMapping("/cadastrar-produto")
    public String AbrirCadastroProduto(){
        return "criar-produto";
    }

    @GetMapping("/listar-produto")
    public String AbrirListagemProduto(){
        return "listar-produtos";
    }
}
