package WavesMashup.remote.views;

import org.junit.jupiter.api.Test;

import WavesMashup.utils.GenericSetterAndGetterTester;

public class WavePriceDataViewTest {
  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<WavePriceDataView> tester = GenericSetterAndGetterTester
        .newInstance(new WavePriceDataView());
    tester.testAllGetterAndSetter();
  }
}
