package br.com.infotech.controller;

import br.com.infotech.model.Cadastro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class InicioController {

    @GetMapping("/")
    public String AbrirHome(){
        return "index";
    }

    @GetMapping("/cadastrar")
    public String cadastrarUsuario(){

        return "cadastro";
    }

    @GetMapping("/cadastrar-produto")
    public String AbrirCadastroProduto(){
        return "criar-produto";
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
