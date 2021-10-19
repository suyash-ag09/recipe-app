package com.omnicell.recipeapp.controller;

import com.omnicell.recipeapp.entity.Recipe;
import com.omnicell.recipeapp.service.IRecipeService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RecipeAppController {

    @Autowired
    private IRecipeService recipeService;

    @GetMapping(path = "/")
    public List<Recipe> findAll(){
        return recipeService.findAllRecipe();
    }

    @GetMapping(path = "/{recipeId}")
    public Recipe findById(@PathVariable Long recipeId){
        Recipe recipe = recipeService.findRecipeById(recipeId);
        if(recipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Recipe with id [" + recipeId +"] not found!");
        } else {
            return recipe;
        }
    }

    @PostMapping(path = "/")
    public Recipe createRecipe(@RequestBody @Valid Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping(path = "/{recipeId}/show")
    public String showImageById(@PathVariable Long recipeId) {
        Recipe recipe = findById(recipeId);
        return recipe.getImage();
    }
}
