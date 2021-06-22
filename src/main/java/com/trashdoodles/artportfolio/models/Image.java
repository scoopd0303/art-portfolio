package com.trashdoodles.artportfolio.models;

import java.util.Objects;

public abstract class Image {

    private int id;
    private static int nextId;

    // properties
    private String title;
    private String fileName;
    private String altAttribute;
    private String description;

    // constructor
    public Image(String title, String fileName, String altAttribute, String description) {
        this.title = title;
        this.fileName = fileName;
        this.altAttribute = altAttribute;
        this.description = description;
        this.id = nextId;
        nextId++;
    }

    // getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getAltAttribute() { return altAttribute; }
    public void setAltAttribute(String altAttribute) { this.altAttribute = altAttribute; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return id == image.id && Objects.equals(fileName, image.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName);
    }
}
