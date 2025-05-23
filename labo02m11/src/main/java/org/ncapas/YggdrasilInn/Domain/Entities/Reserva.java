package org.ncapas.YggdrasilInn.Domain.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private boolean estado;

    @ManyToOne
    private Huesped huesped;

    @ManyToOne
    private Habitacion habitacion;

    @ManyToOne
    private SalonEvento salon;

}
