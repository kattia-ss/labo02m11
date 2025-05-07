package org.ncapas.YggdrasilInn.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Empleado extends Usuario {

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false, foreignKey = @ForeignKey(name = "FK_empleado_sucursal"))
    private Sucursal sucursal;

    private String puesto;
}
