package com.evaluacion.evalTec.repository;

import com.evaluacion.evalTec.exceptions.ExcepcionPropia;
import com.evaluacion.evalTec.models.entities.Candidato;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static com.evaluacion.evalTec.utilidades.Utils.CANDIDATO_POR_CATEGORIA;

@Repository
@Transactional
public class CandidatoImplement implements CandidatoRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Candidato> getCandidatos() {
        String query = "FROM Candidato";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteCandidato(int id){
        Candidato candidato = entityManager.find(Candidato.class,id);
        entityManager.remove(candidato);
    }

    @Override
    public Candidato findCandidato(int id) {
        Candidato candidato = entityManager.find(Candidato.class,id);
        return candidato;
    }

    @Override
    public void registerCandidato(Candidato candidato) throws ExcepcionPropia {
        entityManager.merge(candidato);
    }

    @Override
    public List<Candidato> getCandidatosPorTecnologia(String nombre) throws ExcepcionPropia {
        Query query = entityManager.createNativeQuery(CANDIDATO_POR_CATEGORIA,Candidato.class);
        query.setParameter(1,nombre);
        return query.getResultList();
    }
}
