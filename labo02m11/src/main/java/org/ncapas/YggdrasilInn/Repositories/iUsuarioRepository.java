package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

@Transactional
public interface iUsuarioRepository extends iGenericRepository<Usuario, Long> {
    // JPA
    Usuario findByEmailIgnoreCase(String email);

    // híbrida
    @Query("SELECT u FROM Usuario u WHERE u.fechaNacimiento BETWEEN :inicio AND :fin")
    List<Usuario> findByFechaNacimientoBetween(@Param("inicio") LocalDate inicio, @Param("fin") LocalDate fin);

    // Nativa
    @Query(nativeQuery = true, value = "SELECT u.* FROM usuario u JOIN rol r ON u.id_rol = r.id_rol WHERE r.nombre_rol = :nombreRol")
    List<Usuario> findByRolNative(@Param("nombreRol") String nombreRol);
}
