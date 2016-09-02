
package com.example.bayar.cityweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Main {

    @SerializedName("temp")
    @Expose
    Double temp;
    @SerializedName("pressure")
    @Expose
    Long pressure;
    @SerializedName("humidity")
    @Expose
    Long humidity;
    @SerializedName("temp_min")
    @Expose
    Double tempMin;
    @SerializedName("temp_max")
    @Expose
    Double tempMax;

    public Main() {
    }

    public Main(Double temp, Long pressure, Long humidity, Double tempMin, Double tempMax) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Long getPressure() {
        return pressure;
    }

    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public String getFormattedTemp() {
        return String.valueOf(temp) + "°C";
    }
}
