package com.example.bayar.cityweather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bayar.cityweather.R;
import com.example.bayar.cityweather.model.City;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder> {
    private List<City> mCityList;

    public CitiesAdapter(List<City> cityList) {
        mCityList = cityList;
    }

    @Override
    public CitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new CitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CitiesViewHolder holder, int position) {
        City currentCity = mCityList.get(position);
        holder.setUpViews(currentCity, position);
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }

    public class CitiesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.list_item_icon_weather)
        ImageView iconWeather;
        @BindView(R.id.list_item_current_temperature)
        TextView temperature;
        @BindView(R.id.list_item_city_name)
        TextView cityName;

        public CitiesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setUpViews(City city, int position) {
            iconWeather.setImageResource(city.getWeather().get(0).getDrawableId());
            temperature.setText(city.getMain().getFormattedTemp());
            cityName.setText(city.getName());
        }
    }
}
