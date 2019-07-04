package com.vpbank.webapisimple.weather;

/**
 * Created by tienh on 7/3/2017.
 */

public class Define {
    public static final String DB_THELOAI = "theloai";
    public static final String DB_TOKEN = "token";
    public static final String DB_UNGDUNG = "ungdung";
    public static final String DB_ANHCHITIET = "anhchitiet";
    public static final String DB_CITY = "thoitiet";
    public static final String DB_THELOAIUNGDUNG = "theloai_ungdung";
    public static final String DB_LOAIQC = "loaiquangcao";
    public static final String DB_QUANGCAO = "quangcao";

    public static final String DB_NAME = "kiwistore.db";
//    public static final String DB_NAME = "kiwistore.sqlite";
    public static final String DB_FOLDER_PATH = "/data/data/com.example.tienh.kiwistore10/databases/";
    public static final int DB_VERSION = 1;
    public static final String DEFAULT_PHONE_NUMBER = "0988888888888";
    public final static String URL_WEATHER = "http://api.openweathermap.org/data/2.5/forecast?id=";

    public final static String APIKEY = "1fd660e2a27afad8b71405f654997a62";

//    public static final String IP_SERVER = "store.kiwi.vn/";
//    public static final String IP_SERVER = "devkiwi.websumo.vn/";
    public static final String IP_SERVER = "kiwi.websumo.vn/";
    public static final String API_TOKEN = "?token=";

    public static final int NUMBER_RESULT_FULL = 50;
    public static final int NUMBER_RESULT_WEB = 100;
    public static final String API_KEY = "&key=Qm7o4R6Stjn9F54tMVA6jmIeI9OZhdn3LMOuTkg4";
    public static final String API_KEY_RX = "Qm7o4R6Stjn9F54tMVA6jmIeI9OZhdn3LMOuTkg4";
    public static final String BASE_URL = "http://" + IP_SERVER + "getjson";
    public static final String API_UNGDUNG = BASE_URL + API_TOKEN + "&table=" + DB_UNGDUNG + API_KEY;
    public static final String API_THELOAI = BASE_URL + API_TOKEN + "&table=" + DB_THELOAI + API_KEY;
    public static final String API_ANHCHITIET = BASE_URL + API_TOKEN + "&table=" + DB_ANHCHITIET + API_KEY;
    public static final String API_THELOAI_UNGDUNG = BASE_URL + API_TOKEN + "&table=" + DB_THELOAIUNGDUNG + API_KEY;
    public static final String API_QUANGCAO = BASE_URL + API_TOKEN + "&table=" + DB_QUANGCAO + API_KEY;
    public static final String API_LOAIQC = BASE_URL + API_TOKEN + "&table=" + DB_LOAIQC + API_KEY;

    public static final String URL_GET_TOKEN = "http://" + IP_SERVER + "getapi";

    public static final String API_WEACHER="http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String API_WEACHER_KEY="7d11e93343d3a96a95e550224da110be";
    public static final String API_WEACHER_METRIC="&units=metric";


}
