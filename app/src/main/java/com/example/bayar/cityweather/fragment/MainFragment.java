package com.example.bayar.cityweather.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bayar.cityweather.R;
import com.example.bayar.cityweather.adapter.CitiesAdapter;
import com.example.bayar.cityweather.model.City;
import com.example.bayar.cityweather.rest.ApiClient;
import com.example.bayar.cityweather.rest.OpenWeatherMapService;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    private static final String API_KEY = "20506595c1c227a987bb75a5f0b26b1a";

    private OpenWeatherMapService service = ApiClient.getClient().create(OpenWeatherMapService.class);
    private Subscription apiSubscription;
    private List<City> mCityList = new ArrayList<>();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    Unbinder unbinder;
    Context mContext;
    private CitiesAdapter mAdapter;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        Log.d(TAG, "newInstance: ");
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach: ");
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: ");
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);

        mAdapter = new CitiesAdapter(mCityList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);

        fetchData("Moscow");
    }

    public void fetchData(String cityName) {
        Log.d(TAG, "fetchData: city: " + cityName);
        apiSubscription =
                service.getCityWeatherByName(cityName, API_KEY)
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Subscriber<City>() {
                            @Override
                            public void onCompleted() {
                                Log.d(TAG, "onCompleted: ");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.d(TAG, "onError: " + e);
                            }

                            @Override
                            public void onNext(City city) {
                                Log.d(TAG, "onNext: ");
                                mCityList.add(city);
                                mAdapter.notifyItemInserted(mCityList.size() - 1);
                                Log.d(TAG, "onNext: city was added, mCityList.size() = " + mCityList.size());
                            }
                        });
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView: ");
        super.onDestroyView();
        unbinder.unbind();
        if (apiSubscription != null && apiSubscription.isUnsubscribed()) {
            apiSubscription.unsubscribe();
        }
    }
}
