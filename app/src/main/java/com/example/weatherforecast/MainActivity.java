package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.weatherforecast.Adapters.DaysAdapter;
import com.example.weatherforecast.Adapters.HoursAdapter;
import com.example.weatherforecast.Adapters.ViewPagerAdapter;
import com.example.weatherforecast.entity.WeatherInfo;
import com.example.weatherforecast.network.NetworkUtils;
import com.example.weatherforecast.utils.OpenWeatherApiInterface;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private ViewPagerAdapter adapter;

    private RequestQueue requestQueue;

    private RecyclerView mRe_Hours;
    private RecyclerView mRe_Day;

    private HoursAdapter hoursAdapter;
    private DaysAdapter daysAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        hoursAdapter = new HoursAdapter(this);
        mRe_Hours = findViewById(R.id.re_hours);
        mRe_Hours.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mRe_Hours.setAdapter(hoursAdapter);
        
        try {
            requestWeatherInfo();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void requestWeatherInfo() throws MalformedURLException {
        String  weatherUrl = NetworkUtils.getWeatherUrl(this).toString();

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET
                , weatherUrl
                , null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        WeatherInfo weatherInfo = null;

                        try {
                            weatherInfo = OpenWeatherApiInterface.getWeatherInfo(response);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (weatherInfo != null){
                            adapter.updateData(weatherInfo);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getBaseContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue.add(request);
    }
}