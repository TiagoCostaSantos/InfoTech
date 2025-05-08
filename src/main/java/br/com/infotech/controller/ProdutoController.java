package br.com.infotech.controller;


import br.com.infotech.controller.requests.ProdutoRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    //listar todos os produtos
    @GetMapping("/listar")
    public String listarProdutos(){

        return "listarProduto";
    }

    //listar os produtos por descricao
    @GetMapping("/listar/{descricao}")
    public String listarProdutosPorDescricao(@PathVariable String descricao){

        return "listarProdutosPorDescricao";
    }

    //cadastrar novo produto
    @PostMapping("/cadastrar")
    public String adicionarProduto(@RequestBody ProdutoRequest produtoRequest){

        return "OK";
    }

    //atualizar um produto por Id
    @PatchMapping("/atualizar/{id}")
    public String atualizarProduto(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest){

        return "atualizarProduto";
    }

    //deletar um produto
    // modificador void não precisa de retorno
    @DeleteMapping("/excluir/{id}")
    public void deletarProduto(@PathVariable Long id){

        System.out.println("delete");
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
