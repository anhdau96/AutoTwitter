package com.mycompany.twitterfollow;

import FileControler.AccountControler;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class Main {

//    static String AccessToken = "700568107-6Ld3GG1qavoL9QTx4RmeNg4EcRQ7AXTKovGKHAIZ";
//    static String AccessSecret = "hsHiLhkXxLG9pvOdyyu0lg7GpFUh2F7mIsNXu7FelHD9U";
//    static String ConsumerKey = "8Cxxg45V91Hqj7vVDRjx5bKbI";
//    static String ConsumerSecret = "GAaPJqWBh8a03eehdyiUf7LtO2xqw3C59H6vidYoWaY2zIgkEz";
    /**
     * @param args
     */
    public static void main(String[] args) {
        Data data = new Data();
        List<String> lstNames = data.lstName;
        AccountControler accountControler = new AccountControler();
        List<Account> accounts = accountControler.getAll();
        try {
            for (String lstName : lstNames) {
                for (Account account : accounts) {
                    ConfigurationBuilder cb = new ConfigurationBuilder();
                    cb.setDebugEnabled(true)
                            .setOAuthConsumerKey(account.ConsumerKey)
                            .setOAuthConsumerSecret(account.ConsumerSecret)
                            .setOAuthAccessToken(account.AccessToken)
                            .setOAuthAccessTokenSecret(account.AccessSecret);
                    TwitterFactory tf = new TwitterFactory(cb.build());
                    Twitter twitter = tf.getInstance();

                    ResponseList<User> searchUsers = twitter.searchUsers(lstName, 50);
                    for (User searchUser : searchUsers) {
                        if (!searchUser.isFollowRequestSent()) {
                            User createFriendship = twitter.createFriendship(searchUser.getId());
                            System.out.println("Star follow: " + createFriendship.getName());
                            Thread.sleep(((long) (Math.random() * (600000 - 300000)) + 300000));
                        }
                    }
                }

            }
        } catch (TwitterException | IllegalStateException | InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
