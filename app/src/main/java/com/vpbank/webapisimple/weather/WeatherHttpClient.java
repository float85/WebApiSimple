package com.vpbank.webapisimple.weather;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by tienh on 4/4/2017.
 */

public class WeatherHttpClient {

    HttpURLConnection con = null;
    InputStream is = null;
    SharedPreferences sharedPreferences;
    Context context;
    SharedPreferences.Editor editor;

    public WeatherHttpClient(Context context) {
        this.context = context;
    }

    public void LoadWeather(String city, TextView tvtemp) {

        new HttpWeacherCity(tvtemp,context).execute(city);
    }

    public String getWeatherData(String city) {

        String str = null;
        String url = Define.API_WEACHER + city + Define.API_WEACHER_METRIC + "&appid=" + Define.API_WEACHER_KEY;


        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            str = response.toString();

            //print result
            Log.d("res:", response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public class HttpWeacherCity extends AsyncTask<String, Void, String> {
        WeatherHttpClient httpClient;
        TextView tvTemp;
        Context context;

        public HttpWeacherCity(TextView tvTemp, Context context) {
            this.tvTemp = tvTemp;
            this.context=context;
        }

        @Override
        protected String doInBackground(String... params) {
            httpClient = new WeatherHttpClient(context);
            int temp = 0;

            try {
                String strJson = httpClient.getWeatherData(params[0]);

                JSONObject jObj = new JSONObject(strJson);
                JSONObject subObj = jObj.getJSONObject("main");

                temp = subObj.getInt("temp");

            } catch (Exception e) {
                e.printStackTrace();
            }
            return String.valueOf(temp);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvTemp.setText(s+"°C");
            sharedPreferences =context.getSharedPreferences("thongtin",context.MODE_PRIVATE);
            editor=sharedPreferences.edit();
            editor.putString("nhietdo",s+"°C");
            editor.commit();

        }
    }


}
