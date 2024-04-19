package com.example.proj2.Classes;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.logging.type.HttpRequest;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import okhttp3.OkHttpClient;

public final class HTTP_Request {
    private HTTP_Request() {}

    public static void  requestURL(){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
                URL url = new URL("https://ddragon.leagueoflegends.com/cdn/14.6.1/data/en_US/champion.json");
                HttpURLConnection client = (HttpURLConnection) url.openConnection();
                client.setRequestProperty("Content-Type", "application/json");
                client.setRequestProperty("Accept", "application/json");
                client.setRequestMethod("POST");
                client.setDoOutput(true);
                try (BufferedReader br = new BufferedReader(
                        new InputStreamReader(client.getInputStream(), "utf-8"))) {

                    // on below line creating a string builder.
                    StringBuilder response = new StringBuilder();

                    // on below line creating a variable for response line.
                    String responseLine = null;

                    // on below line writing the response
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }


}
