package com.evaluacion.evalTec.repository;

import com.evaluacion.evalTec.models.entities.Candidato;
import com.evaluacion.evalTec.models.entities.Tecnologia;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TecnologiaImplement implements TecnologiaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tecnologia> getTecnologias() {
        String query = "FROM Tecnologia";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteTecnologia(int id) {
        Tecnologia tecnologia = entityManager.find(Tecnologia.class,id);
        entityManager.remove(tecnologia);
    }

    @Override
    public Tecnologia findTecnologia(int id) {
        return entityManager.find(Tecnologia.class,id);
    }

    @Override
    public void registerTecnologia(Tecnologia tecnologia) {
        entityManager.merge(tecnologia);
    }
}
