package br.com.infotech.database.repository;

import br.com.infotech.database.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    Optional<ProdutoEntity> findByUuid(String uuid);
}
