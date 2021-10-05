package com.evaluacion.evalTec.services;

import com.evaluacion.evalTec.models.entities.Candidato;
import com.evaluacion.evalTec.models.entities.Tecnologia;
import com.evaluacion.evalTec.repository.TecnologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologiaService {

    @Autowired
    private TecnologiaRepository tecnologiaRepository;

    public List<Tecnologia> getTecnologias(){
        return tecnologiaRepository.getTecnologias();
    }

    public void deleteTecnologia(int id){
        tecnologiaRepository.deleteTecnologia(id);
    }

    public Tecnologia findTecnologia(int id){
        return tecnologiaRepository.findTecnologia(id);
    }

    public void registerTecnologia(Tecnologia tecnologia){
        tecnologiaRepository.registerTecnologia(tecnologia);
    }

}
