package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.Piso;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface iPisoRepository extends iGenericRepository<Piso, Long> {
    // JPA
    List<Piso> findBySucursalIdSucursal(Long idSucursal);

    // JPQL
    @Query("SELECT p FROM Piso p WHERE p.nombrePiso LIKE %:nombre%")
    List<Piso> findByNombrePiso(@Param("nombre") String nombre);

    // Nativa
    @Query( nativeQuery = true, value = "SELECT * FROM piso WHERE numero = :numero")
    List<Piso> findByNumeroNative(@Param("numero") int numero);
}
