package com.example.bayar.cityweather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bayar.cityweather.R;
import com.example.bayar.cityweather.activity.MainActivity;
import com.example.bayar.cityweather.model.City;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder> {
    private List<City> mCityList;
    private MainActivity mListener;

    public CitiesAdapter(List<City> cityList, MainActivity listener) {
        mCityList = cityList;
        mListener = listener;
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

        private int mPosition;
        private City mCurrentCity;

        public CitiesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setUpViews(City city, int position) {
            iconWeather.setImageResource(city.getWeather().get(0).getDrawableId());
            temperature.setText(city.getMain().getFormattedTemp());
            cityName.setText(city.getName());

            mPosition = position;
            mCurrentCity = city;
        }

        @OnClick(R.id.list_item_icon_delete) void onItemDelete(View view) {
            delete(mPosition);
        }

        @OnClick(R.id.item) void onItemClicked() {
            mListener.onItemClicked(mCurrentCity);
        }
    }

    private void delete(int position) {
        mCityList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mCityList.size());
    }
}
