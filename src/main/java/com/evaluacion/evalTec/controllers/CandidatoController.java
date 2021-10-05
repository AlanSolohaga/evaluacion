package com.evaluacion.evalTec.controllers;

import com.evaluacion.evalTec.exceptions.ExcepcionPropia;
import com.evaluacion.evalTec.models.entities.Candidato;
import com.evaluacion.evalTec.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidatoController{

    @Autowired
    private CandidatoService candidatoService;

    @RequestMapping(value = "api/candidatos",method = RequestMethod.GET)
    public List<Candidato> getCandidatos() {
        return candidatoService.getCandidatos();
    }

    @RequestMapping(value = "api/candidatos/{id}",method = RequestMethod.DELETE)
    public void deleteCandidato(@PathVariable int id){
        candidatoService.deleteCandidato(id);
    }

    @RequestMapping(value = "api/candidatos/{id}",method = RequestMethod.GET)
    public Candidato findCandidato(@PathVariable int id){
        return candidatoService.findCandidato(id);
    }

    @RequestMapping(value = "api/candidatos",method = RequestMethod.POST)
    public void registerCandidato(@RequestBody  Candidato candidato) throws ExcepcionPropia {
        candidatoService.registerCandidato(candidato);
    }

    @RequestMapping(value = "api/candidatos/tecnologia/{nombre}",method = RequestMethod.GET)
    public List<Candidato> getCandidatosPorTecnologia(@PathVariable String nombre) throws ExcepcionPropia{
        return candidatoService.getCandidatosPorTecnologia(nombre);
    }

}
