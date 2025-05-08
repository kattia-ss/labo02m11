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

    private String nombrePiso;
    private int numero;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false, foreignKey = @ForeignKey(name = "FK_piso_sucursal"))
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "id_salon_evento", nullable = false, foreignKey = @ForeignKey(name = "FK_piso_salon_evento"))
    private SalonEvento salon;

    @ManyToOne
    @JoinColumn(name = "id_color", nullable = false, foreignKey = @ForeignKey(name = "FK_piso_color"))
    private Color color;

    @OneToMany(mappedBy = "piso")
    private List<Color> botones = new ArrayList<>();

    @OneToMany(mappedBy = "piso", cascade = CascadeType.ALL)
    private List<Habitacion> habitaciones = new ArrayList<>();

}
