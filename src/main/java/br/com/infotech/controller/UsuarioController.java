package br.com.infotech.controller;

import br.com.infotech.model.Usuario;
import br.com.infotech.usecase.UsuarioUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
       model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @GetMapping("/success")
    public String mostrarPaginaSucesso() {
        return "success";
    }

    // Cadastrar um novo usuário
    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        Usuario user = new Usuario();
        user.setNome(usuario.getNome());
        user.setEmail(usuario.getEmail());
        user.setSenha(usuario.getSenha());
        usuarioUseCase.cadastrarUsuario(user);
        return "redirect:/usuario/success";
    }

}




