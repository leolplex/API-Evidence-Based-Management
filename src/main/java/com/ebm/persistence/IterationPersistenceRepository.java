package com.ebm.persistence;


import com.ebm.domain.Iteration;
import com.ebm.domain.repository.IterationRepository;
import com.ebm.persistence.crud.IterationCrudRepository;
import com.ebm.persistence.entity.EntityIteration;
import com.ebm.persistence.mapper.IterationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public Optional<Iteration> getIterationById(int idIteration) {
        return iterationCrudRepository.findById(idIteration).map(iteration -> mapper.toIteration(iteration));
    }

    @Override
    public Iteration save(Iteration iterationDomain) {
        EntityIteration iteration = mapper.toIterationDomain(iterationDomain);
        return mapper.toIteration(iterationCrudRepository.save(iteration));
    }

    @Override
    public Optional<Iteration> update(int idIteration, Iteration iteration) {
        return iterationCrudRepository.findById(idIteration).map(iterationDB -> {


            if (iteration.getGoal() != null && !iteration.getGoal().isEmpty()) {
                iterationDB.setEntityGoal(iteration.getGoal());
            }

            if (iteration.getStartDate() != null) {
                iterationDB.setEntityStartDate(iteration.getStartDate());
            }

            if (iteration.getEndDate() != null) {
                iterationDB.setEntityEndDate(iteration.getEndDate());
            }

            if (iteration.getState() != null && !iteration.getState().isEmpty()) {
                iterationDB.setEntityState(iteration.getState());
            }

            if (iteration.getName() != null && !iteration.getName().isEmpty()) {
                iterationDB.setEntityName(iteration.getName());
            }


            return mapper.toIteration(iterationCrudRepository.save(iterationDB));
        });
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
