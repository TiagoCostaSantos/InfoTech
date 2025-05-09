package br.com.infotech.database.repository;

import br.com.infotech.database.entity.ComputadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadorRepository extends JpaRepository<ComputadorEntity, Integer> {
}
