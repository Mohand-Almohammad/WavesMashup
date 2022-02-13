package WavesMashup.service.dtos;

import org.junit.jupiter.api.Test;

import WavesMashup.utils.GenericSetterAndGetterTester;

public class WavesInterestDtoTest {
  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<WavesInterestDto> tester = GenericSetterAndGetterTester
        .newInstance(new WavesInterestDto());
    tester.testAllGetterAndSetter();
  }

}
