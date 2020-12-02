package com.example.easymenuplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    private Context context;
    //define table
    private static final String DATABASE_NAME = "Cookbook.db";
    private static final int DATABASE_VERSION = 1;

    //define table columns:
    private static final String TABLE_NAME = "recipes";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TITLE = "recipe_title";
    private static final String COLUMN_DESCRIPTION = "recipe_desc";
    private static final String COLUMN_INGREDIENTS = "recipe_ingredients";
    private static final String COLUMN_INSTRUCTIONS = "recipe_instructions";
    private static final String COLUMN_SERVINGS = "recipe_servings";
    //private static final Blob COLUMN_IMAGE = "recipe_img"; use blob to store an image
    private static final String COLUMN_TAG = "recipe_tag";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create the table
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_INGREDIENTS + " TEXT, " +
                COLUMN_INSTRUCTIONS + " TEXT, " +
                COLUMN_SERVINGS + " INTEGER, " +
                COLUMN_TAG + " TEXT);";

        //execute the query
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addRecipe(String title, String description,
                   String ingredients, String instructions,
                   int servings, String tag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, title);
        cv.put(COLUMN_DESCRIPTION, description);
        cv.put(COLUMN_INGREDIENTS, ingredients);
        cv.put(COLUMN_INSTRUCTIONS, instructions);
        cv.put(COLUMN_SERVINGS, servings);
        cv.put(COLUMN_TAG, tag);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Failed to add", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show();
        }
    }
}
