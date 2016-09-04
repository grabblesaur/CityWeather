
package com.example.bayar.cityweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel(Parcel.Serialization.BEAN)
public class Wind {

    @SerializedName("speed")
    @Expose
    private Double speed;

    public Wind() {
    }

    public Wind(Double speed) {
        this.speed = speed;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getFormattedSpeed() {
        return String.valueOf(speed) + " m/h";
    }
}
