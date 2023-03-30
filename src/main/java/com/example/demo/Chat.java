package com.example.demo;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Scanner;

public class Chat {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String prompt;
        Api api = new Api();

        while(true){
            System.out.println("Prompt:");
            prompt=scanner.nextLine();
            String response = api.api_call(prompt);
            String[] sentences = response.split("\\.");
            String formattedResponse = String.join(".\n", sentences);
            System.out.println("Ai: \n"+formattedResponse.trim());

        }

    }
}
