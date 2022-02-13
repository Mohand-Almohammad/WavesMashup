package WavesMashup.service.dtos;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import WavesMashup.utils.GenericSetterAndGetterTester;

public class WavesPriceDtoTest {
  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<WavesPriceDto> tester = GenericSetterAndGetterTester
        .newInstance(new WavesPriceDto(1464825600000L, 1.22));
    tester.addValue(LocalDate.class, LocalDate.now());
    tester.testAllGetterAndSetter();
  }
}
