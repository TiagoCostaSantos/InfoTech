package br.com.infotech.controller.services;

import br.com.infotech.controller.requests.ProdutoRequest;
import br.com.infotech.controller.responses.ProdutoResponse;
import br.com.infotech.database.repository.ProdutoRepository;
import br.com.infotech.model.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoResponse> listar(){
        return produtoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public ProdutoResponse salvar(ProdutoRequest request){
        if (produtoRepository.existsByCaracteristica(request.getCaracteristica())){
            throw new RuntimeException("Já existe um produto com esta caracteristica");
        }

        ProdutoModel produto = new ProdutoModel();
        produto.setDescricao(request.getDescricao());
        produto.setValor(request.getValor());
        produto.setCaracteristica(request.getCaracteristica());
        produto.setData_cadastro(request.getDataCadastro());
        produto.setGamer(request.getGamer());
        produto.setFoto(String.valueOf(request.getFoto()));

        return toResponse(produtoRepository.save(produto));
    }



    private ProdutoResponse toResponse(ProdutoModel p) {
        return new ProdutoResponse(
                p.getId(),
                p.getDescricao(),
                p.getValor(),
                p.getCaracteristica(),
                p.getData_cadastro(),
                p.getGamer(),
                p.getFoto()
        );
    }
}
