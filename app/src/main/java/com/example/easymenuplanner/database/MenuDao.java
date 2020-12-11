package com.example.easymenuplanner.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.easymenuplanner.recipe.Recipedb;

import java.util.List;

@Dao
public interface MenuDao {

    @Query("SELECT * FROM menu_table")
    List<Recipedb> getAllRecipes();

    // Three dots means that zero or more Recipedb objects may be passed as the arguments for this
    // method.
    @Insert
    void insertRecipe(Recipedb... recipedbs);

    @Delete
    void delete(Recipedb recipedb);


}
