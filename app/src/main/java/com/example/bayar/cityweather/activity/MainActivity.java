package com.example.bayar.cityweather.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bayar.cityweather.R;
import com.example.bayar.cityweather.fragment.MainFragment;
import com.example.bayar.cityweather.model.City;
import com.example.bayar.cityweather.rest.ApiClient;
import com.example.bayar.cityweather.rest.OpenWeatherMapService;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    private static final String API_KEY = "20506595c1c227a987bb75a5f0b26b1a";

    private OpenWeatherMapService service = ApiClient.getClient().create(OpenWeatherMapService.class);
    private Subscription apiSubscription;
    private List<City> mCityList = new ArrayList<>();
    private MainFragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fetchData("Moscow");
        fetchData("Ulan-Ude");

        showMainFragment();

    }

    private void showMainFragment() {
        Log.d(TAG, "showMainFragment: ");
        mMainFragment = MainFragment.newInstance(mCityList);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, mMainFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
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
                                e.printStackTrace();
                            }

                            @Override
                            public void onNext(City city) {
                                Log.d(TAG, "onNext: ");
                                mCityList.add(city);
                                mMainFragment.getAdapter().notifyItemInserted(mCityList.size() - 1);
                                Log.d(TAG, "onNext: city was added, mCityList.size() = " + mCityList.size());
                            }
                        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (apiSubscription != null && apiSubscription.isUnsubscribed()) {
            apiSubscription.unsubscribe();
        }
    }
}


