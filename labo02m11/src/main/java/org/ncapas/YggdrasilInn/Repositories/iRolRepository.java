package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.Rol;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Transactional
public interface iRolRepository extends iGenericRepository<Rol, Long> {
    // JPA
    Rol findByNombreRolIgnoreCase(String nombreRol);

    // híbrida
    @Query("SELECT r FROM Rol r WHERE SIZE(r.usuarios) > :cantidad")
    List<Rol> findByUsuariosCountGreaterThan(@Param("cantidad") int cantidad);

    // Nativa
    @Query(nativeQuery = true, value = "SELECT r.* FROM rol r JOIN usuario u ON r.id_rol = u.id_rol GROUP BY r.id_rol HAVING COUNT(u.id_usuario) > 0")
    List<Rol> findRolesConUsuariosNative();
}
