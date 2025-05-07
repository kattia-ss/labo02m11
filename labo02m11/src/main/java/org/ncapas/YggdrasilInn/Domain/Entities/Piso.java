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
public class Piso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPiso;

    private int numero;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false, foreignKey = @ForeignKey(name = "FK_piso_sucursal"))
    private Sucursal sucursal;

    @OneToMany(mappedBy = "piso")
    private List<Habitacion> habitaciones = new ArrayList<>();

    @OneToMany(mappedBy = "piso")
    private List<BotonAscensor> botones = new ArrayList<>();
}
