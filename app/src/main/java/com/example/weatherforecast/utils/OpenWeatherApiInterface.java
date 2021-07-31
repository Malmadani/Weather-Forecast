package com.example.weatherforecast.utils;

import com.example.weatherforecast.entity.Main;
import com.example.weatherforecast.entity.Weather;
import com.example.weatherforecast.entity.WeatherInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OpenWeatherApiInterface {

    private static final String OWM_WEATHER = "weather";
    private static final String OWM_MAIN = "main";
    private static final String OWM_DESCRIPTION = "description";
    private static final String OWM_ICON = "icon";
    private static final String OWM_NAME = "name";
    private static final String OWM_TEMP = "temp";
    private static final String OWM_TEMP_MAX = "temp_max";
    private static final String OWM_TEMP_MIN = "temp_min";
    private static final String OWM_PRESSURE = "pressure";
    private static final String OWM_HUMIDITY = "humidity";

    public static WeatherInfo getWeatherInfo(JSONObject response) throws JSONException {

        JSONObject weatherJsonObject = response.getJSONArray(OWM_WEATHER).getJSONObject(0);

        JSONObject mainJsonObject = response.getJSONObject(OWM_MAIN);

        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setName(response.has(OWM_NAME) ? response.getString(OWM_NAME) : "");
        Weather weather = new Weather();
        weather.setMain(weatherJsonObject.getString(OWM_MAIN));
        weather.setDescription(weatherJsonObject.getString(OWM_DESCRIPTION));
        weather.setIcon(weatherJsonObject.getString(OWM_ICON));
        List<Weather> weathersList = new ArrayList<>();
        weathersList.add(weather);
        weatherInfo.setWeathers(weathersList);
        Main main = new Main();
        main.setTemp(mainJsonObject.getString(OWM_TEMP));
        main.setTempMax(mainJsonObject.getString(OWM_TEMP_MAX));
        main.setTempMin(mainJsonObject.getString(OWM_TEMP_MIN));
        main.setPressure(mainJsonObject.getString(OWM_PRESSURE));
        main.setHumidity(mainJsonObject.getString(OWM_HUMIDITY));
        weatherInfo.setMain(main);

        return weatherInfo;
    }
}
