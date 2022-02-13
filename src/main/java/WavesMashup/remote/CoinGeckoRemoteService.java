package WavesMashup.remote;

import WavesMashup.remote.views.CoingeckoHistPricesView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CoinGeckoRemoteService implements ICoinGeckoRemoteService {

  @Value("${waves.mashup.coingecko.contextBaseUrl}")
  private String contextBaseUrl; //= "https://api.coingecko.com";

  private static final String COINGECKO_CONTEXT_PATH = "/api/v3/";

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public CoingeckoHistPricesView getWavesHistoricalPrices() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.contextBaseUrl)
        .path(COINGECKO_CONTEXT_PATH + "coins/waves/market_chart")
        .queryParam("vs_currency", "usd").queryParam("days", "max").queryParam("interval", "daily");
    try {
      ResponseEntity<CoingeckoHistPricesView> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<CoingeckoHistPricesView>() {
      });
      return response.getBody();
    } catch (HttpClientErrorException ex) {
      throw ex;
    }
  }
}
