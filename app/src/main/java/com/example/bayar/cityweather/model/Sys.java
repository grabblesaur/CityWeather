
package com.example.bayar.cityweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Parcel
public class Sys {

    @SerializedName("type")
    @Expose
    Long type;
    @SerializedName("id")
    @Expose
    Long id;
    @SerializedName("message")
    @Expose
    Double message;
    @SerializedName("country")
    @Expose
    String country;
    @SerializedName("sunrise")
    @Expose
    Long sunrise;
    @SerializedName("sunset")
    @Expose
    Long sunset;

    public Sys() {
    }

    public Sys(Long type, Long id, Double message, String country, Long sunrise, Long sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    public List<String> getFormattedSunSetRise() {
        List<String> result = new ArrayList<>();

        Date sunriseDate = new Date(sunrise*1000);
        Date sunsetDate = new Date(sunset*1000);

        String pattern = "HH:mm";
        DateFormat df = SimpleDateFormat.getDateTimeInstance();

        result.add(df.format(sunriseDate));
        result.add(df.format(sunsetDate));

        return result;
    }
}
