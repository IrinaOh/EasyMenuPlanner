package com.example.easymenuplanner.searchRecipe;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class SearchRecipesApi {
    //example below:
    //https://api.edamam.com/search?q=fish&app_id=661c2e42&app_key=f2af3a7c771087f4a37bfadb93a34d97
    private final String app_id = "661c2e42";
    private final String api_key = "f2af3a7c771087f4a37bfadb93a34d97";
    private final String baseUrl = "https://api.edamam.com/search";
    private Gson gson;

    public SearchRecipesApi() {
        gson = new Gson();
    }

    public ApiRecipes getRecipes(String searchItem) {
        String url = baseUrl +
                "?q=" + searchItem +
                "&app_id" + app_id +
                "&api_key=" + api_key;
        String data = loadJsonData(url);

        // Convert JSON data to WeatherConditions object
        return gson.fromJson(data, ApiRecipes.class);
    }

    private String loadJsonData(String url) {
        StringBuilder data = new StringBuilder();
        try {
            URL urlObj = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Read all data from the website into a single string
            String line;
            do {
                line = reader.readLine();
                if (line != null) {
                    data.append(line);
                }
            }
            while (line != null);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.toString();
    }

}
