package com.vpbank.webapisimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonWebAPI extends AppCompatActivity {
    String json = "{ \"temp\": 289.92, \"pressure\": 1009, \"humidity\": 92, \"temp_min\": 288.71, \"temp_max\": 290.93 }";

    TextView tvJson;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_web_api);
        tvJson = findViewById(R.id.tvJson);

        try {
            JSONObject jsonObject = new JSONObject(json);

            double temp = jsonObject.getDouble("temp");
            String temp_min = jsonObject.getString("temp_min");
            String temp_max = jsonObject.getString("temp_max");

            tvJson.setText(temp + "\n" + temp_min + "\n" + temp_max);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
