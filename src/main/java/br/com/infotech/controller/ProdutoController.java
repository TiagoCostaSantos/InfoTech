package br.com.infotech.controller;


import br.com.infotech.controller.requests.ProdutoRequest;
import br.com.infotech.model.Produto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prod" +
        "utos")
public class ProdutoController {

    //listar todos os produtos
    @GetMapping("/listar")
    public String listarProdutos(){

        return "listarProdutos";
    }

    //listar os produtos por descricao
    @GetMapping("/listar/{descricao}")
    public String listarProdutosPorDescricao(@PathVariable String descricao){

        return "listarProdutosPorDescricao";
    }

    //cadastrar novo produto
    @PostMapping("/cadastrar")
    public String adicionarProduto(@RequestBody ProdutoRequest produtoRequest){

        return "";
    }

    //atualizar um produto por Id
    @PutMapping("/atualizar/{id}")
    public String atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest){

        return "atualizarProduto";
    }

    //deletar um produto
    // modificador void não precisa de retorno
    @DeleteMapping("/excluir/{id}")
    public void deletarProduto(@PathVariable Long id){

    }
}
