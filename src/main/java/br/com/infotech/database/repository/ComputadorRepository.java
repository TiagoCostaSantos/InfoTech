package br.com.infotech.database.repository;

import br.com.infotech.database.entity.Computador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadorRepository extends JpaRepository<Computador, Integer> {
}
