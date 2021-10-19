package com.omnicell.recipeapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.omnicell.recipeapp.entity.Recipe;
import com.omnicell.recipeapp.service.IRecipeService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipeAppApplication {

	@Autowired
	private static IRecipeService recipeService;

	public static void main(String[] args) {
		SpringApplication.run(RecipeAppApplication.class, args);
	}


}
