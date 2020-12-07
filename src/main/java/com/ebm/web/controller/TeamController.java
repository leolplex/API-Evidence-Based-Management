package com.ebm.web.controller;

import com.ebm.domain.Team;
import com.ebm.domain.service.TeamService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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
    @ApiOperation("Get all teams with iterations")
    @ApiResponse(code = 200, message = "ok")
    public ResponseEntity<List<Team>> getAll() {
        return new ResponseEntity<>(teamService.getAll(), HttpStatus.OK);
    }
}
