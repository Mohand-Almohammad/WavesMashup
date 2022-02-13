package WavesMashup.remote;

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

import WavesMashup.remote.views.CoingeckoHistPricesView;
import WavesMashup.remote.views.PyWavesInterestOverview;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PyWavesRemoteService.class, PyWavesRemoteServiceTest.PyWavesRemoteServiceTestConfiguration.class})
@TestPropertySource(properties = {"waves.mashup.pywaves.contextBaseUrl = http://testHost"})
public class PyWavesRemoteServiceTest {

  @Autowired
  private RestTemplate restTemplate;

  @BeforeEach
  public void init() {
    this.server = MockRestServiceServer.createServer(this.restTemplate);
  }

  private MockRestServiceServer server;

  @Autowired
  private PyWavesRemoteService pyWavesRemoteService;

  public static final String BASE_URL = "http://testHost";

  public static class PyWavesRemoteServiceTestConfiguration {
    @Bean
    public RestTemplate restTemplate() {
      return new RestTemplate();
    }
  }

  @Test
  public void getWavesInterest() throws JSONException {
    String responseString = this.getResponseStringForInterests();

    String coinGeckoPricesUriString = UriComponentsBuilder.fromUriString(PyWavesRemoteServiceTest.BASE_URL)
        .path("/neutrino/json").toUriString();

    this.server.expect(MockRestRequestMatchers.requestTo(coinGeckoPricesUriString))
        .andRespond(MockRestResponseCreators.withSuccess(responseString, MediaType.APPLICATION_JSON_UTF8));
    PyWavesInterestOverview result = this.pyWavesRemoteService.getWavesInterest();
    MatcherAssert.assertThat(result, Matchers.notNullValue());
    MatcherAssert.assertThat(result.getEth().getLatest(), CoreMatchers.equalTo(12.16));
    MatcherAssert.assertThat(result.getEth().getThreeDayAvg(), CoreMatchers.equalTo(12.21));
    MatcherAssert.assertThat(result.getEth().getSevenDayAvg(), CoreMatchers.equalTo(12.76));
    MatcherAssert.assertThat(result.getEth().getThirtyDayAvg(), CoreMatchers.equalTo(14.33));
    MatcherAssert.assertThat(result.getEth().getSixtyDayAvg(), CoreMatchers.equalTo(14.03));
  }

  private String getResponseStringForInterests() throws JSONException {
    // @formatter:off
    return new JSONObject()
        .put("eth-apy", new JSONObject()
            .put("30d", 14.33)
            .put("60d", 14.03)
            .put("7d", 12.76)
            .put("last", 12.16)
            .put("3d", 12.21))
        .toString();
    // @formatter:on
    // "eth-apy": {
    //        "30d": 14.33,
    //        "60d": 14.03,
    //        "7d": 12.76,
    //        "last": 12.16,
    //        "3d": 12.21
    //    }
  }
}
