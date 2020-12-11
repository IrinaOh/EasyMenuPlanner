package com.example.easymenuplanner.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.easymenuplanner.recipe.Recipedb;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CookbookDao {

    @Query("SELECT * FROM cookbook_table")
    List<Recipedb> getAllRecipes();

    // Three dots means that zero or more Recipedb objects may be passed as the arguments for this
    // method.
    @Insert
    void insertRecipe(Recipedb... recipedbs);

    @Delete
    void delete(Recipedb recipedb);

    @Query("DELETE FROM cookbook_table")
    void deleteAll();
}
