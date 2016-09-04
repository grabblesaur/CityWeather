
package com.example.bayar.cityweather.model;

import com.example.bayar.cityweather.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel(Parcel.Serialization.BEAN)
public class Weather {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("main")
    @Expose
    private String main;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("icon")
    @Expose
    private String icon;

    public Weather() {
    }

    public Weather(Long id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getDrawableId() {
        int matched = 0;
        for (int i = 0; i < DESCRIPTIONS.length; i++) {
            if (description.equals(DESCRIPTIONS[i])) {
                matched = i;
                break;
            }
        }
        return DAY_DESCRIPTIONS_IDS[matched];
    }

    private static String[] DESCRIPTIONS = {"clear sky", "few clouds", "scattered clouds", "broken clouds", "shower rain", "rain", "thunderstorm", "snow", "mist"};
    private static int[] DAY_DESCRIPTIONS_IDS = {R.drawable.sunny, R.drawable.cloudy_sunny, R.drawable.cloudy, R.drawable.very_cloudy, R.drawable.rainy, R.drawable.light_rain, R.drawable.lightning, R.drawable.snowy, R.drawable.mist};
}
