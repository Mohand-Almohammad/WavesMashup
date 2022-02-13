package WavesMashup.remote.views;

import org.junit.jupiter.api.Test;

import WavesMashup.utils.GenericSetterAndGetterTester;

public class WavePriceViewTest {
  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<WavePriceView> tester = GenericSetterAndGetterTester
        .newInstance(new WavePriceView());
    tester.addValue(WavePriceDataView.class, new WavePriceDataView());
    tester.testAllGetterAndSetter();
  }
}
