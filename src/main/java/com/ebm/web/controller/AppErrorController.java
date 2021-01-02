package com.ebm.web.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Basic Controller which is called for unhandled errors
 */
@Controller
@CrossOrigin(origins = {"http://localhost:4200", "https://leolplex.github.io"}, methods = {RequestMethod.GET})
public class AppErrorController implements ErrorController {
    private final static String PATH = "/error";

    @Override
    @RequestMapping(value = PATH, method = RequestMethod.GET)
    @ResponseBody
    public String getErrorPath() {
        return "No Mapping Found";
    }

}