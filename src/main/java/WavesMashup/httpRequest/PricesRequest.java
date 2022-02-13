package WavesMashup.httpRequest;

import WavesMashup.model.PricesList;
import WavesMashup.model.Waves;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PricesRequest {
    private static HttpURLConnection connection;

    public static PricesList getPricesList(){
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();
        try {
            URL url = new URL("https://wavescap.com/api/asset/WAVES.json");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status != 200){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine())  != null){
                    responseContent.append(line);
                }
                reader.close();
            } else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine())  != null){
                    responseContent.append(line);
                }
                reader.close();
            }
            return parse(responseContent.toString());
            //System.out.println(responseContent.toString());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }finally {
            connection.disconnect();
        }
        return null;
    }

        public static PricesList parse(String responseBody) throws JSONException {

                Waves waves = new Waves();
                JSONObject price = new JSONObject(responseBody);
                String id = price.getString("id");
                String name = price.getString("name");
                String shortCode = price.getString("shortcode");
                int totalSupply = price.getInt("totalSupply");
                int precision = price.getInt("precision");
                int trades = price.getInt("trades");
                waves.setId(id);
                waves.setName(name);
                waves.setShortCode(shortCode);
                waves.setTotalSupply(totalSupply);
                waves.setPrecision(precision);
                waves.setTrades(trades);

                double firstPriceTryn = price.getJSONObject("data").getDouble("firstPrice_tryn");
                double lastPriceTryn = price.getJSONObject("data").getDouble("lastPrice_tryn");
                double firstPriceBrln = price.getJSONObject("data").getDouble("firstPrice_brln");
                double lastPriceBrln = price.getJSONObject("data").getDouble("lastPrice_brln");
                double firstPriceGbpn = price.getJSONObject("data").getDouble("firstPrice_gbpn");
                double lastPriceGbpn = price.getJSONObject("data").getDouble("lastPrice_gbpn");
                double firstPriceNgnn = price.getJSONObject("data").getDouble("firstPrice_ngnn");
                double lastPriceNgnn = price.getJSONObject("data").getDouble("lastPrice_ngnn");
                double firstPriceUahn = price.getJSONObject("data").getDouble("firstPrice_uahn");
                double lastPriceUahn = price.getJSONObject("data").getDouble("lastPrice_uahn");
                double firstPriceJpyn = price.getJSONObject("data").getDouble("firstPrice_jpyn");
                double lastPriceJpyn = price.getJSONObject("data").getDouble("lastPrice_jpyn");
                double firstPriceCnyn = price.getJSONObject("data").getDouble("firstPrice_cnyn");
                double lastPriceCnyn = price.getJSONObject("data").getDouble("lastPrice_cnyn");
                double firstPriceRubn = price.getJSONObject("data").getDouble("firstPrice_rubn");
                double lastPriceRubn = price.getJSONObject("data").getDouble("lastPrice_rubn");
                double firstPriceEurn = price.getJSONObject("data").getDouble("firstPrice_eurn");
                double lastPriceEurn = price.getJSONObject("data").getDouble("lastPrice_eurn");
                double firstPriceUsd_n = price.getJSONObject("data").getDouble("firstPrice_usd-n");
                double lastPriceUsd_n = price.getJSONObject("data").getDouble("lastPrice_usd-n");
                double firstPriceWaves = price.getJSONObject("data").getDouble("firstPrice_waves");
                double lastPriceWaves = price.getJSONObject("data").getDouble("lastPrice_waves");
                double firstPriceBtc = price.getJSONObject("data").getDouble("firstPrice_btc");
                double lastPriceBtc = price.getJSONObject("data").getDouble("lastPrice_btc");
                double firstPriceEth = price.getJSONObject("data").getDouble("firstPrice_eth");
                double lastPriceEth = price.getJSONObject("data").getDouble("lastPrice_eth");
              //  System.out.println(lastPriceUsd_n);

                PricesList pricesList = new PricesList(waves,firstPriceTryn, lastPriceTryn, firstPriceBrln, lastPriceBrln, firstPriceGbpn, lastPriceGbpn, firstPriceNgnn, lastPriceNgnn, firstPriceUahn, lastPriceUahn,
                        firstPriceJpyn, lastPriceJpyn, firstPriceCnyn, lastPriceCnyn,
                        firstPriceRubn, lastPriceRubn, firstPriceEurn, lastPriceEurn, firstPriceUsd_n, lastPriceUsd_n, firstPriceWaves, lastPriceWaves, firstPriceBtc, lastPriceBtc, firstPriceEth,
                        lastPriceEth);

                //System.out.println(pricesList);
                return pricesList;
        }


}
