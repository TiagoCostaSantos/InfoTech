package br.com.infotech.controller.services;

import br.com.infotech.controller.requests.ProdutoRequest;
import br.com.infotech.controller.responses.ProdutoResponse;

import br.com.infotech.database.entity.ProdutoEntity;
import br.com.infotech.database.repository.ProdutoRepository;
import br.com.infotech.model.ProdutoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

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

        ProdutoEntity produto = new ProdutoEntity();
        produto.setDescricao(request.getDescricao());
        produto.setValor(request.getValor());
        produto.setCaracteristica(request.getCaracteristica());
        produto.setDataCadastro(request.getDataCadastro());
        produto.setGamer(request.getGamer());

        return toResponse(produtoRepository.save(produto));
    }

    public ProdutoResponse buscarPorId(Long id){
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Produto não encontrado"));
        return toResponse(produto);
    }

    public ProdutoResponse atualizar(Long id, ProdutoRequest request){
        ProdutoEntity produto = produtoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Produto não encontrado"));

        if(!produto.getCaracteristica().equals(request.getCaracteristica()) &&
                produtoRepository.existsByCaracteristica(request.getCaracteristica())){
            throw new RuntimeException("Já existe outro produto com esta caracteristicas");
        }

        produto.setDescricao(request.getDescricao());
        produto.setValor(request.getValor());
        produto.setCaracteristica(request.getCaracteristica());
        produto.setDataCadastro(request.getDataCadastro());
        produto.setGamer(request.getGamer());


        return toResponse(produtoRepository.save(produto));
    }

    private void deletar(Long id) {
        produtoRepository.deleteById(id);
    }


    private ProdutoResponse toResponse(ProdutoEntity p) {
        return new ProdutoResponse(
                p.getId(),
                p.getDescricao(),
                p.getValor(),
                p.getCaracteristica(),
                p.getDataCadastro(),
                p.getGamer());
    }
}
