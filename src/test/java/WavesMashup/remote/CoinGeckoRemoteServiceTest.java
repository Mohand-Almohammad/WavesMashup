package WavesMashup.remote;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import WavesMashup.remote.CoinGeckoRemoteServiceTest.CoinGeckoRemoteServiceTestConfiguration;
import WavesMashup.remote.views.CoingeckoHistPricesView;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CoinGeckoRemoteService.class, CoinGeckoRemoteServiceTestConfiguration.class})
@TestPropertySource(properties = {"waves.mashup.coingecko.contextBaseUrl = http://testHost"})
public class CoinGeckoRemoteServiceTest {

  @Autowired
  private RestTemplate restTemplate;

  @BeforeEach
  public void init() {
    this.server = MockRestServiceServer.createServer(this.restTemplate);
  }

  private MockRestServiceServer server;

  @Autowired
  private CoinGeckoRemoteService coinGeckoRemoteService;

  public static final String BASE_URL = "http://testHost";

  public static class CoinGeckoRemoteServiceTestConfiguration {
    @Bean
    public RestTemplate restTemplate() {
      return new RestTemplate();
    }
  }

  @Test
  void getWavesHistoricalPricesTest() throws JSONException {

    String responseString = this.getResponseStringForHistoricPrices();

    String coinGeckoPricesUriString = UriComponentsBuilder.fromUriString(CoinGeckoRemoteServiceTest.BASE_URL)
        .path("/api/v3/coins/waves/market_chart").queryParam("vs_currency", "usd").queryParam("days", "max")
        .queryParam("interval", "daily").toUriString();

    this.server.expect(MockRestRequestMatchers.requestTo(coinGeckoPricesUriString))
        .andRespond(MockRestResponseCreators.withSuccess(responseString, MediaType.APPLICATION_JSON_UTF8));
    CoingeckoHistPricesView result = this.coinGeckoRemoteService.getWavesHistoricalPrices();
    MatcherAssert.assertThat(result, Matchers.notNullValue());
    MatcherAssert.assertThat(result.getPrices().size(), CoreMatchers.equalTo(2));
    MatcherAssert.assertThat(result.getPrices().get(0)[0], CoreMatchers.equalTo(1644019200000L));
    MatcherAssert.assertThat(result.getPrices().get(0)[1], CoreMatchers.equalTo(1.1));
  }

  private String getResponseStringForHistoricPrices() throws JSONException {
    // @formatter:off
    return new JSONObject()
            .put("prices", new JSONArray()
                .put(new JSONArray()
                    .put(1644019200000L)
                    .put(1.1))
                .put(new JSONArray()
                    .put(1644105600000L)
                    .put(2.2))
            )
        .toString();
    // @formatter:on
  }
}
