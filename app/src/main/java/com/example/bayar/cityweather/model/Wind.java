
package com.example.bayar.cityweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Wind {

    @SerializedName("speed")
    @Expose
    Long speed;

    public Wind() {
    }

    public Wind(Long speed) {
        this.speed = speed;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }
}
