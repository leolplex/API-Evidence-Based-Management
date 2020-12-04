package com.ebm.domain.repository;

import com.ebm.domain.TeamDomain;

import java.util.List;

public interface TeamRepository {
    List<TeamDomain> getAll();
}
