package com.example.weatherforecast.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherforecast.R;
import com.example.weatherforecast.entity.Forecast;

import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DaysViewHolder>{

    private Context mContext;
    private List<Forecast> forecasts;

    public DaysAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public DaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.days_forecast_item, parent, false);
        return new DaysViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaysViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (forecasts == null){
            return 0;
        }else {
            return forecasts.size();
        }
    }

    class DaysViewHolder extends RecyclerView.ViewHolder{

        private TextView mDayForecast;
        private ImageView mWeatherIcon;
        private TextView mHeightTemp;
        private TextView mLowTemp;

        public DaysViewHolder(@NonNull View itemView) {
            super(itemView);

            mDayForecast = itemView.findViewById(R.id.day_forecast);
            mWeatherIcon = itemView.findViewById(R.id.weather_icon);
            mHeightTemp = itemView.findViewById(R.id.height_temp);
            mLowTemp = itemView.findViewById(R.id.low_temp);
        }
    }
}
