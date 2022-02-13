package WavesMashup.controller;

import WavesMashup.httpRequest.PricesRequest;
import WavesMashup.model.PricesList;
import WavesMashup.model.TextSentiment;
import WavesMashup.service.TextAnalyzer;
import WavesMashup.service.TweetsSearcher;
import WavesMashup.service.WavesService;
import WavesMashup.service.Waves_Service;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.TwitterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@RestController
@RequestMapping("")
public class Controller {

    private final Waves_Service wavesService;
    private TextAnalyzer textAnalyzer= new TextAnalyzer();
    private TweetsSearcher tweetsSearcher= new TweetsSearcher();

        @GetMapping("")
        public ResponseEntity<List<PricesList>> getPricesLists () {
            List<PricesList> pricesLists = wavesService.getPricesList();
            return new ResponseEntity<>(pricesLists, HttpStatus.OK);
        }

    @GetMapping("/TweetSentiment/{str}")
    public ResponseEntity<List<TextSentiment>> getTextSentiment( @PathVariable String str) throws IOException, InterruptedException, TwitterException {
       List<String> tweetsAsString= tweetsSearcher.findTweets(str);
       List<TextSentiment> textSentiments=new ArrayList<>();
       for(String text: tweetsAsString){
           try {
               textSentiments.add(textAnalyzer.analyzeTweet(text));
           }catch (Exception ex){
               ex.printStackTrace();
           }

       }
        return new ResponseEntity (textSentiments, HttpStatus.OK);
    }

 /*   @GetMapping(value = "/waves")
    public ModelAndView wavesPage() {
        ModelAndView resp = new ModelAndView("waves");
        resp.addObject(
                "waves",
                PricesRequest.getConnection());
        return resp;
    } */


}
