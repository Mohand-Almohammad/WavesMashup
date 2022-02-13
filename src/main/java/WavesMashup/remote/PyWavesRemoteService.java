package WavesMashup.remote;

import WavesMashup.remote.views.PyWavesInterestOverview;
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
public class PyWavesRemoteService implements IPyWavesRemoteService {

  @Value("${waves.mashup.pywaves.contextBaseUrl}")
  private String contextBaseUrl;

  private static final String PY_WAVES_CONTEXT_PATH = "/neutrino/";

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public PyWavesInterestOverview getWavesInterest() {
    UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.contextBaseUrl)
        .path(PY_WAVES_CONTEXT_PATH + "json");
    try {
      ResponseEntity<PyWavesInterestOverview> response = this.restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<PyWavesInterestOverview>() {
      });

      return response.getBody();
    } catch (HttpClientErrorException ex) {
      throw ex;
    }
  }
}
