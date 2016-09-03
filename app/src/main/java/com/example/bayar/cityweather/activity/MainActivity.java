package com.example.bayar.cityweather.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bayar.cityweather.R;
import com.example.bayar.cityweather.fragment.DetailFragment;
import com.example.bayar.cityweather.fragment.DialogAddItemFragment;
import com.example.bayar.cityweather.fragment.MainFragment;
import com.example.bayar.cityweather.model.City;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity
        implements DialogAddItemFragment.addCityInterface,
        MainFragment.OnItemSelectedInterface{

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    Unbinder unbinder;
    private MainFragment mMainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        showMainFragment();
    }

    private void showMainFragment() {
        Log.d(TAG, "showMainFragment: ");
        mMainFragment = MainFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, mMainFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    @OnClick(R.id.fab) void onFabClicked() {
        // when fab is clicked the dialog opens
        DialogAddItemFragment fragment = DialogAddItemFragment.newInstance();
        fragment.show(getSupportFragmentManager(), "dialog");
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
        unbinder.unbind();
    }

    @Override
    public void addCity(String cityName) {
        mMainFragment.fetchData(cityName);
    }

    @Override
    public void onItemClicked(City city) {
        DetailFragment fragment = DetailFragment.newInstance(city);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}


