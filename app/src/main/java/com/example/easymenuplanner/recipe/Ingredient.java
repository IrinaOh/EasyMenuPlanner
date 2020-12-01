package com.example.easymenuplanner.recipe;

import android.os.Parcel;
import android.os.Parcelable;

public class Ingredient implements Parcelable {
    private String unit;
    private float quantity;
    private String item;


    public Ingredient(String item, float quantity, String unit) {
       this.item = item;
        this.unit = unit;
        this.quantity = quantity;
    }

    protected Ingredient(Parcel in) {
        unit = in.readString();
        quantity = in.readFloat();
        item = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(unit);
        dest.writeFloat(quantity);
        dest.writeString(item);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ingredient> CREATOR = new Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel in) {
            return new Ingredient(in);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };

    @Override
    public String toString() {
        // Eventually, we will print the quantity as a fraction string

        if (unit == null) {
            return quantityToString(quantity) + ' ' + item;
        } else {
            return quantityToString(quantity) + ' ' + unit + ' ' + item;
        }

    }


    private String quantityToString(float quantity) {

        return String.format("%1.0f", quantity);
    }
}
