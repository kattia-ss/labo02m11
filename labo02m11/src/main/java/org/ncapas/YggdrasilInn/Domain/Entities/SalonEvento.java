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
public class SalonEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalonEvento;
    private String nombreSalon;
    private int capacidad;
    private String ornamentos;

    @ManyToOne
    @JoinColumn(name = "id_piso", nullable = false, foreignKey = @ForeignKey(name = "FK_salon_piso"))
    private Piso piso;

    @OneToMany(mappedBy = "salon")
    private List<Reserva> reservas;
}

