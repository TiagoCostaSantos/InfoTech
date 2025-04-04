package br.com.infotech.controller;


import br.com.infotech.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    @GetMapping("/todos")
    public List<Produto> listarProdutos(){
        return produtos;
    }

    @PostMapping("/adicionar")
    public Produto adicionarProduto(@RequestBody Produto produto){
        produtos.add(produto);
        return produto;
    }


}
