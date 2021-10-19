package com.omnicell.recipeapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnicell.recipeapp.Repository.RecipeRepository;
import com.omnicell.recipeapp.entity.Recipe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Component
@Service
public class RecipeServiceImpl implements IRecipeService{

    @Autowired
    RecipeRepository recipeRepository;

    @PostConstruct
    private void loadIntitialData() {
        try {
            URL url = new URL("https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            ObjectMapper mapper = new ObjectMapper();
            String output = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))
                    .lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(output);
            List<Recipe> defaultRecipeList = Arrays.asList(mapper.readValue(output, Recipe[].class));
            for(Recipe recipe: defaultRecipeList) {
                saveRecipe(recipe);
            }
            connection.disconnect();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public List<Recipe> findAllRecipe() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findRecipeById(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseGet(() -> null);
        return recipe;
    }

    @Override
    public Recipe createRecipe(@Valid Recipe recipe) {
        Recipe existingRecipe = findRecipeById(recipe.getId());
        if(existingRecipe != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Recipe with id [" + recipe.getId() +"] already exists!"
            );
        }
        return recipeRepository.save(recipe);
    }
}
