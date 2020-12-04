package com.example.easymenuplanner.recipe;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class Recipe implements Parcelable {
    private String recipeName;
    private String description;
    private List<Ingredient> ingredients;
    private List<String> instructions;
    private int numServings;
    private int cookTime;
    private int prepTime;

    public Recipe() {
        super();
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
        recipeName="";
    }

    public Recipe(String recipeName, String description, int numServings) {
        this.recipeName = recipeName;
        this.description = description;
        this.numServings = numServings;
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
        cookTime = 20;
        prepTime = 20;
    }

    protected Recipe(Parcel in) {
        recipeName = in.readString();
        description = in.readString();
        ingredients = in.createTypedArrayList(Ingredient.CREATOR);
        instructions = in.createStringArrayList();
        numServings = in.readInt();
        cookTime = in.readInt();
        prepTime = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(recipeName);
        dest.writeString(description);
        dest.writeTypedList(ingredients);
        dest.writeStringList(instructions);
        dest.writeInt(numServings);
        dest.writeInt(cookTime);
        dest.writeInt(prepTime);
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    public void addIngredient(Ingredient newIngredient) {
        ingredients.add(newIngredient);
    }

    public void addInstruction(String newInstruction) {
        instructions.add(newInstruction);
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public int getNumServings() {
        return numServings;
    }

    public String getDescription() {
        return description;
    }

    public List<Ingredient> getIngredients() {return ingredients; }

    public List<String> getInstructions() {return instructions;}

    @Override
    public int describeContents() {
        return 0;
    }


    //public int getRecipePic() {
    //    return recipePic;
    //}


}
