package org.ncapas.YggdrasilInn.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Huesped extends Usuario {

    @OneToMany(mappedBy = "huesped")
    private List<Reserva> reservas = new ArrayList<>();
}
