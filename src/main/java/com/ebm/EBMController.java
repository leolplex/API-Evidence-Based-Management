package com.ebm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EBMController {
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!!! A change";
    }
}
