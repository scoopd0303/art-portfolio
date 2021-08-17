package com.trashdoodles.artportfolio.controllers;

import com.trashdoodles.artportfolio.data.ImageRepository;
import com.trashdoodles.artportfolio.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("gallery")
public class GalleryController {

    @Autowired
    private ImageRepository imageRepository;

    private static List<String> artTypes= new ArrayList<>(Arrays.asList("illustration", "painting"));

    @GetMapping
    public String displayGalleryItems(Model model) {

        model.addAttribute("title", "Selected Artworks");
        model.addAttribute("artworks", imageRepository.findAll());

        return "gallery/index";
    }

    @GetMapping("add")
    public String displayAddArtworkForm(Model model) {

        model.addAttribute("title", "Add New Artwork");
        model.addAttribute(new Image());
        model.addAttribute("artTypes", artTypes);

        return "gallery/add";
    }

    @PostMapping("add")
    public String processAddArtworkForm(@ModelAttribute @Valid Image newImage, Errors errors, Model model) {

        if(errors.hasErrors()) {
            model.addAttribute("title", "Add New Artwork");
            return "gallery/add";
        }
        imageRepository.save(newImage);

        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteArtworkForm(Model model) {

        model.addAttribute("title", "Delete Artwork");
        model.addAttribute("artworks", imageRepository.findAll());

        return "gallery/delete";
    }

    @PostMapping("delete")
    public String processDeleteArtworkForm(@RequestParam(required = false) int[] artworkIds) {

        if (artworkIds != null) {
            for (int id : artworkIds) {
                imageRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

    @GetMapping("edit/{artworkId}")
    public String displayEditArtworkForm(Model model, @PathVariable int artworkId) {

        Image artwork = imageRepository.findById(artworkId).get();
        String title = "Edit Artwork " + artwork.getTitle();
        model.addAttribute("title", title);
        model.addAttribute("artwork", artwork);
        model.addAttribute("artTypes", artTypes);

        return "gallery/edit";
    }

    @PostMapping("edit")
    public String processEditArtworkForm(@RequestParam(required = false) Integer artworkId, String title) {

        if (artworkId != null) {
            Image artwork = imageRepository.findById(artworkId).get();
            String pageTitle = "Edit Artwork " + artwork.getTitle();

//            if (errors.hasErrors()) {
//                model.addAttribute("title", pageTitle);
//                model.addAttribute("artwork", artwork);
//                model.addAttribute("artTypes", artTypes);
//                return "gallery/edit";
//            }
            artwork.setTitle(title);
//            artwork.setFileName(filename);
//            artwork.setDescription(description);
//            artwork.setArtType(artType);
            imageRepository.save(artwork);
        }

        return "redirect:/gallery";

    }
}
