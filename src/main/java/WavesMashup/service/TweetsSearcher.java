package WavesMashup.service;

import WavesMashup.Exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
@Service
@AllArgsConstructor
public class TweetsSearcher {

    private ConfigurationBuilder connect() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setJSONStoreEnabled(true);
        cb.setOAuthConsumerKey("IndgsKpTZ8D0le8NJEro7X4I9");
        cb.setOAuthConsumerSecret("11DhtyXfyAzKg1QiGvPEmugAjzMsVj3EcQ2k6FQfSGx0ysq0YM");
        cb.setOAuthAccessToken("1103383944735518720-noYZlsF4obJiOeDd7KpTWy8X4ouck3");
        cb.setOAuthAccessTokenSecret("bEF3ttsHvlS3DGCgLsSQ9tngwfQLglbL1hc8gHOFmzNER");
        return cb;
    }

    public List<String> findTweets(String hashtag) throws TwitterException {
        List<String> tweetsAsString=new ArrayList<>();
        ConfigurationBuilder cb = this.connect();
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        try {
            Query query = new Query(hashtag);
            QueryResult result;
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();

            for (Status tweet : tweets) {
                tweetsAsString.add(tweet.getText());
            }
            if(tweets.isEmpty()){
                throw new EntityNotFoundException(String.format("There are no tweets for the hashtag: %s", hashtag));
            }
            return tweetsAsString;

        } catch (TwitterException ex) {

           throw new TwitterException(String.format("Failed to search tweets: " + ex.getMessage()));

        }
    }
}

