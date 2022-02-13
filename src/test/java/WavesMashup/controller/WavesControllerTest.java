package WavesMashup.controller;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import WavesMashup.service.IWavesService;
import WavesMashup.service.dtos.WavesInterestDto;
import WavesMashup.service.dtos.WavesPriceDto;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = WavesController.class)
public class WavesControllerTest {

  @MockBean
  private IWavesService wavesService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getWavesHistoricalPricesTest() throws Exception {
    WavesPriceDto wavesPriceDto = new WavesPriceDto(1234L, 7.89);
    wavesPriceDto.setSharpeRatio(0.12345);
    List<WavesPriceDto> wavesPriceDtos = new ArrayList<>();
    wavesPriceDtos.add(wavesPriceDto);

    Mockito.when(this.wavesService.getWavesHistoricalPrices()).thenReturn(wavesPriceDtos);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/waves")
        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE);

    this.mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].price", Matchers.equalTo(wavesPriceDto.getPrice())))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].sharpeRatio", Matchers.equalTo(wavesPriceDto.getSharpeRatio())))
        .andReturn();
  }

  @Test
  public void getWavesInterest() throws Exception {
    WavesInterestDto wavesInterestDto = new WavesInterestDto();
    wavesInterestDto.setAsset("testAsset");
    wavesInterestDto.setThreeDayAvg(1.234);
    List<WavesInterestDto> wavesInterestDtos = new ArrayList<>();
    wavesInterestDtos.add(wavesInterestDto);
    Mockito.when(this.wavesService.getWavesInterest()).thenReturn(wavesInterestDtos);

    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/waves/interest")
        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE);

    this.mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].asset", Matchers.equalTo(wavesInterestDto.getAsset())))
        .andExpect(MockMvcResultMatchers.jsonPath("$[0].threeDayAvg", Matchers.equalTo(wavesInterestDto.getThreeDayAvg())))
        .andReturn();


  }
}
