package org.ncapas.YggdrasilInn.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSucursal;

    private String nombreSucursal;
    private String direccion;

    @OneToMany(mappedBy = "sucursal")
    private List<Piso> pisos;

    @OneToMany(mappedBy = "sucursal")
    private List<Empleado> empleados = new ArrayList<>();
}