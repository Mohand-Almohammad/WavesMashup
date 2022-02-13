package WavesMashup.remote.views;

import org.junit.jupiter.api.Test;

import WavesMashup.service.dtos.WavesPriceDto;
import WavesMashup.utils.GenericSetterAndGetterTester;

public class CoingeckoHistPricesViewTest {
  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<CoingeckoHistPricesView> tester = GenericSetterAndGetterTester
        .newInstance(new CoingeckoHistPricesView());
    tester.testAllGetterAndSetter();
  }
}
