package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.Rotacion;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Transactional
public interface iRotacionRepository extends iGenericRepository<Rotacion, Long> {
    // JPA
    List<Rotacion> findByMesAndEstadoTrue(String mes);

    // híbrida
    @Query("SELECT r FROM Rotacion r WHERE r.turno = :turno AND r.piso.idPiso = :idPiso")
    List<Rotacion> findByTurnoAndPiso(@Param("turno") String turno, @Param("idPiso") Long idPiso);

    // Nativa
    @Query(nativeQuery = true, value = "SELECT r.* FROM rotacion r JOIN empleado e ON r.id_empleado = e.id_usuario JOIN piso p ON r.id_piso = p.id_piso WHERE r.mes = :mes AND p.nombre_piso = :nombrePiso")
    List<Rotacion> findByMesAndNombrePisoNative(@Param("mes") String mes, @Param("nombrePiso") String nombrePiso);
}
