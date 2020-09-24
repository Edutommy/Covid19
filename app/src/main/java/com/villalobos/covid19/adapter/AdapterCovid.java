package com.villalobos.covid19.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.villalobos.covid19.DetailActivity;
import com.villalobos.covid19.R;
import com.villalobos.covid19.model.Covid;

import java.util.List;

public class AdapterCovid extends RecyclerView.Adapter<AdapterCovid.CovidHolder> {

    public Activity activity;
    List<Covid> list;
    public int item_covid;

    public AdapterCovid(Activity activity, List<Covid> list, int item_covid) {
        this.activity = activity;
        this.list = list;
        this.item_covid = item_covid;
    }

    @NonNull
    @Override
    public CovidHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_covid,parent,false);
        return new CovidHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidHolder holder, int position) {
        Covid covid = list.get(position);
        holder.item_country.setText(covid.Country);
        holder.item_cases.setText(covid.NewConfirmed);
        holder.item_code.setText(covid.CountryCode);

        //holder.item_totalRecovered.setText(covid.TotalRecovered);
        //holder.detail_totalConfirmed.setText(covid.TotalConfirmed);<
        //holder.item_newDead.setText(covid.NewDeaths);
        //holder.item_totalDead.setText(covid.TotalDeaths);
        //holder.item_newRecovered.setText(covid.NewRecovered);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CovidHolder extends RecyclerView.ViewHolder{

        TextView item_country, item_cases, item_code, detail_totalConfirmed, item_newDead,
                item_totalDead, item_newRecovered, item_totalRecovered;
        RelativeLayout item_card;

        public CovidHolder(View itemView) {
            super(itemView);
            item_country = itemView.findViewById(R.id.item_country);
            item_cases = itemView.findViewById(R.id.item_cases);
            item_code = itemView.findViewById(R.id.item_code);

            //detail_totalConfirmed = itemView.findViewById(R.id.detail_totalConfirmed);
            //item_newDead = itemView.findViewById(R.id.detail_newDead);
            //item_totalDead = itemView.findViewById(R.id.detail_totalDead);
            //item_newRecovered = itemView.findViewById(R.id.detail_newRecovered);
            //item_totalRecovered = itemView.findViewById(R.id.detail_totalRecovered);

            item_card = itemView.findViewById(R.id.item_card);
            item_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    Intent intent = new Intent(activity, DetailActivity.class);
                    intent.putExtra("COUNTRY", item_country.getText().toString());
                    intent.putExtra("CODE", item_code.getText().toString());
                    intent.putExtra("CASES", item_cases.getText().toString());


                    //intent.putExtra("TotalConfirmed", detail_totalConfirmed.getText().toString());
                    //intent.putExtra("NEWDEAD", item_newDead.getText().toString());
                    //intent.putExtra("TotalDead", item_totalDead.getText().toString());
                    //intent.putExtra("NewRecovered", item_newRecovered.getText().toString());
                    //intent.putExtra("TotalRecovered", item_totalRecovered.getText().toString());

                    activity.startActivity(intent);
                }
            });
        }
    }

}
