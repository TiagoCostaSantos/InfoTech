package br.com.infotech.database.repository;

import br.com.infotech.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    boolean existsByCaracteristica(String caracteristica);
}
