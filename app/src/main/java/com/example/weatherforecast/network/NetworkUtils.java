package com.example.weatherforecast.network;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.example.weatherforecast.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class NetworkUtils {

    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    private static final String WEATHER_ENDPOINT = "weather";
    private static final String FORECAST_ENDPOINT = "forecast";

    private static final String QUERY_PARAM = "q";
    private static final String FORMAT_PARAM = "mode";
    private static final String UNITS_PARAM = "units";
    private static final String LANG_PARAM = "lang";
    private static final String APP_ID_PARAM = "appid";

    private static final String FORMAT = "json";

    private static final String METRIC = "metric";
    private static final String IMPERIAL = "imperial";

    private static final String TAG = NetworkUtils.class.getSimpleName();

    public static URL getWeatherUrl(Context context) throws MalformedURLException {
        return buildURL(context, WEATHER_ENDPOINT);
    }

    private static URL buildURL(Context context, String endPoint) throws MalformedURLException {
        Uri.Builder builder = Uri.parse(BASE_URL+endPoint).buildUpon();
        Uri uri = builder
                .appendQueryParameter(QUERY_PARAM, context.getString(R.string.country_default))
                .appendQueryParameter(FORMAT_PARAM, FORMAT)
                .appendQueryParameter(UNITS_PARAM, METRIC)
                .appendQueryParameter(LANG_PARAM, Locale.getDefault().getLanguage())
                .appendQueryParameter(APP_ID_PARAM, context.getString(R.string.open_weather_api_key))
                .build();

        try {
            URL url = new URL(uri.toString());
            Log.i(TAG, uri+"");
            return url;
        }catch (MalformedURLException e){
            e.printStackTrace();
            return null;
        }
    }
}
