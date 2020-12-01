package com.ebm.persistence;


import com.ebm.domain.IterationDomain;
import com.ebm.domain.repository.IterationRepository;
import com.ebm.persistence.crud.IterationCrudRepository;
import com.ebm.persistence.entity.Iteration;
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
    public List<IterationDomain> getAll() {
        List<Iteration> iterations = (List<Iteration>) iterationCrudRepository.findAll();
        return mapper.toIterations(iterations);
    }

    @Override
    public List<IterationDomain> getByIdTeam(int idTeam) {
        List<Iteration> iterations = iterationCrudRepository.getByIdTeam(idTeam);
        return mapper.toIterations(iterations);
    }

    @Override
    public IterationDomain save(IterationDomain iterationDomain) {
        Iteration iteration = mapper.toIterationDomain(iterationDomain);
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
