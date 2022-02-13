package WavesMashup.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

  //private long timeout = 15000;

  @Bean
  public RestTemplate restTemplate() {
//    RestTemplateBuilder builder = new RestTemplateBuilder()
//        .setReadTimeout(Duration.of(this.timeout, ChronoUnit.MILLIS));
    RestTemplate template = new RestTemplateBuilder().build();
//    template.setRequestFactory(this.clientSslConfiguration());
//    template.setInterceptors(List.of(new UserHeaderInterceptor()));
    return template;
  }
}
