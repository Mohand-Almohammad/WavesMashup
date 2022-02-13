package WavesMashup.model;

import org.junit.jupiter.api.Test;

import WavesMashup.utils.GenericSetterAndGetterTester;

public class WavesTest {
  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<Waves> tester = GenericSetterAndGetterTester
        .newInstance(new Waves());
    tester.testAllGetterAndSetter();
  }
}
