package com.example.easymenuplanner.searchRecipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPGet {

    public static String read(String query) throws IOException {
        // StringBuilder needed for modifying a string as a read in data.
        StringBuilder sb = new StringBuilder();
        try {
            // build a URL object to connect to the server
            URL urlObj = new URL(query);
            // Create the connections
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            // Create a BufferReader to read each line of the returned data
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // String to store string from bufferReader
            String str;
            do {
                str = bufferReader.readLine();
                if (str != null) {
                    sb.append(str);
                }
            }
            while (str != null);

            return sb.toString();

        } catch (IOException e) {
            throw e;
        }
    }
}
