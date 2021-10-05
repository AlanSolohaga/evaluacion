package com.evaluacion.evalTec.repository;

import com.evaluacion.evalTec.exceptions.ExcepcionPropia;
import com.evaluacion.evalTec.models.entities.Candidato;

import java.util.List;

public interface CandidatoRepository {

    List<Candidato> getCandidatos();

    void deleteCandidato(int id);

    Candidato findCandidato(int id);

    void registerCandidato(Candidato candidato) throws ExcepcionPropia;

    List<Candidato> getCandidatosPorTecnologia(String nombre) throws ExcepcionPropia;
}
