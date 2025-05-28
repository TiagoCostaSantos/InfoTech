package br.com.infotech.controller;

//import br.com.infotech.controller.requests.ProdutoRequest;
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
            ProdutoModel pm = new ProdutoModel();
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
        //TODO: uuid is null ? entao CADASTRAR NOVO, se nao
        //TODO: Buscar o produto por esse UUID e utilizar o ID para fazer o UPDATE
        if(Objects.isNull(produtoModel.getUuid())){
            produtoModel.setDataCadastro(LocalDate.now());
            produtoModel.setUuid(UUID.randomUUID().toString());
            produtoUseCase.cadastrarProduto(produtoModel);
        }
        var pmDatabase = produtoUseCase.buscarProduto(produtoModel.getUuid());
        ProdutoModel pm = new ProdutoModel();
        pm.setId(pmDatabase.getId());
        pm.setUuid(produtoModel.getUuid());

        pm.setValor(produtoModel.getValor());
        pm.setDescricao(produtoModel.getDescricao());
        pm.setQtdEstoque(produtoModel.getQtdEstoque());
        pm.setDataCadastro(pmDatabase.getDataCadastro());
        produtoUseCase.cadastrarProduto(pm);

        return "redirect:/produtos/success1";
    }

    @GetMapping("/listagem")
    public String listarProdutos(Model model) {
        var produtos = produtoUseCase.listarTodos(); //lista//
        model.addAttribute("produtos", produtos);
        return "listar-produtos";
    }

}
