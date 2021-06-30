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

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    private static List<Image> artworks = new ArrayList<>(Arrays.asList(
            new Image("Duckie", "duckie.png", "illustration", "marker & pen on paper"),
            new Image("Ghosties", "ghosties.png", "illustration", "marker & pen on paper"),
            new Image("Definitely a Gerald", "definitely_a_gerald.png", "illustration", "marker & pen on paper"),
            new Image("It's Just a Plant", "it's_just_a_plant.png", "illustration", "marker & pen on paper"),
            new Image("Giraffe Astronaut", "giraffe_astronaut.png", "illustration", "marker & pen on paper"),
            new Image("Grapes", "grapes.png", "illustration", "marker & pen on paper"),
            new Image("Pokey", "pokey.png", "painting", "acrylic on canvas"),
            new Image("Charles", "charles_bradley.png", "painting", "acrylic and charcoal on panel board"),
            new Image("Molly", "molly.png", "painting", "acrylic and marker on canvas"),
            new Image("A Salty Sea Dog", "salty_sea_dog.png", "painting", "acrylic and charcoal on canvas"),
            new Image("Troll", "troll.png", "painting", "acrylic on canvas"),
            new Image("Robot", "robot.png", "painting", "acrylic on canvas")
    ));

    @Autowired
    private ImageRepository imageRepository;

    private static List<String> artTypes= new ArrayList<>(Arrays.asList("illustration", "painting"));

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "Selected Artworks");
        model.addAttribute("artworks", imageRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddArtWorkForm(Model model) {
        model.addAttribute("title", "Add New Artwork");
        model.addAttribute(new Image());
        model.addAttribute("artTypes", artTypes);
        return "add";
    }

    @PostMapping("add")
    public String processAddArtWorkForm(@ModelAttribute @Valid Image newImage, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add New Artwork");
            return "add";
        }
        imageRepository.save(newImage);
        return "redirect:";
    }

}
