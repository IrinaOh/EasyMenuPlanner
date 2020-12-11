package com.example.easymenuplanner.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Recipedb.class}, version  = 1)
public abstract class CookbookDatabase extends RoomDatabase {

    public abstract RecipeDao recipeDao();

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
