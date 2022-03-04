package com.trashdoodles.artportfolio.controllers;

import com.trashdoodles.artportfolio.data.ImageRepository;
import com.trashdoodles.artportfolio.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ImageRepository imageRepository;

    private static List<String> artTypes= new ArrayList<>(Arrays.asList("illustration", "painting"));

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "Scott McDonald");
        return "index";
    }

}
