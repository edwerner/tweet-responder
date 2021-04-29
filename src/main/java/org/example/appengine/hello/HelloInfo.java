/*
 * Copyright (c) 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you
 * may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.example.appengine.hello;    

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


public class HelloInfo {

  private static final String USER_AGENT = "Mozilla/5.0";
  private final String OAUTH_CONSUMER_KEY = "";
  private final String OAUTH_CONSUMER_KEY = "";
  private final String OAUTH_CONSUMER_SECRET = "";
  private final String OAUTH_ACCESS_TOKEN_SECRET = "";

  public HelloInfo() {

  }

  public static String getInfo() {
    try {
      sendTwitterPost();
      // sendTwitterPost();
    } catch (Exception e) {
      e.printStackTrace();
    }
    // listenForTweets();
    return "Version: " + System.getProperty("java.version") + " OS: " + System.getProperty("os.name") + " User: "
        + System.getProperty("user.name");
  }

  private static void sendTwitterPost() throws Exception {
    OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer("key", "secret");
    oAuthConsumer.setTokenWithSecret("token", "tokenSecret");

    HttpPost httpPost = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status=Hello%20Twitter%20World.");
    
    httpPost.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BROWSER_COMPATIBILITY); 

    oAuthConsumer.sign(httpPost);

    HttpClient httpClient = new DefaultHttpClient();
    HttpResponse httpResponse = httpClient.execute(httpPost);

    int statusCode = httpResponse.getStatusLine().getStatusCode();
    System.out.println(statusCode + ':' + httpResponse.getStatusLine().getReasonPhrase());
//    System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));
  }

  public static void listenForTweets() {
    ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
    configurationBuilder.setOAuthConsumerKey(OAUTH_CONSUMER_KEY)
        .setOAuthConsumerSecret(OAUTH_CONSUMER_SECRET)
        .setOAuthAccessToken(OAUTH_ACCESS_TOKEN)
        .setOAuthAccessTokenSecret(OAUTH_ACCESS_TOKEN_SECRET);
    TwitterStream twitterStream = 
        new TwitterStreamFactory(configurationBuilder.build()).getInstance();
    Twitter twitter = new TwitterFactory().getInstance();

    twitterStream.addListener(new StatusListener() {
      public void onStatus(Status status) {
        // System.out.println(status.getText());
        Status reply = null;
        try {
          reply = twitter.updateStatus(new StatusUpdate(
              "@" + status.getUser().getScreenName() + 
              "Check out my cat blog https://yourblog.blogspot.com/ #cats")
                  .inReplyToStatusId(status.getId()));
          System.out.println("Posted reply " + reply.getId() + 
              " in response to tweet " + reply.getInReplyToStatusId());
        } catch (TwitterException e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onException(Exception arg0) {
        // TODO Auto-generated method stub

      }

      @Override
      public void onDeletionNotice(StatusDeletionNotice arg0) {
        // TODO Auto-generated method stub

      }

      @Override
      public void onScrubGeo(long arg0, long arg1) {
        // TODO Auto-generated method stub

      }

      @Override
      public void onStallWarning(StallWarning arg0) {
        // TODO Auto-generated method stub

      }

      @Override
      public void onTrackLimitationNotice(int arg0) {
        // TODO Auto-generated method stub

      }
    });

    FilterQuery tweetFilterQuery = new FilterQuery();
    tweetFilterQuery.track(new String[] { "cats" });
    tweetFilterQuery.language(new String[] { "en" });
    twitterStream.filter(tweetFilterQuery);
  }
}
