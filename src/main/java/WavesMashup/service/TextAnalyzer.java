package WavesMashup.service;

import WavesMashup.model.TextSentiment;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Service
@AllArgsConstructor
public class TextAnalyzer {

    public TextSentiment analyzeTweet(String str ) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://text-sentiment.p.rapidapi.com/analyze"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("x-rapidapi-host", "text-sentiment.p.rapidapi.com")
                .header("x-rapidapi-key", "8188640856msh4c52032e28de1aep1a9441jsnc97db324c57d")
                .method("POST", HttpRequest.BodyPublishers.ofString(String.format("text=%s", str)))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        TextSentiment textSentiment = new ObjectMapper().readValue(response.body(), TextSentiment.class);
        return textSentiment;
    }
}

