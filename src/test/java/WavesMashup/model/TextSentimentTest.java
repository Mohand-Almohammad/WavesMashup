package WavesMashup.model;

import org.junit.jupiter.api.Test;

import WavesMashup.utils.GenericSetterAndGetterTester;

public class TextSentimentTest {

  @Test
  void testGetterAndSetter() {
    GenericSetterAndGetterTester<TextSentiment> tester = GenericSetterAndGetterTester
        .newInstance(new TextSentiment());
    tester.testAllGetterAndSetter();
  }
}
