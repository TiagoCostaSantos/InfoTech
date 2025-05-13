package br.com.infotech.controller;


import br.com.infotech.controller.requests.ProdutoRequest;
import br.com.infotech.model.ProdutoModel;
import br.com.infotech.model.Usuario;
import br.com.infotech.usecase.produto.ProdutoUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    public ProdutoController(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastroP(Model model) {
        model.addAttribute("produto", new ProdutoModel());
        return "criar-produto";
    }

    @GetMapping("/success1")
    public String mostrarFormularioCadastroP() {
        return "success1";
    }


    // Cadastrar um novo produto
    @PostMapping("/salvar")
    public String cadastrarProduto(@ModelAttribute ProdutoModel produtoModel) {
        produtoModel.setDataCadastro(LocalDate.now());
        produtoUseCase.cadastrarProduto(produtoModel);
        return "redirect:/produtos/success1";
    }
}

//create - POST
//read - get
//update - put ou patch
//put - todos os campos necessários
//patch - somente o campo a ser atualizado
//delete - detele

//private UUID produtoId; // ID do produto,
// representado como UUID
//
//private UUID foreignKeyId; //
// FK representada como UUID
