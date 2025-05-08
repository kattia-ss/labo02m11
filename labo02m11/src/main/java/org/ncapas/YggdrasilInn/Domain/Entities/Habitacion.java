package org.ncapas.YggdrasilInn.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;

    private String nombreHabitacion;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_detalle", nullable = false, foreignKey = @ForeignKey(name = "FK_ID_DETALLE"))
    private Detalle detalle;

    @OneToMany(mappedBy = "habitacion")
    private List<OrdenTrabajo> ordenes;

    @OneToMany(mappedBy = "habitacion")
    private List<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name = "id_piso", nullable = false, foreignKey = @ForeignKey(name = "FK_ID_PISO"))
    private Piso piso;
}

