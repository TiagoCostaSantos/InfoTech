package br.com.infotech.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CaracteristicaController {

    //listar todos os produtos
    @GetMapping("/listar")
    public String listarProdutos(){

        return "listarProdutos";
    }

}

//get all
///get uuid
//post
//update