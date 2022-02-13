package WavesMashup.remote;

import WavesMashup.remote.views.CoingeckoHistPricesView;

public interface ICoinGeckoRemoteService {
  CoingeckoHistPricesView getWavesHistoricalPrices();

}
