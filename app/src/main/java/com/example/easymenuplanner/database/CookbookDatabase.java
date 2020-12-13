package com.example.easymenuplanner.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.easymenuplanner.menu.Menudb;
import com.example.easymenuplanner.recipe.Recipedb;

//@Database(entities = {Recipedb.class}, version  = 1)
@Database(entities = {Recipedb.class, Menudb.class}, version  = 1)
@TypeConverters({Converters.class})
public abstract class CookbookDatabase extends RoomDatabase {

    public abstract RecipeDao cookbookDao();
    public abstract MenuDao menuDao();

    private static CookbookDatabase INSTANCE;

    public static CookbookDatabase getDbInstance(Context context) {

        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CookbookDatabase.class, "COOKBOOK_DB")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }


}
