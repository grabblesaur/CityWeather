package com.example.bayar.cityweather.rest;

import com.example.bayar.cityweather.model.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface OpenWeatherMapService {
//    api.openweathermap.org/data/2.5/weather?units=metric&q=Ulan-Ude&appid=20506595c1c227a987bb75a5f0b26b1a
    @GET("weather/?units=metric")
    Observable<City> getCityWeatherByName(@Query("q") String name, @Query("appid") String appid);

    @GET("weather/?units=metric")
    Call<City> getCityWeatherByNameOld(@Query("q") String name, @Query("appid") String appid);
}
