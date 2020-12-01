package com.ebm.domain.service;

import com.ebm.domain.repository.IterationRepository;
import com.ebm.domain.IterationDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IterationService {
    @Autowired
    private IterationRepository iterationRepository;

    IterationService(IterationRepository iterationRepository) {
        this.iterationRepository = iterationRepository;
    }

    public List<IterationDomain> getAll() {
        return iterationRepository.getAll();
    }

    public List<IterationDomain> getByTeam(int idTeam) {
        return iterationRepository.getByIdTeam(idTeam);
    }

}
