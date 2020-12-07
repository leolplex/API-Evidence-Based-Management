package com.ebm.domain.service;

import com.ebm.domain.Iteration;
import com.ebm.domain.repository.IterationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Iteration> getByTeam(int idTeam) {
        return iterationRepository.getByIdTeam(idTeam);
    }

    public Iteration save(Iteration iteration) {
        return iterationRepository.save(iteration);
    }

}
