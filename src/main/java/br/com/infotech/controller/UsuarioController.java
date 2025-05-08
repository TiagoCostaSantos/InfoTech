package br.com.infotech.controller;

import br.com.infotech.database.entity.User;
import br.com.infotech.database.repository.UserRepository;
import br.com.infotech.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;

//    @GetMapping("/registrar")
//    public String CadastrarPessoa(){
//        return "cadastro";
//    }

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
        User user = new User();
        user.setUser(usuario.getNome());
        user.setGmail(usuario.getEmail());
        user.setSenha(usuario.getSenha());
        userRepository.save(user);
        return "redirect:/usuario/success";
    }

}




