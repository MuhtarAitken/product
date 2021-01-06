package kz.example.product.controller;

import kz.example.product.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }
}
