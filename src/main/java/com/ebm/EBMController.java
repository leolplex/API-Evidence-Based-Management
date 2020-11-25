package com.ebm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EBMController {
    @GetMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!!! A change 2";
    }
}
