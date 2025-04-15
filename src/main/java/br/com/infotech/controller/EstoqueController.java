package br.com.infotech.controller;


import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    //listar todos estoques
    @GetMapping("/listar")
    public String listarEstoque(){

        return "listarEstoque";
    }

    //listar todos estoques por id
    @GetMapping("/listar/{id}")
    public String listarEstoquePorId(){

        return "listarEstoquePorId";
    }

    //atualizar por id
    @PatchMapping("/atualizar/{id}") //deveria ser por UUID
    public String atualizarEstoque(@PathVariable Long id){

        return "atualizarEstoque";
    }

}
