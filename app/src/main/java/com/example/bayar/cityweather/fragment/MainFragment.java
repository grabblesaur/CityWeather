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

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    public static final String LIST_KEY = "qwegfdsa";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    Unbinder unbinder;
    List<City> mCityList;
    Context mContext;
    private CitiesAdapter mAdapter;

    public MainFragment() {
    }

    public static MainFragment newInstance(List<City>cityList) {
        Log.d(TAG, "newInstance: ");
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(LIST_KEY, Parcels.wrap(cityList));
        fragment.setArguments(bundle);
        return fragment;
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

        mCityList = Parcels.unwrap(getArguments().getParcelable(LIST_KEY));
        mAdapter = new CitiesAdapter(mCityList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView: ");
        super.onDestroyView();
        unbinder.unbind();
    }

    public CitiesAdapter getAdapter() {
        return mAdapter;
    }
}
