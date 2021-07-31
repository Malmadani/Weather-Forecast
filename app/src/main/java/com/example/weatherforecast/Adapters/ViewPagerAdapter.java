package com.example.weatherforecast.Adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.weatherforecast.Fragments.FragmentPrimaryWeatherHeader;
import com.example.weatherforecast.Fragments.FragmentSecondaryWeatherHeader;
import com.example.weatherforecast.entity.WeatherInfo;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);

        fragments = new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentPrimaryWeatherHeader();
            case 1:
                return new FragmentSecondaryWeatherHeader();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        fragments.add(fragment);
        return fragment;
    }

    public void updateData(WeatherInfo weatherInfo){
        ((FragmentPrimaryWeatherHeader)fragments.get(0)).updateData(weatherInfo);
    }
}
