package com.ebm.web.controller;

import com.ebm.domain.TeamDomain;
import com.ebm.domain.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = {"http://localhost:4200", "https://leolplex.github.io"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class TeamController {
    @Autowired
    private final TeamService teamService;

    TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamDomain>> getAll() {
        return new ResponseEntity<>(teamService.getAll(), HttpStatus.OK);
    }
}
