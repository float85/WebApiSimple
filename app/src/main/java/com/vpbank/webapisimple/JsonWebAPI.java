package com.vpbank.webapisimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonWebAPI extends AppCompatActivity {
    String json = "{ \"temp\": 289.92, \"pressure\": 1009, \"humidity\": 92, \"temp_min\": 288.71, \"temp_max\": 290.93 }";
    String jsonArray = "[ { \"id\": 300, \"main\": \"Drizzle\", \"description\": \"light intensity drizzle\", \"icon\": \"09d\" }, { \"id\": 200, \"main\": \"Manh\", \"description\": \"light intensity drizzle\", \"icon\": \"09d\" } ]";

    TextView tvJson;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_web_api);
        tvJson = findViewById(R.id.tvJson);

        //Lấy dữ liệu từ Json Object
//        getJson();

        // Lấy dữ liệu từ Json Array
        getJsonArray();

    }

    private void getJson() {
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

    private void getJsonArray() {
        try {
            JSONArray jArray = new JSONArray(jsonArray);

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jsonObject = jArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String main = jsonObject.getString("main");
                String des = jsonObject.getString("description");
                String icon = jsonObject.getString("icon");

                result += "\nid: " + id + " main: " + main + " des: " +
                        des + " icon: " + icon;
            }
            tvJson.setText(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
