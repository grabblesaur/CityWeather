
package com.example.bayar.cityweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Clouds {

    @SerializedName("all")
    @Expose
    Long all;

    public Clouds() {
    }

    public Clouds(Long all) {
        this.all = all;
    }

    public Long getAll() {
        return all;
    }

    public void setAll(Long all) {
        this.all = all;
    }
}
