package com.omnicell.recipeapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Recipe {

    @Id
    @NotNull
    private Long id;
    private String name;
    @Column(columnDefinition="TEXT")
    private String image;
    private String category;
    private String label;
    @Column(precision = 2)
    private Double price;
    @Column(columnDefinition="TEXT")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override public String toString() {
        return "Recipe{" + "id=" + id + ", name='" + name + '\'' + ", image='" + image + '\'' + ", category='"
                + category + '\'' + ", label='" + label + '\'' + ", price=" + price + ", description='" + description
                + '\'' + '}';
    }
}
