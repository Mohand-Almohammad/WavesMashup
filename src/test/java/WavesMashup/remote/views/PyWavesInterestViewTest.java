package WavesMashup.remote.views;

import org.junit.jupiter.api.Test;

import WavesMashup.utils.GenericSetterAndGetterTester;

public class PyWavesInterestViewTest {
  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<PyWavesInterestView> tester = GenericSetterAndGetterTester
        .newInstance(new PyWavesInterestView());
    tester.testAllGetterAndSetter();
  }
}
