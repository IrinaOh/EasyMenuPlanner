package com.example.easymenuplanner.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.easymenuplanner.recipe.Recipedb;

@Database(entities = {Recipedb.class}, version  = 1)
public abstract class CookbookDatabase extends RoomDatabase {

    public abstract RecipeDao cookbookDao();
    //public abstract MenuDao recipeDao();

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
