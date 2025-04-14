package br.com.infotech.controller;


import org.springframework.web.bind.annotation.GetMapping;

public class EstoqueController {

    //listar todos os produtos
    @GetMapping("/listar")
    public String listarProdutos(){

        return "listarProdutos";
    }

}
