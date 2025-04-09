package br.com.infotech.controller;


import br.com.infotech.model.Cadastro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroContoller {

    private List<Cadastro> cadastros = new ArrayList<>();

    @GetMapping("/todos")
    public List<Cadastro> listarCadastros() {
        return cadastros;
    }

    @PostMapping("/cadastrar")
    public Cadastro cadastrarUsuario(@RequestBody Cadastro cadastro){
        cadastros.add(cadastro);
        return cadastro;
    }

}
