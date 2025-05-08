package org.ncapas.YggdrasilInn.Repositories;

import org.ncapas.YggdrasilInn.Domain.Entities.ComprobantePago;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

@Transactional
public interface iComprobantePagoRepository extends iGenericRepository<ComprobantePago, Long> {
    // JPA
    List<ComprobantePago> findByTotalGreaterThan(double montoMinimo);

    // híbrida
    @Query("SELECT cp FROM ComprobantePago cp WHERE cp.fechaEmision = :fecha")
    List<ComprobantePago> findByFechaEmision(@Param("fecha") LocalDate fecha);

    // Nativa
    @Query(nativeQuery = true, value = "SELECT * FROM comprobante_pago cp JOIN reserva r ON cp.id_reserva = r.id_reserva WHERE r.id_huesped = :idHuesped ")
    List<ComprobantePago> findByHuespedNative(@Param("idHuesped") Long idHuesped);
}