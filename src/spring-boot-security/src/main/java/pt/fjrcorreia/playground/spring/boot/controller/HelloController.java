package pt.fjrcorreia.playground.spring.boot.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Francisco Correia
 */

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        return "{\"message\": \"hello sir\"}";
    }
}
