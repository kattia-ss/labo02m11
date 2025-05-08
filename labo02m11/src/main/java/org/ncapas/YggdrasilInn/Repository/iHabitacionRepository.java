package org.ncapas.YggdrasilInn.Repository;

import org.ncapas.YggdrasilInn.Domain.Entities.Habitacion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface iHabitacionRepository extends iGenericRepository<Habitacion, Long> {
    // JPA
    List<Habitacion> findByNombreHabitacionContaining(String nombreHabitacion);

    // JPQL
    @Query("SELECT h FROM Habitacion h WHERE h.descripcion LIKE %:descripcion%")
    List<Habitacion> findByDescripcion(@Param("descripcion") String descripcion);

    // Nativa
    @Query( nativeQuery = true, value = "SELECT * FROM habitacion WHERE id_piso = :idPiso")
    List<Habitacion> findByPisoNative(@Param("idPiso") Long idPiso);
}
