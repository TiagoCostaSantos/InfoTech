package br.com.infotech.controller;


import br.com.infotech.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroContoller {

    private List<Usuario> cadastros = new ArrayList<>();

    @GetMapping("/todos")
    public List<Usuario> listarCadastros() {
        return cadastros;
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        cadastros.add(usuario);
        return usuario;
    }

}
