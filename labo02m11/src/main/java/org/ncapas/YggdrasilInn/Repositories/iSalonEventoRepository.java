package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.SalonEvento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface iSalonEventoRepository extends iGenericRepository<SalonEvento, Long> {
    // JPA
    List<SalonEvento> findByCapacidadGreaterThan(int capacidad);

    // JPQL
    @Query("SELECT s FROM SalonEvento s WHERE s.ornamentos LIKE %:ornamentos%")
    List<SalonEvento> findByOrnamentos(@Param("ornamentos") String ornamentos);

    // Nativa
    @Query( nativeQuery = true, value = "SELECT * FROM salon_evento WHERE nombre_salon = :nombre")
    List<SalonEvento> findByNombreSalonNative(@Param("nombre") String nombre);
}
