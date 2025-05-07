package br.com.infotech.controller;


import br.com.infotech.database.entity.Usuario;
import br.com.infotech.database.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TesteController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/teste")
    public void teste() {
        Usuario usuario = new Usuario();
        usuario.setNome("Tiago");
        usuario.setGmail("tiago@gmail.com");
        usuario.setSenha("1234");

        usuarioRepository.save(usuario);

    }
}
