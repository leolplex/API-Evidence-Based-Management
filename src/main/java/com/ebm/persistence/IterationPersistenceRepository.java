package com.ebm.persistence;


import com.ebm.domain.Iteration;
import com.ebm.domain.repository.IterationRepository;
import com.ebm.persistence.crud.IterationCrudRepository;
import com.ebm.persistence.entity.EntityIteration;
import com.ebm.persistence.mapper.IterationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IterationPersistenceRepository implements IterationRepository {
    @Autowired
    private IterationCrudRepository iterationCrudRepository;
    @Autowired
    private IterationMapper mapper;

    IterationPersistenceRepository(IterationCrudRepository iterationCrudRepository, IterationMapper iterationMapper) {
        this.iterationCrudRepository = iterationCrudRepository;
        this.mapper = iterationMapper;
    }

    @Override
    public List<Iteration> getAll() {
        List<EntityIteration> iterations = (List<EntityIteration>) iterationCrudRepository.findAll();
        return mapper.toIterations(iterations);
    }

    @Override
    public List<Iteration> getByIdTeam(int idTeam) {
        List<EntityIteration> iterations = iterationCrudRepository.getByIdTeam(idTeam);
        return mapper.toIterations(iterations);
    }

    @Override
    public Iteration save(Iteration iterationDomain) {
        EntityIteration iteration = mapper.toIterationDomain(iterationDomain);
        return mapper.toIteration(iterationCrudRepository.save(iteration));
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
