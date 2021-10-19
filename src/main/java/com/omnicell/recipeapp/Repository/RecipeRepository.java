package com.omnicell.recipeapp.Repository;

import com.omnicell.recipeapp.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
