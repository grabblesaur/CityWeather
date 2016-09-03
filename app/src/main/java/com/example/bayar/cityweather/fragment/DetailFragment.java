package com.example.bayar.cityweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bayar.cityweather.R;
import com.example.bayar.cityweather.model.City;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DetailFragment extends Fragment {

    private static final String KEY_CITY = "city";

    @BindView(R.id.detail_city_name)
    TextView cityName;
    @BindView(R.id.detail_date)
    TextView date;
    @BindView(R.id.detail_description)
    TextView description;
    @BindView(R.id.detail_temp)
    TextView detailTemp;
    @BindView(R.id.detail_weather_icon)
    ImageView weatherIcon;
    @BindView(R.id.detail_wind)
    TextView wind;
    @BindView(R.id.detail_cloudy)
    TextView cloudy;
    @BindView(R.id.detail_humidity)
    TextView humidity;
    @BindView(R.id.detail_pressure)
    TextView pressure;
    @BindView(R.id.sunrise)
    TextView sunrise;
    @BindView(R.id.sunset)
    TextView sunset;

    Unbinder unbinder;
    private City mCity;

    public static DetailFragment newInstance(City city) {
        DetailFragment fragment = new DetailFragment();
        Bundle bundle = new Bundle(1);
        bundle.putParcelable(KEY_CITY, Parcels.wrap(city));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        mCity = Parcels.unwrap(getArguments().getParcelable(KEY_CITY));
        setUpViews(mCity);
    }

    private void setUpViews(City city) {
        cityName.setText(city.getName());
        date.setText(city.getFormattedDate());
        description.setText(city.getWeather().get(0).getDescription());
        detailTemp.setText(city.getMain().getFormattedTemp());
        weatherIcon.setImageResource(city.getWeather().get(0).getDrawableId());
        wind.setText(city.getWind().getFormattedSpeed());
        cloudy.setText(city.getClouds().getFormattedClouds());
        humidity.setText(city.getMain().getFormattedHumidity());
        pressure.setText(city.getMain().getFormattedPressure());
        sunrise.setText(city.getSys().getFormattedSunSetRise().get(0));
        sunset.setText(city.getSys().getFormattedSunSetRise().get(1));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
