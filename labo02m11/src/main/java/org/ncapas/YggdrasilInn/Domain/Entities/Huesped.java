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
public class Huesped extends Usuario {



    @OneToMany(mappedBy = "huesped")
    private List<Puntos> puntos = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "id_regalias", nullable = false, foreignKey = @ForeignKey(name = "FK_huesped_regalias"))
    private Regalias regalias;


}
