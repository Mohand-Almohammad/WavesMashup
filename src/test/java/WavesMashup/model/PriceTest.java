package WavesMashup.model;

import org.junit.jupiter.api.Test;

import WavesMashup.remote.views.CoingeckoHistPricesView;
import WavesMashup.utils.GenericSetterAndGetterTester;

public class PriceTest {

  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<PricesList> tester = GenericSetterAndGetterTester
        .newInstance(new PricesList());
    tester.addValue(Waves.class, new Waves());
    tester.testAllGetterAndSetter();
  }
}
