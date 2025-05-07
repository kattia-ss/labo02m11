package org.ncapas.YggdrasilInn.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComprobantePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComprobante;

    private LocalDate fechaEmision;
    private double total;

    @OneToOne
    @JoinColumn(name = "id_reserva", nullable = false, foreignKey = @ForeignKey(name = "FK_pago_reserva"))
    private Reserva reserva;
}
