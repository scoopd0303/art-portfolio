package com.trashdoodles.artportfolio.controllers;

import com.trashdoodles.artportfolio.models.Painting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("paintings")
public class PaintingController {

    private static List<Painting> paintings = new ArrayList<>(Arrays.asList(
            new Painting("Pokey", "pokey.png", "a portrait of Pokey Lafarge", "acrylic on canvas"),
            new Painting("Charles", "charles_bradley.png", "a portrait of Charles Bradley", "acrylic and charcoal on panel board"),
            new Painting("Molly", "molly.png", "a portrait of my pittbull, Molly", "acrylic and marker on canvas"),
            new Painting("A Salty Sea Dog", "salty_sea_dog.png", "a portrait of a salty sea dog", "acrylic and charcoal on canvas"),
            new Painting("Troll", "troll.png", "a portrait of a mountain troll", "acrylic on canvas"),
            new Painting("Robot", "robot.png", "a portrait of a robot drinking coffee", "acrylic on canvas")
    ));

    @GetMapping
    public String displayAllPaintings(Model model) {
        model.addAttribute("paintings", paintings);
        return "paintings";
    }
}
