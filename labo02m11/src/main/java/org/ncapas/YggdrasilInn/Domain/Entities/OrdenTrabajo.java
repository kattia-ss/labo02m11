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
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdenTrabajo;

    private String descripcion;
    private LocalDate fecha;

    //quien lo informo
    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false, foreignKey = @ForeignKey(name = "FK_orden_trabajo_empleado"))
    private Empleado empleado;


    @ManyToOne
    @JoinColumn(name = "id_habitacion", nullable = false, foreignKey = @ForeignKey(name = "FK_orden_trabajo_habitacion"))
    private Habitacion habitacion;

}