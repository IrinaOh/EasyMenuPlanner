package com.example.easymenuplanner.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.easymenuplanner.R;
import com.example.easymenuplanner.recipe.Recipedb;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface RecipeDao {

//    @Query("SELECT * FROM recipe_table ORDER BY title ASC")
//    List<Recipedb> getAllRecipes();

    @Query("SELECT * FROM recipe_table WHERE title NOT LIKE '' ORDER BY title ASC")
    List<Recipedb> getAllRecipes();

    @Query("SELECT * FROM recipe_table WHERE title LIKE :rTitle")
    List<Recipedb> findRecipe(String rTitle);

    @Query("SELECT * FROM recipe_table WHERE title LIKE :rTitle LIMIT 1")
    int getRecipeID(String rTitle);

    @Query("SELECT * FROM recipe_table WHERE id = :recipeID LIMIT 1")
    Recipedb getRecipeFromID(int recipeID);

    @Update
    void replaceRecipe(Recipedb recipe);

    // Three dots means that zero or more Recipedb objects may be passed as the arguments for this
    // method.
    @Insert
    void insertRecipe(Recipedb... recipedbs);

    @Delete
    void delete(Recipedb recipedb);

    @Query("DELETE FROM recipe_table")
    void deleteAll();

}
