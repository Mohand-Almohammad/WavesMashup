package WavesMashup.remote;

import WavesMashup.remote.views.WavePriceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WavesCapRemoteService implements IWavesCapRemoteService{

  private String contextBaseUrl = "https://wavescap.com";
  private static final String WAVES_CAP_CONTEXT_PATH = "/api/";

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public WavePriceView getWaves() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.contextBaseUrl)
        .path(WAVES_CAP_CONTEXT_PATH + "asset/WAVES.json");
    try {
      ResponseEntity<WavePriceView> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null,
          new ParameterizedTypeReference<WavePriceView>() {
          });
      return response.getBody();
    } catch (HttpClientErrorException ex) {
        throw ex;
    }
  }
}
