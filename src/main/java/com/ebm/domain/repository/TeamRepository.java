package com.ebm.domain.repository;

import com.ebm.domain.Team;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {
    List<Team> getAll();

    Optional<Team> getTeamById(int idTeam);

    List<Team> getTeamsByIdUser(int idUser);

}
