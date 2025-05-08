package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.Puntos;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;
import java.util.List;

@Transactional
public interface iPuntosRepository extends iGenericRepository<Puntos, Long> {
    // JPA
    List<Puntos> findByFechaAfter(Date fecha);

    // híbrida
    @Query("SELECT p FROM Puntos p WHERE p.huesped.idUsuario = :idHuesped ORDER BY p.fecha DESC")
    List<Puntos> findByHuespedOrderByFechaDesc(@Param("idHuesped") Long idHuesped);

    // Nativa
    @Query(nativeQuery = true, value = "SELECT p.* FROM puntos p JOIN huesped h ON p.id_huesped = h.id_usuario JOIN usuario u ON h.id_usuario = u.id_usuario WHERE u.email = :email")
    List<Puntos> findByHuespedEmailNative(@Param("email") String email);
}
