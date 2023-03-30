package com.example.demo;
import javafx.application.Platform;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.*;

import java.io.IOException;

public class Api {

    private static final String OPENAI_API_KEY = "YOUR OPENAPI KEY";
    public String final_result_from_Bot;

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    public String api_call(String userMessage){
        try {
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType,
                    "{\"model\": \"text-davinci-003\"," +
                            "\"prompt\": \"" + userMessage + "\"," +
                            "\"temperature\": 0," +
                            "\"max_tokens\": 4000}");

            Request request = new Request.Builder()
                    .url("https://api.openai.com/v1/completions")
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + OPENAI_API_KEY)
                    .build();

            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            JSONObject jsonObject = new JSONObject(responseBody);
            String chatBotMessage = jsonObject.getJSONArray("choices")
                    .getJSONObject(0)
                    .getString("text");
            return chatBotMessage;
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred while communicating with the OpenAI API.";
        }
    }

}
