package com.omnicell.recipeapp.service;

import com.omnicell.recipeapp.entity.Recipe;
import java.util.List;
import javax.validation.Valid;

public interface IRecipeService {
    void saveRecipe(Recipe recipe);

    List<Recipe> findAllRecipe();

    Recipe findRecipeById(Long recipeId);

    Recipe createRecipe(@Valid Recipe recipe);
}
