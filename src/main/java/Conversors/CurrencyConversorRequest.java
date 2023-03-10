package Conversors;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
public class CurrencyConversorRequest  {
    // create a URL object with the URL you want to request
    String apiKey = "p9kpyvmXswKAmaBGQNAzf1zkAXwnWLrks7VHXXUU";
    String base_currency = "USD";
    String currencies = "COP";
    String value = "100";

    public void request() throws IOException {
        String urlString = String.format("https://api.currencyapi.com/v3/latest?apikey=%s&value=%s&base_currency=%s&currencies=%s",
                apiKey, value, base_currency, currencies);
        URL url = new URL(urlString);

        // create an HttpURLConnection object
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

// set the request method to GET
        con.setRequestMethod("GET");


        // get the response code
        int responseCode = con.getResponseCode();

        // get the value of a specific header field
        String limitQuotaMinute = con.getHeaderField("X-RateLimit-Limit-Quota-Minute");
        String limitQuotaMonth = con.getHeaderField("X-RateLimit-Remaining-Quota-Month");

        // read the response body as a string
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }



        in.close();
        // close the HttpURLConnection object
        con.disconnect();

        // deserialize the response JSON into a Java object using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = objectMapper.readValue(response.toString(), Map.class);

        Map<String, Object> data = (Map<String, Object>) jsonMap.get("data");

        Map<String, Object> currency = (Map<String, Object>) data.get("COP");

        Double result = (Double) currency.get("value");



        System.out.println(result);
        System.out.println(responseCode);
        System.out.println("minute limit :" + limitQuotaMinute);
        System.out.println("month limit :" + limitQuotaMonth);

    }



}
