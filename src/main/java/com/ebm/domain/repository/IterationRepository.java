package com.ebm.domain.repository;

import com.ebm.domain.IterationDomain;

import java.util.List;

public interface IterationRepository {
    List<IterationDomain> getAll();

    List<IterationDomain> getByIdTeam(int idTeam);

    IterationDomain save(IterationDomain iterationDomain);

    boolean delete(int iterationId);
}
