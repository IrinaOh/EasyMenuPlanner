package com.example.easymenuplanner.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Recipedb {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "ingredients")
    public String ingredients;

    @ColumnInfo(name = "directions")
    public String directions;

    @ColumnInfo(name = "numServings")
    public int numServings;

    @ColumnInfo(name = "tag")
    public String tag;

}
