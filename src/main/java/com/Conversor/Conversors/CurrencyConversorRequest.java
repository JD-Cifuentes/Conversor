package com.Conversor.Conversors;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class CurrencyConversorRequest  {
    private final String apiKey = "LTdyotiPSw2GuUFKvcsYjHtqGehobiSCcB5GdzLp";
    private String baseCurrency;
    private String toCurrency;
    private String value;
    private String monthLimit;
    private String minLimit;
    private double result;
    private String apiStatus;

    public CurrencyConversorRequest(String baseCurrency, String toCurrency, String value) throws IOException {
        this.baseCurrency = baseCurrency;
        this.toCurrency = toCurrency;
        this.value = value;
        request();
    }

    public void request() throws IOException {
        String urlString = String.format("https://api.currencyapi.com/v3/latest?apikey=%s&value=%s&base_currency=%s&currencies=%s",
                this.apiKey, value, baseCurrency, toCurrency);
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int statusCode = con.getResponseCode();
        this.minLimit = con.getHeaderField("X-RateLimit-Limit-Quota-Minute");
        this.monthLimit = con.getHeaderField("X-RateLimit-Remaining-Quota-Month");

        if(statusCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            con.disconnect();

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(response.toString(), Map.class);
            Map<String, Object> data = (Map<String, Object>) jsonMap.get("data");
            Map<String, Object> currency = (Map<String, Object>) data.get(toCurrency);
            this.apiStatus = "Ejecución exitosa";
            this.result = (double) currency.get("value") * Double.parseDouble(value);
        }else if(statusCode == 429){
            this.apiStatus = "Se ha alcanzado el límite de consultas mensual para el plan gratuito. Contactanos si quieres pasar a premium.";
            this.result = 0.0;
        }else{
            this.apiStatus = "Oops lo sentimos, al parecer tenemos algunos inconvenientes. Intenta nuevamente o ponte en contacto con nosotros si el problema persiste.";
            this.result = 0.0;
        }
    }

    public String getMonthLimit() {
        return monthLimit;
    }
    public String getMinLimit() {
        return minLimit;
    }
    public double getResult() {
        return result;
    }
    public String getApiStatus() {
        return apiStatus;
    }
}
