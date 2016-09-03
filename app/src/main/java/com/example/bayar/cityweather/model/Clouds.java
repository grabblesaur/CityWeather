
package com.example.bayar.cityweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Clouds {

    @SerializedName("all")
    @Expose
    int all;

    public Clouds() {
    }

    public Clouds(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }

    public String getFormattedClouds() {
        return String.valueOf(all) + " %";
    }
}
