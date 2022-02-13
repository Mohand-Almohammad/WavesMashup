package WavesMashup.service;

import WavesMashup.service.dtos.WavesInterestDto;
import WavesMashup.service.dtos.WavesPriceDto;

import java.util.List;

public interface IWavesService {

  List<WavesPriceDto> getWavesHistoricalPrices();

  List<WavesInterestDto> getWavesInterest();
}
