package com.evaluacion.evalTec.services;

import com.evaluacion.evalTec.exceptions.ExcepcionPropia;
import com.evaluacion.evalTec.models.entities.Candidato;
import com.evaluacion.evalTec.repository.CandidatoImplement;
import com.evaluacion.evalTec.repository.CandidatoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    private final Logger logger = LoggerFactory.getLogger(CandidatoImplement.class);

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<Candidato> getCandidatos(){
        return candidatoRepository.getCandidatos();
    }

    public void deleteCandidato(int id){
        candidatoRepository.deleteCandidato(id);
    }

    public Candidato findCandidato(int id){
        return candidatoRepository.findCandidato(id);
    }

    public void registerCandidato(Candidato candidato) throws ExcepcionPropia {
        try {
            if(!isEmpty(candidato)){
                candidatoRepository.registerCandidato(candidato);
            }
        }catch (ExcepcionPropia e){
            logger.error(e.datosIncompletos());
        }
    }
    private boolean isEmpty(Candidato candidato) {
        if(candidato.getNombre().isEmpty() || candidato.getApellido().isEmpty()){
            return true;
        }
        return false;
    }
    public List<Candidato> getCandidatosPorTecnologia(String nombre){
        try {
            return candidatoRepository.getCandidatosPorTecnologia(nombre);
        } catch (ExcepcionPropia e) {
            logger.info(e.dontExist());
        }
        return null;
    }
}
