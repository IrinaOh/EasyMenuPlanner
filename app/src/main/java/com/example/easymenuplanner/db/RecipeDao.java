package com.example.easymenuplanner.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {

    @Query("SELECT * FROM recipedb")
    List<Recipedb> getAllRecipes();

    @Insert
    void insertRecipe(Recipedb... recipedbs);

    @Delete
    void delete(Recipedb recipedb);
}
