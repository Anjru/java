package ca.myapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PledgeController {
    @GetMapping("/hello")
    public String getHelloMessage(){
        return "Hello World";
    }
}
