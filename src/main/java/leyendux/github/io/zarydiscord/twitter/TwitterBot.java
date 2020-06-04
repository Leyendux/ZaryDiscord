package leyendux.github.io.zarydiscord.twitter;

import leyendux.github.io.zarydiscord.Main;
import leyendux.github.io.zarydiscord.discord.DiscordMethods;
import twitter4j.*;
import twitter4j.auth.AccessToken;

public class TwitterBot {

    private Twitter twitter;
    private TwitterStream twitterStream;

    public TwitterBot(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        twitter = new TwitterFactory().getInstance();

        twitter.setOAuthConsumer(consumerKey, consumerSecret);
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));

        twitterStream = new TwitterStreamFactory().getInstance();

        twitterStream.setOAuthConsumer(consumerKey, consumerSecret);
        twitterStream.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));

        twitterStream.addListener(statusListener());
        twitterStream.filter(new FilterQuery().follow(1268208839914131456L));
    }

    private StatusListener statusListener() {
        return new StatusListener() {
            public void onStatus(Status status) {
                if(status.getUser().getId() == 1268208839914131456L) {
                    Main.getInstance().getLogger().info(status.getUser().getScreenName() + ": " + status.getText());

                    MediaEntity[] mediaEntities = status.getMediaEntities();
                    if(mediaEntities.length > 0) {
                        DiscordMethods.sendTwitterEmbed(status.getText(), mediaEntities[0].getMediaURL());
                    } else {
                        DiscordMethods.sendTwitterEmbed(status.getText());
                    }
                }
            }

            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            public void onTrackLimitationNotice(int i) {

            }

            public void onScrubGeo(long l, long l1) {

            }

            public void onStallWarning(StallWarning stallWarning) {

            }

            public void onException(Exception e) {

            }
        };
    }

}
