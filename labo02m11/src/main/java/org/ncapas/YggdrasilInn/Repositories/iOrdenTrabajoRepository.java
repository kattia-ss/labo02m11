package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.OrdenTrabajo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import jakarta.transaction.Transactional;

@Transactional
public interface iOrdenTrabajoRepository extends iGenericRepository<OrdenTrabajo, Long> {
    // JPA
    List<OrdenTrabajo> findByEmpleadoIdUsuario(Long idEmpleado);

    // híbrida
    @Query("SELECT o FROM OrdenTrabajo o WHERE o.fecha = :fecha AND o.empleado.sucursal.nombreSucursal = :nombreSucursal")
    List<OrdenTrabajo> findPorFechaYSucursal(@Param("fecha") LocalDate fecha,
                                             @Param("nombreSucursal") String nombreSucursal);

    // nativa
    @Query(value = """
        SELECT ot.* FROM orden_trabajo ot
        JOIN habitacion h ON ot.id_habitacion = h.id
        JOIN piso p ON h.id_piso = p.id
        WHERE ot.fecha = :fecha AND p.id = :idPiso
    """, nativeQuery = true)
    List<OrdenTrabajo> findPorFechaYPiso(@Param("fecha") LocalDate fecha,
                                         @Param("idPiso") Long idPiso);

}
