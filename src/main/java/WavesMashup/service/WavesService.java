package WavesMashup.service;

import WavesMashup.model.PricesList;
import WavesMashup.remote.ICoinGeckoRemoteService;
import WavesMashup.remote.IPyWavesRemoteService;
import WavesMashup.remote.IWavesCapRemoteService;
import WavesMashup.remote.views.CoingeckoHistPricesView;
import WavesMashup.remote.views.PyWavesInterestOverview;
import WavesMashup.service.dtos.WavesInterestDto;
import WavesMashup.service.dtos.WavesPriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WavesService implements IWavesService {


    @Autowired
    private IWavesCapRemoteService wavesCapRemoteService;

    @Autowired
    private ICoinGeckoRemoteService coinGeckoRemoteService;

    @Autowired
    private IPyWavesRemoteService pyWavesRemoteService;



    @Override
    public List<WavesPriceDto> getWavesHistoricalPrices() {
        CoingeckoHistPricesView coingeckoHistPricesView = this.coinGeckoRemoteService.getWavesHistoricalPrices();

        List<WavesPriceDto> wavesPriceDtos = coingeckoHistPricesView.toWavesPriceDtoList();

        this.enhanceMovingAverage7Day(wavesPriceDtos);
        this.enhanceMovingAverage180Day(wavesPriceDtos);

        int window = 7;
        this.enhanceSharpeRatio(wavesPriceDtos, window);

        return wavesPriceDtos;
    }

    private void enhanceMovingAverage7Day(List<WavesPriceDto> wavesPriceDtos) {
        int window = 7;
        for (int i = 0; i < wavesPriceDtos.size(); i++) {

            if (i - window + 1 >= 0) {
                double sum = 0;

                for (int j = i - window + 1; j <= i; j++ ) {
                    sum += wavesPriceDtos.get(j).getPrice();
                }

                wavesPriceDtos.get(i).setMovingAverage7Day(sum / window);
            }
        }
    }

    private void enhanceMovingAverage180Day(List<WavesPriceDto> wavesPriceDtos) {
        int window = 180;
        for (int i = 0; i < wavesPriceDtos.size(); i++) {

            if (i - window + 1 >= 0) {
                double sum = 0;

                for (int j = i - window + 1; j <= i; j++ ) {
                    sum += wavesPriceDtos.get(j).getPrice();
                }

                wavesPriceDtos.get(i).setMovingAverage180Day(sum / window);
            }
        }
    }

    private void enhanceSharpeRatio(List<WavesPriceDto> wavesPriceDtos, int window) {
        // angenommene risikofreie Rendite
        double riskFreeReturnPerYear = 1.95;
        double riskFreeReturnPerWindow = riskFreeReturnPerYear / 365 * window;

        Map<LocalDate, WavesPriceDto> dateOfPricePriceMap = wavesPriceDtos.stream()
            .collect(Collectors.toMap(wave -> wave.getDateOfPrice(), wave -> wave));

        dateOfPricePriceMap.forEach((dateOfPrice, wave) -> {
            if (dateOfPricePriceMap.containsKey(dateOfPrice.minus(window, ChronoUnit.DAYS))) {

                Set<Double> returnsPerFrame = new HashSet<>();
                for (int i = window; i > 0; i--) {

                    double priceAtFrameStart = dateOfPricePriceMap.get(dateOfPrice.minus(i, ChronoUnit.DAYS)).getPrice();
                    double priceAtFrameEnd = dateOfPricePriceMap.get(dateOfPrice.minus(i - 1, ChronoUnit.DAYS)).getPrice();
                    double returnThisMonth = (100 / priceAtFrameStart * priceAtFrameEnd) - 100;

                    returnsPerFrame.add(returnThisMonth);
                }
                double sumForAverageReturn = returnsPerFrame.stream().collect(Collectors.summingDouble(Double::doubleValue));
                double averageReturn = sumForAverageReturn / window;

                double sumOfFaktors = returnsPerFrame.stream().map(returnsThisFrame -> Math.pow(returnsThisFrame - averageReturn, 2)).collect(Collectors.summingDouble(Double::doubleValue));

                double volatilityInWindow = Math.sqrt(sumOfFaktors / window);
                double returnInWindow = (100 / dateOfPricePriceMap.get(dateOfPrice.minus(window, ChronoUnit.DAYS)).getPrice()
                    * wave.getPrice()) - 100;

                double sharpeRatio = (returnInWindow - riskFreeReturnPerWindow) / volatilityInWindow;

                wave.setSharpeRatio(sharpeRatio);
            }
        });
    }

    @Override
    public List<WavesInterestDto> getWavesInterest() {
        PyWavesInterestOverview pyWavesInterestOverview = this.pyWavesRemoteService.getWavesInterest();

        return pyWavesInterestOverview.toWavesInterestDtoList();
    }



}
