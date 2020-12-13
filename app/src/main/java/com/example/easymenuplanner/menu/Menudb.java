package com.example.easymenuplanner.menu;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.easymenuplanner.recipe.Recipedb;

import java.util.Calendar;
import java.util.Date;

@Entity(tableName = "menu_table", foreignKeys = @ForeignKey(entity = Recipedb.class,
        parentColumns = "id",
        childColumns = "recipe_id",
        onDelete = ForeignKey.NO_ACTION))
public class Menudb {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "date")
    public Date date;

    @ColumnInfo(name = "recipe_id")
    public int recipe_id;

}
