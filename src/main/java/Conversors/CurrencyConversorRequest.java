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
    private final String apiKey = "p9kpyvmXswKAmaBGQNAzf1zkAXwnWLrks7VHXXUU";
    private String baseCurrency;
    private String toCurrency;
    private String value;

    public CurrencyConversorRequest(String baseCurrency, String toCurrency, String value) throws IOException {
        this.baseCurrency = baseCurrency;
        this.toCurrency = toCurrency;
        this.value = value;
    }

    public Double request() throws IOException {

        String urlString = String.format("https://api.currencyapi.com/v3/latest?apikey=%s&value=%s&base_currency=%s&currencies=%s",
                this.apiKey, value, baseCurrency, toCurrency);
        URL url = new URL(urlString);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        String limitQuotaMinute = con.getHeaderField("X-RateLimit-Limit-Quota-Minute");
        String limitQuotaMonth = con.getHeaderField("X-RateLimit-Remaining-Quota-Month");

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
        double result = (double) currency.get("value");



        System.out.println(result);
        System.out.println(responseCode);
        System.out.println("minute limit :" + limitQuotaMinute);
        System.out.println("month limit :" + limitQuotaMonth);

        return result * Double.parseDouble(value);

    }
}
