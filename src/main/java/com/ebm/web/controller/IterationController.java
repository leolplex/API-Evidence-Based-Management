package com.ebm.web.controller;

import com.ebm.domain.IterationDomain;
import com.ebm.domain.service.IterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iterations")
@CrossOrigin(origins = "http://localhost:4200/,https://leolplex.github.io/", methods = {RequestMethod.GET, RequestMethod.POST})
public class IterationController {
    @Autowired
    private final IterationService iterationService;

    IterationController(IterationService iterationService) {
        this.iterationService = iterationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<IterationDomain>> getAll() {
        return new ResponseEntity<>(iterationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/byTeam/{idTeam}")
    public ResponseEntity<List<IterationDomain>> getByTeam(@PathVariable("idTeam") int idTeam) {
        return new ResponseEntity<>(iterationService.getByTeam(idTeam), HttpStatus.OK);
    }
}
