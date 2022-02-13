package WavesMashup.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import WavesMashup.remote.ICoinGeckoRemoteService;
import WavesMashup.remote.IPyWavesRemoteService;
import WavesMashup.remote.IWavesCapRemoteService;
import WavesMashup.remote.views.CoingeckoHistPricesView;
import WavesMashup.service.dtos.WavesPriceDto;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = WavesServiceTest.WavesServiceTestConfiguration.class)
public class WavesServiceTest {

  @Autowired
  private IWavesService wavesService;

  @MockBean
  private ICoinGeckoRemoteService coinGeckoRemoteService;

  @MockBean
  @SuppressWarnings("PMD.UnusedPrivateField")
  private IWavesCapRemoteService wavesCapRemoteService;

  @MockBean
  @SuppressWarnings("PMD.UnusedPrivateField")
  private IPyWavesRemoteService pyWavesRemoteService;

  @Test
  public void getWavesHistoricalPricesTest() {

    Object[] objectPair0 = new Object[2];
    objectPair0[0] = 1643932800000L;
    objectPair0[1] = 1.0;
    Object[] objectPair1 = new Object[2];
    objectPair1[0] = 1644019200000L;
    objectPair1[1] = 1.0;
    Object[] objectPair2 = new Object[2];
    objectPair2[0] = 1644105600000L;
    objectPair2[1] = 2.0;
    Object[] objectPair3 = new Object[2];
    objectPair3[0] = 1644192000000L;
    objectPair3[1] = 3.0;
    Object[] objectPair4 = new Object[2];
    objectPair4[0] = 1644278400000L;
    objectPair4[1] = 4.0;
    Object[] objectPair5 = new Object[2];
    objectPair5[0] = 1644364800000L;
    objectPair5[1] = 5.0;
    Object[] objectPair6 = new Object[2];
    objectPair6[0] = 1644451200000L;
    objectPair6[1] = 6.0;
    Object[] objectPair7 = new Object[2];
    objectPair7[0] = 1644537600000L;
    objectPair7[1] = 7.0;
    Object[] objectPair8 = new Object[2];
    objectPair8[0] = 1644586359000L;
    objectPair8[1] = 8.0;
    List<Object[]> prices = new ArrayList<>();
    prices.add(objectPair0);
    prices.add(objectPair1);
    prices.add(objectPair2);
    prices.add(objectPair3);
    prices.add(objectPair4);
    prices.add(objectPair5);
    prices.add(objectPair6);
    prices.add(objectPair7);
    prices.add(objectPair8);
    CoingeckoHistPricesView coingeckoHistPricesView = new CoingeckoHistPricesView();
    coingeckoHistPricesView.setPrices(prices);
    Mockito.when(this.coinGeckoRemoteService.getWavesHistoricalPrices()).thenReturn(coingeckoHistPricesView);

    List<WavesPriceDto> result = this.wavesService.getWavesHistoricalPrices();

    MatcherAssert.assertThat(result.size(), CoreMatchers.equalTo(8));

    MatcherAssert.assertThat(result.get(7).getPrice(), CoreMatchers.equalTo(7.0));
    MatcherAssert.assertThat(result.get(7).getDateOfPrice(), CoreMatchers.equalTo(LocalDate.of(2022, 2, 11)));
    MatcherAssert.assertThat(result.get(7).getMovingAverage7Day(), CoreMatchers.equalTo(4.0));
    MatcherAssert.assertThat(result.get(7).getSharpeRatio(), CoreMatchers.equalTo(19.937313176772744));
  }



  @Configuration
  static class WavesServiceTestConfiguration {
    @Bean
    public IWavesService createWavesService() {
      return new WavesService();
    }
  }
}
