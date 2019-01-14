package com.yamba.bankonet.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HWController {

    @GetMapping("/")
    public String sayHello(){
        return "Bienvenue sur Bankonet ";
    }
}
