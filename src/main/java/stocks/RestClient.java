package stocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

import stocks.dto.BalanceSheetDTO;
import stocks.dto.StockDTO;

public class RestClient {
    private CloseableHttpClient httpClient;

    public RestClient() {
        httpClient = HttpClientBuilder.create().build();
    }

    public BalanceSheetDTO getBalanceSheet(String symbol) {
        String responseBody = get(getBalanceSheetUrl(symbol));
        return responseBody != null
                ? new Gson().fromJson(responseBody, BalanceSheetDTO.class)
                : null;
    }

    public StockDTO getProfile(String symbol) {
        String responseBody = get(getProfileUrl(symbol));
        return responseBody != null
                ? new Gson().fromJson(responseBody, StockDTO.class)
                : null;
    }

    private String get(String url) {
        try {
            StringBuffer sb = new StringBuffer();
            HttpGet getRequest = new HttpGet(url);
            HttpResponse response = httpClient.execute(getRequest);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output.trim());
            }
            return sb.toString();
        } catch (ClientProtocolException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getBalanceSheetUrl(String symbol) {
        return "https://financialmodelingprep.com/api/v3/financials/balance-sheet-statement/"
                + symbol + "?period=quarter";
    }

    private String getProfileUrl(String symbol) {
        return "https://financialmodelingprep.com/api/v3/company/profile/"
                + symbol;
    }
}
