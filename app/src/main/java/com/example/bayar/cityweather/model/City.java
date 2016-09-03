
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
public class City {

    @SerializedName("coord")
    @Expose
    Coord coord;
    @SerializedName("weather")
    @Expose
    List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("base")
    @Expose
    String base;
    @SerializedName("main")
    @Expose
    Main main;
    @SerializedName("visibility")
    @Expose
    Long visibility;
    @SerializedName("wind")
    @Expose
    Wind wind;
    @SerializedName("clouds")
    @Expose
    Clouds clouds;
    @SerializedName("dt")
    @Expose
    Long dt;
    @SerializedName("sys")
    @Expose
    Sys sys;
    @SerializedName("id")
    @Expose
    Long id;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("cod")
    @Expose
    Long cod;

    public City() {
    }

    public City(Coord coord, List<Weather> weather, String base, Main main, Long visibility, Wind wind, Clouds clouds, Long dt, Sys sys, Long id, String name, Long cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Long getVisibility() {
        return visibility;
    }

    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getFormattedDate() {
        Date date = new Date(dt*1000);
        DateFormat dateFormat =
                SimpleDateFormat.getDateTimeInstance(SimpleDateFormat.LONG, SimpleDateFormat.LONG);
        return dateFormat.format(date);
    }
}
