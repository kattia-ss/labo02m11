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


public class Rotacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRotacion;

    private String turno;
    private String mes;
    private String horario;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false, foreignKey = @ForeignKey(name = "FK_rotacion_empleado"))
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name = "id_piso", nullable = false, foreignKey = @ForeignKey(name = "FK_rotacion_piso"))
    private Piso piso;
}
