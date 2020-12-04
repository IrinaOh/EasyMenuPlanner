package com.example.easymenuplanner.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Recipe.class}, version = 1)
public abstract class DataBase extends RoomDatabase {
    public abstract RecipeDao recipeDao();
    private static DataBase INSTANCE;
    public static DataBase getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DataBase.class, "COOKBOOK_DB")
            .allowMainThreadQueries()
            .build();
        }
        return INSTANCE;
    }
}
