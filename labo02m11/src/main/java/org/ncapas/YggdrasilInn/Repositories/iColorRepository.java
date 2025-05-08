package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.Color;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface iColorRepository extends iGenericRepository<Color, Long> {
    // JPA
    List<Color> findByTonoIgnoreCase(String tono);

    // JPQL
    @Query("SELECT c FROM Color c WHERE c.hexadecimal = :hex")
    List<Color> findByHexadecimal(@Param("hex") String hex);

    // Nativa
    @Query( nativeQuery = true, value = "SELECT * FROM color WHERE id_piso = :idPiso")
    List<Color> findByPisoNative(@Param("idPiso") Long idPiso);
}

