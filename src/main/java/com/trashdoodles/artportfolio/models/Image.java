package com.trashdoodles.artportfolio.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Image extends AbstractEntity {

    // properties
    @NotBlank(message = "Title is required.")
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters long.")
    private String title;

    @NotNull(message = "File name is required.")
    @Size(min = 3, message = "File name is too short.")
    private String fileName;

    @NotNull(message = "Art type is required.")
    private String artType;

    private String description;

    // constructor
    public Image(String title, String fileName, String artType, String description) {
        this.title = title;
        this.fileName = fileName;
        this.artType = artType;
        this.description = description;
    }

    // empty constructor
    public Image() {}

    // getters and setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getArtType() { return artType; }
    public void setArtType(String artType) { this.artType = artType; }

    // custom methods
    public String getImagePath() { return "/images/" + artType + "/" + fileName; }

}
