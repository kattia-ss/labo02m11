package org.ncapas.YggdrasilInn.Repository;

import org.ncapas.YggdrasilInn.Domain.Entities.Reserva;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import jakarta.transaction.Transactional;

@Transactional
public interface iReservaRepository extends iGenericRepository<Reserva, Long> {

    // Función derivada (JPA)
    List<Reserva> findByEstadoTrue();

    // Consulta JPQL (híbrida)
    @Query("SELECT r FROM Reserva r WHERE r.estado = true AND r.huesped.idUsuario = :idHuesped AND r.habitacion.idHabitacion = :idHabitacion")
    List<Reserva> findActivasPorHuespedYHabitacion(@Param("idHuesped") Long idHuesped,
                                                   @Param("idHabitacion") Long idHabitacion);

    // Consulta SQL nativa
    @Query(value = """
        SELECT * FROM reserva
        WHERE estado = true AND fecha_inicio >= :inicio AND fecha_fin <= :fin
    """, nativeQuery = true)
    List<Reserva> findReservasActivasEntreFechas(@Param("inicio") LocalDate inicio,
                                                 @Param("fin") LocalDate fin);
}
