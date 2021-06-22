package com.trashdoodles.artportfolio.models;

public class Doodle extends Image {

    private String imagePath;

    public Doodle(String title, String fileName, String altAttribute, String description) {
        super(title, fileName, altAttribute, description);
        this.imagePath = "/images/doodles/" + fileName;
    }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }
}
