package com.villalobos.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.villalobos.covid19.adapter.AdapterCovid;
import com.villalobos.covid19.model.Covid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private static final String URL="https://api.covid19api.com/summary";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processHttp();
    }

    public void processHttp(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(URL, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String data = new String(responseBody);
                Log.d("INFO", data);
                processCovid(data);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void processCovid(String data) {
        try {
            JSONObject root = new JSONObject(data);
            JSONArray country = root.getJSONArray("Countries");

            List<Covid> list = new ArrayList<>();

            for(int i = 0; i<country.length(); i++) {
                JSONObject country1 = country.getJSONObject(i);

                String Country = country1.getString("Country");
                String CountryCode = country1.getString("CountryCode");
                String NewConfirmed = country1.getString("NewConfirmed");

                String TotalConfirmed = country1.getString("TotalConfirmed");
                String NewDeaths = country1.getString("NewDeaths");
                String TotalDeaths = country1.getString("TotalDeaths");
                String NewRecovered = country1.getString("NewRecovered");
                String TotalRecovered = country1.getString("TotalRecovered");

                Covid covid = new Covid(Country, CountryCode, NewConfirmed, TotalConfirmed, NewDeaths, TotalDeaths, NewRecovered, TotalRecovered);
                list.add(covid);

            }

            //cargar el recycle
            RecyclerView rc = findViewById(R.id.rc_covid);
            AdapterCovid ad = new AdapterCovid(this,list,R.layout.item_covid);
            LinearLayoutManager lm = new LinearLayoutManager(this);
            lm.setOrientation(RecyclerView.VERTICAL);

            rc.setLayoutManager(lm);
            rc.setAdapter(ad);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}