package com.ebm.domain.repository;

import com.ebm.persistence.entity.Iteration;

import java.util.List;

public interface IterationRepository {
    List<Iteration> getAll();

    List<Iteration> getByIdTeam(int idTeam);

    Iteration save(Iteration iteration);

    boolean delete(int iterationId);
}
