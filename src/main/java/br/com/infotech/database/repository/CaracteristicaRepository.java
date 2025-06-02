package br.com.infotech.database.repository;

import br.com.infotech.database.entity.CaracteristicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CaracteristicaRepository extends JpaRepository<CaracteristicaEntity, Long> {

    Optional<CaracteristicaEntity> findByUuid(String uuid);

}
