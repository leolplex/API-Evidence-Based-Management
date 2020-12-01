package com.ebm.persistence;


import com.ebm.persistence.crud.IterationCrudRepository;
import com.ebm.persistence.entity.Iteration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IterationRepository implements com.ebm.domain.repository.IterationRepository {
    @Autowired
    private IterationCrudRepository iterationCrudRepository;

    IterationRepository(IterationCrudRepository iterationCrudRepository) {
        this.iterationCrudRepository = iterationCrudRepository;
    }

    @Override
    public List<Iteration> getAll() {
        return (List<Iteration>) iterationCrudRepository.findAll();
    }

    @Override
    public List<Iteration> getByIdTeam(int idTeam) {
        return iterationCrudRepository.getByIdTeam(idTeam);
    }

    @Override
    public Iteration save(Iteration iteration) {
        return iterationCrudRepository.save(iteration);
    }

    @Override
    public boolean delete(int iterationId) {
        try {
            iterationCrudRepository.deleteById(iterationId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
