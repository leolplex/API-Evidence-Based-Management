package com.ebm.domain.service;

import com.ebm.domain.Iteration;
import com.ebm.domain.repository.IterationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IterationService {
    @Autowired
    private final IterationRepository iterationRepository;

    IterationService(IterationRepository iterationRepository) {
        this.iterationRepository = iterationRepository;
    }

    public List<Iteration> getAll() {
        return iterationRepository.getAll();
    }

    public Optional<Iteration> getIterationById(int idIteration) {
        return iterationRepository.getIterationById(idIteration);
    }

    public Iteration save(Iteration iteration) {
        return iterationRepository.save(iteration);
    }

    public Optional<Iteration> update(int idIteration, Iteration iteration) {
        return iterationRepository.update(idIteration, iteration);
    }

}
