package com.evaluacion.evalTec.repository;

import com.evaluacion.evalTec.models.entities.Candidato;
import com.evaluacion.evalTec.models.entities.Tecnologia;

import java.util.List;

public interface TecnologiaRepository {
    List<Tecnologia> getTecnologias();

    void deleteTecnologia(int id);

    Tecnologia findTecnologia(int id);

    void registerTecnologia(Tecnologia tecnologia);
}
