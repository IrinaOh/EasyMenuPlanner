package com.example.easymenuplanner.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.easymenuplanner.recipe.Recipedb;

@Database(entities = {Recipedb.class}, version  = 1)
public abstract class CookbookDatabase extends RoomDatabase {

    public abstract CookbookDao cookbookDao();

    private static CookbookDatabase INSTANCE;

    public static CookbookDatabase getDbInstance(Context context) {

        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CookbookDatabase.class, "COOKBOOK_DB")
                    .allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }

//    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//
//            CookbookDao dao = INSTANCE.cookbookDao();
//            dao.deleteAll();
//            Recipedb recipe = new Recipedb();
//            recipe.title = "Lasagna";
//            recipe.description = "I'm in Italy";
//            recipe.numServings = 6;
//            dao.insertRecipe(recipe);
//        }
//    };

}
