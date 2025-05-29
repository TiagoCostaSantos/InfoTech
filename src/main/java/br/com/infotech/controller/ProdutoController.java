package br.com.infotech.controller;

//import br.com.infotech.controller.requests.ProdutoRequest;
import br.com.infotech.model.EstoqueModel;
import br.com.infotech.model.ProdutoModel;
import br.com.infotech.usecase.produto.ProdutoUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    public ProdutoController(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastroP(@RequestParam(required = false) String uuid, Model model) {

        if(Objects.nonNull(uuid)){
            var produto = produtoUseCase.buscarProduto(uuid);
            model.addAttribute("produto", produto);
        } else {
            model.addAttribute("produto", new ProdutoModel());
        }
        return "criar-produto";
    }

    @GetMapping("/success1")
    public String mostrarFormularioCadastroP() {
        return "success1";
    }

    // Cadastrar um novo produto
    @PostMapping("/salvar")
    public String cadastrarProduto(@ModelAttribute ProdutoModel produtoModel
    ) {
        produtoUseCase.cadastrarProduto(produtoModel);
        return "redirect:/produtos/success1";
    }

    @GetMapping("/listagem")
    public String listarProdutos(Model model) {
        var produtos = produtoUseCase.listarTodos(); //lista//
        model.addAttribute("produtos", produtos);
        return "listar-produtos";
    }

}
