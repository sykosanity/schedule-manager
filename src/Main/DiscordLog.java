package Main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DiscordLog {

    private static final String WEBHOOK_URL = "https://discord.com/api/webhooks/1354704944657076315/M6tMog6uhpEYRLLywQEiALtrCEZnoCyoYBtaeki8Xhb60BwGxm2OJNUjc1aBflTk3V8B";

    public static void log(String message) {
        try {
            URL url = new URL(WEBHOOK_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String jsonPayload = "{\"content\": \"" + message + "\"}";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonPayload.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode != 204) {
                System.out.println("Failed to send log: HTTP " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        log("Hello, Discord! This is a test log message.");
    }
}
