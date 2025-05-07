package org.ncapas.YggdrasilInn.Domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BotonAscensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBotonAscensor;

    private int pisoDestino;

    @ManyToOne
    @JoinColumn(name = "id_piso", nullable = false, foreignKey = @ForeignKey(name = "FK_boton_piso"))
    private Piso piso;
}
