package com.example.easymenuplanner.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.easymenuplanner.menu.Menudb;
import com.example.easymenuplanner.recipe.Recipedb;

import java.util.List;

@Dao
public interface MenuDao {

    @Query("SELECT * FROM menu_table")
    List<Menudb> getAllMenus();

    @Query("SELECT * FROM recipe_table WHERE id LIKE :id")
    Recipedb findRecipeByID(int id);

    // Three dots means that zero or more Recipedb objects may be passed as the arguments for this
    // method.
    @Insert
    void insertRecipe(Menudb... menudb);

    @Delete
    void delete(Menudb menudb);



}
