package com.example.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/403")
    public String forbidden(Model model) {
        return "error";
    }

    @GetMapping("/404")
    public String notFound(Model model) {
        return "error";
    }

    @GetMapping("/500")
    public String internal(Model model) {
        return "error";
    }

    @GetMapping("/401")
    public String accessUnautorized(Model model) {
        return "error";
    }


    @GetMapping("/access-denied")
    public String accessDenied() {
        return "error";
    }
}
