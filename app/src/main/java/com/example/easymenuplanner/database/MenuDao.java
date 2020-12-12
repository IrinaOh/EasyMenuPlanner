package com.example.easymenuplanner.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.easymenuplanner.menu.Menudb;
import com.example.easymenuplanner.recipe.Recipedb;

import java.util.List;

@Dao
public interface MenuDao {

    @Query("SELECT * FROM menu_table")
    List<Menudb> getAllMenus();

    @Query("SELECT * FROM recipe_table WHERE id LIKE :id")
    Recipedb findRecipeByID(int id);

    @Query("SELECT * FROM menu_table ORDER BY date DESC LIMIT 1")
    Menudb findLastMenu();

    // Three dots means that zero or more Recipedb objects may be passed as the arguments for this
    // method.
    @Insert
    void insertMenu(Menudb... menudbs);

    @Update
    void replaceRecipe(Menudb menu);

    @Query("SELECT * FROM menu_table WHERE id = :menuID LIMIT 1")
    Menudb getMenuFromID(int menuID);

    @Delete
    void delete(Menudb menudb);



}
