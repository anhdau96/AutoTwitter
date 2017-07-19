/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterfollow;

import FileControler.AccountControler;
import FileControler.FileControler;
import dbcontroller.TweetLinkController;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.LinkPin;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author anhdau96
 */
public class AutoTweet {

    /// Primary account
    static String AccessToken = "700568107-6Ld3GG1qavoL9QTx4RmeNg4EcRQ7AXTKovGKHAIZ";
    static String AccessSecret = "hsHiLhkXxLG9pvOdyyu0lg7GpFUh2F7mIsNXu7FelHD9U";
    static String ConsumerKey = "8Cxxg45V91Hqj7vVDRjx5bKbI";
    static String ConsumerSecret = "GAaPJqWBh8a03eehdyiUf7LtO2xqw3C59H6vidYoWaY2zIgkEz";
    // test account
//    static String AccessToken = "877362500685021184-NIfophZWOI7lfTIG2ayZx1iyyAa3a3P";
//    static String AccessSecret = "pGx2eSEzJAm9SgrQIKlBRWXdeAUfoNqks0mGt1VXHzV2U";
//    static String ConsumerKey = "kKZ5TrjirWe1ZKBDq94c9msIh";
//    static String ConsumerSecret = "MTFmshrvsc4Uiru9cKC5ldFXIMHD9n7HMnMBdgSWDBOlbvFkJB";

    public static void main(String[] args) {
        do {
            try {
                getPost();
            } catch (TwitterException | InterruptedException ex) {
                Logger.getLogger(AutoTweet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(3600000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AutoTweet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    public static void getPost() throws TwitterException, InterruptedException {
        Random r = new Random();
        AccountControler accountControler = new AccountControler();
        List<Account> lstAccounts = accountControler.getAll();
        TweetLinkController controller = new TweetLinkController();
        while (true) {
            List<LinkPin> linkTweets = controller.getLinkTweet();
            for (LinkPin linkTweet : linkTweets) {
                Account get = lstAccounts.get(r.nextInt(3));
                ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(true)
                        .setOAuthConsumerKey(get.ConsumerKey)
                        .setOAuthConsumerSecret(get.ConsumerSecret)
                        .setOAuthAccessToken(get.AccessToken)
                        .setOAuthAccessTokenSecret(get.AccessSecret);
                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();
                String status = "Where can you buy lovely t-shirt?\n"
                        + "\n"
                        + "New Design - Cheap - Sport - Dynamic - Youthful\n"
                        + "\n"
                        + "Welcome to T-shirts Shop ^^ \n" + linkTweet.getLink();
//                    if (status.split(" ").length > 140) {
//                        status = status.substring(0, 140);
//                    }
                StatusUpdate statusUpdate = new StatusUpdate(status);
                FileControler.getImg(linkTweet.getImg());
                statusUpdate.setMedia(new File("tmp.jpg"));
                twitter.updateStatus(statusUpdate);
                controller.updateLinkTweet(linkTweet.getId());
                System.out.println(linkTweet.getNote());
                Thread.sleep(((long) (Math.random() * (200000 - 100000)) + 100000));
            }

        }
    }
}
