package com.vpbank.webapisimple.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.vpbank.webapisimple.R;
import com.vpbank.webapisimple.weather.model.MainWeather;
import com.vpbank.webapisimple.weather.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class WeatherMap extends AppCompatActivity {
    private static final String TAG = "WeatherMap";
    TextView tvShowJson;
    String urlApiNew = "https://demo5639557.mockable.io/getWeather";
    List<Weather> weathers;

    JSONObject jsonob;
    JSONArray jsonArray;
    MainWeather mainWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_map);
        tvShowJson = findViewById(R.id.tvShowJson);
        new DoGetData(urlApiNew).execute();

    }

    private void getJsonMain(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject jsonob = jsonObject.getJSONObject("main");

//            MainWeather mainWeather;
            mainWeather = new MainWeather(
                    jsonob.getString("temp"),
                    jsonob.getString("pressure"),
                    jsonob.getString("humidity"),
                    jsonob.getString("temp_min"),
                    jsonob.getString("temp_max")
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getJsonArray(String json) {
//        List<Weather> weathers;
        if (weathers == null) weathers = new ArrayList<>();
        //Bóc dữ liệu từ JsonArray
        try {
            JSONObject jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray("weather");
            int length = jsonArray.length();

            for (int i = 0; i < length; i++) {
                JSONObject ob = jsonArray.getJSONObject(i);
                String id = ob.getString("id");
                String main = ob.getString("main");
                String description = ob.getString("description");
                String icon = ob.getString("icon");
                weathers.add(new Weather(id, main, description, icon));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    class DoGetData extends AsyncTask<Void, Void, Void> {
        String urlApi;
        String result = "";

        public DoGetData(String urlApi) {
            this.urlApi = urlApi;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(urlApi);
                URLConnection connection = url.openConnection();
                InputStream is = connection.getInputStream();
                int byteCharacter;

                while ((byteCharacter = is.read()) != -1) {
                    result += (char) byteCharacter;
                }

                Log.d(TAG, "doInBackground: " + result);

                // bóc tách dữ liệu là json object
                getJsonMain(result);

                //bóc tách dữ liệu là json Array
                getJsonArray(result);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tvShowJson.setText(mainWeather.getTemp() + "\n" + weathers.get(0).getDescription());
        }
    }
}
