package com.trashdoodles.artportfolio.models;

public class Painting extends Image {

    private String imagePath;

    public Painting(String title, String fileName, String altAttribute, String description) {
        super(title, fileName, altAttribute, description);
        this.imagePath = "/images/paintings/" + fileName;
    }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
