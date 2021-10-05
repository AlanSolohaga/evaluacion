package com.evaluacion.evalTec.models.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tecnologias")
public class Tecnologia {
    @Id
    @Column(name = "id", nullable = false)
    @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter @Setter @Column(name="nombre")
    private String nombre;
    @Getter @Setter @Column(name="version")
    private double version;

    @JoinTable(
            name = "cantec",
            joinColumns = @JoinColumn(name = "id_tecnologia")
            ,inverseJoinColumns = @JoinColumn(name = "id_candidato"))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Candidato> candidatos;


}
