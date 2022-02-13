package WavesMashup.controller;

import WavesMashup.httpRequest.PricesRequest;
import WavesMashup.model.PricesList;
import WavesMashup.model.TextSentiment;
import WavesMashup.model.Waves;
import WavesMashup.service.TextAnalyzer;
import WavesMashup.service.TweetsSearcher;
import WavesMashup.service.WavesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FrontEndController {

    @GetMapping(value = "/waves")
    String getWaves(Model model) throws IOException, InterruptedException, TwitterException {

        PricesList pl = PricesRequest.getPricesList();
        //WavesService wavesService = new WavesService();

        //List<WavesPriceDto> wavesHistoricalPrices = wavesService.getWavesHistoricalPrices();
        //model.addAttribute("wavesHistoricalPrices", wavesHistoricalPrices);

        model.addAttribute("waves", Arrays.asList(
                new Waves(pl.getWaves().getId(), pl.getWaves().getName(),pl.getWaves().getShortCode(), pl.getWaves().getTotalSupply(), pl.getWaves().getPrecision(), pl.getWaves().getTrades())));
        model.addAttribute("pricesList", pl);

        TextAnalyzer textAnalyzer= new TextAnalyzer();
        TweetsSearcher tweetsSearcher= new TweetsSearcher();
        List<String> tweetsAsString = tweetsSearcher.findTweets("@waves.tech");
        List<String> tweetsAsString1 = tweetsSearcher.findTweets("@wavesprotocol");

        List<TextSentiment> textSentiments = new ArrayList<>();
        for(String text: tweetsAsString) {
            textSentiments.add(textAnalyzer.analyzeTweet(text));
        }
        List<TextSentiment> textSentiments1 = new ArrayList<>();
        for(String text: tweetsAsString1) {
            textSentiments1.add(textAnalyzer.analyzeTweet(text));
        }
        model.addAttribute("sentimentsWavesTech", textSentiments);
        model.addAttribute("sentimentsWavesProtocol", textSentiments1);
        //model.addAttribute("tweetsWavesTech", tweetsAsString);

        return "waves";
    }


}
