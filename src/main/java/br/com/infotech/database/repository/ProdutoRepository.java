package br.com.infotech.database.repository;

import br.com.infotech.database.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    boolean existsByCaracteristica(String caracteristica);
}
