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
public class Regalias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegalias;

    private String nombre;
    private String descripcion;
    private int puntos;

    @OneToMany(mappedBy = "regalias")
    private List<Huesped> huespedes = new ArrayList<>();
}
