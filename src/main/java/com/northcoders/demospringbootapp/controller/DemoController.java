package com.northcoders.demospringbootapp.controller;

import com.northcoders.demospringbootapp.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DemoController {

    @GetMapping("/hello")
    public String greeterController(){
        return "Hello there!";
    }

    @GetMapping("/person")
    public static List<Person> personListController(){
        return List.of(new Person("Bob",34,"bob@gmail.com","Sweden","Pizza"),
                new Person("Bill", 21, "bill@hotmail.co.uk","USA","Burger"));

    }
}

