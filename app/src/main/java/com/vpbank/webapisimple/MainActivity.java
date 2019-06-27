package com.vpbank.webapisimple;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView tvJson, tvJsonAray, tvJsonArayAPI;
    Button btnGetAPI;
    ProgressBar progressBar;
    String urlApi = "https://demo9377585.mockable.io/getProduct";

    String json = "{ \"id\": \"01\", \"name\": \"Coca\", \"price\": \"66\" }";
    String jArray = "[ { \"id\": \"01\", \"name\": \"Coca\", \"price\": \"66\" }, { \"id\": \"02\", \"name\": \"Pepsi\", \"price\": \"88\" }, { \"id\": \"03\", \"name\": \"Sting\", \"price\": \"99\" }]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvJson = findViewById(R.id.tvJson);
        tvJsonAray = findViewById(R.id.tvJsonArray);
        tvJsonArayAPI = findViewById(R.id.tvJsonArrayAPI);
        btnGetAPI = findViewById(R.id.btnGetJson);
        progressBar = findViewById(R.id.prBar);


        getJsonObject();

        getJsonArray(jArray);

        btnGetAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DoGetData(urlApi).execute();

            }
        });


    }

    private void getJsonObject() {
        //bóc dữ liệu từ Json
        try {
            JSONObject jsonObject = new JSONObject(json);
            String id = jsonObject.getString("id");
            String name = jsonObject.getString("name");
            String price = jsonObject.getString("price");

            tvJson.setText("id: " + id + "\nname: " + name + "\nprice: " + price);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void getJsonArray(String json) {
        //Bóc dữ liệu từ JsonArray
        try {
            JSONArray jsonArray = new JSONArray(json);
            int length = jsonArray.length();
            String strJson = "";

            for (int i = 0; i < length; i++) {

                JSONObject ob = jsonArray.getJSONObject(i);
                String id = ob.getString("id");
                String name = ob.getString("name");
                String price = ob.getString("price");

                strJson += "\nid: " + id + " name: " + name + " price: " + price;
            }

            tvJsonAray.setText(strJson);
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
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);

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

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            tvJsonArayAPI.setText(result);
            progressBar.setVisibility(View.GONE);

        }
    }

}
