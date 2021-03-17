package kz.example.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String greeting(Model model) {

        return "index";
    }

    @GetMapping("/index")
    public String about(Model model) {

        return "list";
    }
}