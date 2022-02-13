package WavesMashup.controller;

import WavesMashup.httpRequest.PricesRequest;
import WavesMashup.model.PricesList;
import WavesMashup.service.IWavesService;
import WavesMashup.service.dtos.WavesInterestDto;
import WavesMashup.service.dtos.WavesPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/waves")
public class WavesController {

  @Autowired
  private IWavesService wavesService;

  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<WavesPriceDto> getWavesHistoricalPrices() {
    return this.wavesService.getWavesHistoricalPrices();
  }

  @GetMapping(path = "/interest", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<WavesInterestDto> getWavesInterest() {
    return this.wavesService.getWavesInterest();
  }

  @GetMapping(path = "/priceslist", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public PricesList getWavesPrices(){
    PricesList pl = PricesRequest.getPricesList();
    return pl;
  }


}
