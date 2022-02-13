package WavesMashup.remote.views;

import WavesMashup.service.dtos.WavesPriceDto;

import java.util.ArrayList;
import java.util.List;

public class CoingeckoHistPricesView {
  private List<Object[]> prices;

  public List<Object[]> getPrices() {
    return prices;
  }

  public void setPrices(List<Object[]> prices) {
    this.prices = prices;
  }

  public List<WavesPriceDto> toWavesPriceDtoList() {
    List<WavesPriceDto> wavesPriceDtos = new ArrayList<>();

    this.getPrices().forEach(price -> {
      WavesPriceDto wavesPriceDto = new WavesPriceDto((long) price[0], (double) price[1]);
      wavesPriceDtos.add(wavesPriceDto);
    });

    // das letzte Element wird entfernt, da es den aktuellen Tag doppelt.
    // (das letzte Element enthält den Kurs der aktuellen Uhrzeit)
    wavesPriceDtos.remove(wavesPriceDtos.size()-1);

    return wavesPriceDtos;
  }
}
