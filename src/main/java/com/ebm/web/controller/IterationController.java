package com.ebm.web.controller;

import com.ebm.domain.IterationDomain;
import com.ebm.domain.service.IterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/iterations")
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
}
