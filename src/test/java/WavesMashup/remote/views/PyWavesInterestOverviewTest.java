package WavesMashup.remote.views;

import org.junit.jupiter.api.Test;

import WavesMashup.utils.GenericSetterAndGetterTester;

public class PyWavesInterestOverviewTest {
  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<PyWavesInterestOverview> tester = GenericSetterAndGetterTester
        .newInstance(new PyWavesInterestOverview());
    tester.addValue(PyWavesInterestView.class, new PyWavesInterestView());
    tester.testAllGetterAndSetter();
  }
}
