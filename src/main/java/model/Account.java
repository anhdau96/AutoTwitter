/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author anhdau96
 */
public class Account {
    public String AccessToken;
    public String AccessSecret ;
    public String ConsumerKey ;
    public String ConsumerSecret ;

    public Account(String AccessToken, String AccessSecret, String ConsumerKey, String ConsumerSecret) {
        this.AccessToken = AccessToken;
        this.AccessSecret = AccessSecret;
        this.ConsumerKey = ConsumerKey;
        this.ConsumerSecret = ConsumerSecret;
    }

    public String getAccessToken() {
        return AccessToken;
    }

    public void setAccessToken(String AccessToken) {
        this.AccessToken = AccessToken;
    }

    public String getAccessSecret() {
        return AccessSecret;
    }

    public void setAccessSecret(String AccessSecret) {
        this.AccessSecret = AccessSecret;
    }

    public String getConsumerKey() {
        return ConsumerKey;
    }

    public void setConsumerKey(String ConsumerKey) {
        this.ConsumerKey = ConsumerKey;
    }

    public String getConsumerSecret() {
        return ConsumerSecret;
    }

    public void setConsumerSecret(String ConsumerSecret) {
        this.ConsumerSecret = ConsumerSecret;
    }
    
}
