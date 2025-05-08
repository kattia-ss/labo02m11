package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.Regalias;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Transactional
public interface iRegaliasRepository extends iGenericRepository<Regalias, Long> {
    // JPA
    List<Regalias> findByPuntosLessThanEqual(int puntosMaximos);

    // híbrida
    @Query("SELECT r FROM Regalias r WHERE r.nombre LIKE %:nombre% ORDER BY r.puntos ASC")
    List<Regalias> findByNombreContainingOrderByPuntosAsc(@Param("nombre") String nombre);

    // Nativa
    @Query(nativeQuery = true, value = "SELECT r.* FROM regalias r LEFT JOIN huesped h ON r.id_regalias = h.id_regalias GROUP BY r.id_regalias ORDER BY COUNT(h.id_usuario) DESC")
    List<Regalias> findMostPopularRegaliasNative();
}