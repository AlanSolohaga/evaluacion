package com.evaluacion.evalTec.models.entities;

import com.evaluacion.evalTec.models.enums.TipoDocumentoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "candidatos")
public class Candidato {
    @Id
    @Getter @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO
    private int id;
    @Getter @Setter @Column(name ="nombre")
    private String nombre;
    @Getter @Setter @Column(name ="apellido")
    private String apellido;
    @Getter @Setter @Column(name ="tipo_documento")
    private String tipoDocumento; //ENUM (DNI,LE,LC)
    @Getter @Setter @Column(name ="documento")
    private int documento;
    @Getter @Setter @Column(name ="nacimiento")
    private Date nacimiento;

    @Getter @Setter @ManyToMany(mappedBy = "candidatos")
    private List<Tecnologia> tecnologias;

}
