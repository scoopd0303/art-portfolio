package com.trashdoodles.artportfolio.controllers;

import com.trashdoodles.artportfolio.models.Doodle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("doodles")
public class DoodleController {

    private static List<Doodle> doodles = new ArrayList<>(Arrays.asList(
            new Doodle("Duckie", "duckie.png", "a weird looking duck", "marker & pen on paper"),
            new Doodle("Ghosties", "ghosties.png", "a couple of ghosties", "marker & pen on paper"),
            new Doodle("Definitely a Gerald", "definitely_a_gerald.png", "a small robot with broom and dustpan for arms", "marker & pen on paper"),
            new Doodle("It's Just a Plant", "it's_just_a_plant.png", "a sunflower smoking something", "marker & pen on paper"),
            new Doodle("Giraffe Astronaut", "giraffe_astronaut.png", "a giraffe in a space suit", "marker & pen on paper"),
            new Doodle("Grapes", "grapes.png", "a little green dude wearing a hat made of grapes", "marker & pen on paper")
    ));

    @GetMapping
    public String displayAllDoodles(Model model) {
        model.addAttribute("doodles", doodles);
        return "doodles";
    }

}
