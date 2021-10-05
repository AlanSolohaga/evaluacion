package com.evaluacion.evalTec.controllers;

import com.evaluacion.evalTec.models.entities.Candidato;
import com.evaluacion.evalTec.models.entities.Tecnologia;
import com.evaluacion.evalTec.repository.TecnologiaRepository;
import com.evaluacion.evalTec.services.TecnologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TecnologiaController {

    @Autowired
    private TecnologiaService tecnologiaService;

    @RequestMapping(value = "api/tecnologias",method = RequestMethod.GET)
    public List<Tecnologia> getTecnologias() {
        return tecnologiaService.getTecnologias();
    }

    @RequestMapping(value = "api/tecnologias/{id}",method = RequestMethod.DELETE)
    public void deleteTecnologia(@PathVariable int id){
        tecnologiaService.deleteTecnologia(id);
    }

    @RequestMapping(value = "api/tecnologias/{id}",method = RequestMethod.GET)
    public Tecnologia findTecnologia(@PathVariable int id){
        return tecnologiaService.findTecnologia(id);
    }

    @RequestMapping(value = "api/tecnologias",method = RequestMethod.POST)
    public void registerTecnologia(@RequestBody Tecnologia tecnologia) {
        tecnologiaService.registerTecnologia(tecnologia);
    }

}
