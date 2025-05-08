package org.ncapas.YggdrasilInn.Domain.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Puntos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPuntos;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_huesped", nullable = false, foreignKey = @ForeignKey(name = "FK_puntos_huesped"))
    private Huesped huesped;

}
