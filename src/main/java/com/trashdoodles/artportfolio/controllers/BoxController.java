package com.trashdoodles.artportfolio.controllers;

import com.trashdoodles.artportfolio.data.ImageRepository;
import com.trashdoodles.artportfolio.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("box")
public class BoxController {

    @Autowired
    private ImageRepository imageRepository;

    public List<String> findAllImagePaths() {
        List<Image> images = new ArrayList<>();
        List<String> imagePaths = new ArrayList<>();
        imageRepository.findAll().forEach(images::add);
        for (int i=0; i < images.size();i++) {
            imagePaths.add(images.get(i).getImagePath());
        }
        return imagePaths;
    }

    @GetMapping
    public String displayTheBox(Model model) {
        model.addAttribute("title", "What's in the box?!");

        model.addAttribute("artworks", findAllImagePaths());
        return "box/index";
    }

}
