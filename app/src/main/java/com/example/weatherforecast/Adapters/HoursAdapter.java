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

public class HoursAdapter extends RecyclerView.Adapter<HoursAdapter.HoursViewHolder> {

    private Context mContext;
    private List<Forecast> forecasts;

    public HoursAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public HoursViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.hours_forecast_item, parent, false);
        return new HoursViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoursViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (forecasts == null){
            return 0;
        }else {
            return forecasts.size();
        }
    }

    class HoursViewHolder extends RecyclerView.ViewHolder{

        private TextView mDate;
        private ImageView mWeatherIcon;
        private TextView mHourTemp;

        public HoursViewHolder(@NonNull View itemView) {
            super(itemView);

            mDate = itemView.findViewById(R.id.date);
            mWeatherIcon = itemView.findViewById(R.id.weather_icon);
            mHourTemp = itemView.findViewById(R.id.hour_temp);
        }
    }
}
