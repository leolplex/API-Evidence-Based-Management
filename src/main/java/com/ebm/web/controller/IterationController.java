package com.ebm.web.controller;

import com.ebm.domain.Iteration;
import com.ebm.domain.service.IterationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iterations")
@CrossOrigin(origins = {"http://localhost:4200", "https://leolplex.github.io"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class IterationController {
    @Autowired
    private final IterationService iterationService;

    IterationController(IterationService iterationService) {
        this.iterationService = iterationService;
    }

    @GetMapping("/all")
    @ApiOperation("Get all iterations")
    @ApiResponse(code = 200, message = "ok")
    public ResponseEntity<List<Iteration>> getAll() {
        return new ResponseEntity<>(iterationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/iteration/{idIteration}")
    @ApiOperation("Get iterations by id")
    @ApiResponse(code = 200, message = "ok")
    public ResponseEntity<Iteration> getIterationById(@ApiParam(value = "The id of the iteration", required = true, example = "7") @PathVariable("idIteration") int idIteration) {
        return iterationService.getIterationById(idIteration).map(iteration -> new ResponseEntity<>(iteration, HttpStatus.OK)).orElse(new ResponseEntity<>((HttpStatus.NOT_FOUND)));
    }

    @PostMapping("/save")
    @ApiOperation("Create a new iteration")
    @ApiResponse(code = 200, message = "ok")
    public ResponseEntity<Iteration> save(@RequestBody Iteration iteration) {
        return new ResponseEntity<>(iterationService.save(iteration), HttpStatus.CREATED);
    }
}
