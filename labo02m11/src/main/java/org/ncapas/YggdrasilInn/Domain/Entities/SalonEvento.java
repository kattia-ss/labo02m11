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

}

