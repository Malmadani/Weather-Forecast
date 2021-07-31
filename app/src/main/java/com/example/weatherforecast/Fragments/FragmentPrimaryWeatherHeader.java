package com.example.weatherforecast.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.weatherforecast.R;
import com.example.weatherforecast.entity.WeatherInfo;

public class FragmentPrimaryWeatherHeader extends Fragment {

    private WeatherInfo mWeatherInfo;

    private TextView mCountry;
    private TextView mPresentDay;
    private TextView mTodayTemperature;
    private TextView mHighLowTempView;
    private TextView mWeatherDescription;
    private ImageView mIconWeather;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_primary_weather_header, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View itemView = getView();

        mCountry = itemView.findViewById(R.id.country);
        mPresentDay = itemView.findViewById(R.id.present_day);
        mTodayTemperature = itemView.findViewById(R.id.today_temperature);
        mHighLowTempView = itemView.findViewById(R.id.today_weather_description);
        mWeatherDescription = itemView.findViewById(R.id.weather_description);
        mIconWeather = itemView.findViewById(R.id.icon_weather);

        showWeatherInfo();
    }

    public void updateData(WeatherInfo weatherInfo){
        this.mWeatherInfo = weatherInfo;
        showWeatherInfo();
    }

    private void showWeatherInfo() {

        if (mWeatherInfo == null){
            return;
        }

        String countryTextView = mWeatherInfo.getName();

        mCountry.setText(countryTextView);

        String presentDay = "fiday";

        mPresentDay.setText(presentDay);

        String todayTemperatureTextView = 30+"";

        mTodayTemperature.setText(todayTemperatureTextView);

        int weatherIcon = R.drawable.ic_clear_sky;

        mIconWeather.setImageResource(weatherIcon);

        String highLowTempView = mWeatherInfo.getMain().getTempMax() + mWeatherInfo.getMain().getTempMin();

        mHighLowTempView.setText(highLowTempView);

        String weatherDescription = mWeatherInfo.getWeathers().get(0).getDescription();

        mWeatherDescription.setText(weatherDescription);

    }
}
