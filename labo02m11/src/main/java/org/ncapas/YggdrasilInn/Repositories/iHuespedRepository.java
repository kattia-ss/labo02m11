package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.Huesped;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Transactional
public interface iHuespedRepository extends iGenericRepository<Huesped, Long> {
    // JPA
    List<Huesped> findByRegaliasNombre(String nombreRegalia);

    // híbrida
    @Query("SELECT h FROM Huesped h WHERE SIZE(h.puntos) > :cantidad")
    List<Huesped> findByPuntosCountGreaterThan(@Param("cantidad") int cantidad);

    // Nativa
    @Query(nativeQuery = true, value = "SELECT h.* FROM huesped h JOIN usuario u ON h.id_usuario = u.id_usuario WHERE u.email LIKE :dominio ")
    List<Huesped> findByEmailDominioNative(@Param("dominio") String dominio);
}
