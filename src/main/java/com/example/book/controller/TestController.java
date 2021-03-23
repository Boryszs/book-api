package com.example.book.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(value = "/test")
public class TestController {

    @ResponseBody
    @GetMapping
    public String test(){
        return "Hello World";
    }

}
