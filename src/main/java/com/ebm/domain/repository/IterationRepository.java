package com.ebm.domain.repository;

import com.ebm.domain.Iteration;

import java.util.List;
import java.util.Optional;

public interface IterationRepository {
    List<Iteration> getAll();

    Optional<Iteration> getIterationById(int idIteration);

    Iteration getLastIteration(int idTeam);

    Iteration save(Iteration iteration);

    Optional<Iteration> update(int idIteration, Iteration iteration);

    boolean delete(int iterationId);
}
