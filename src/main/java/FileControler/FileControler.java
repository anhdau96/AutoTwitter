/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileControler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author anhdau96
 */
public class FileControler {

    public static void getImg(String link) {
        try {
            System.setProperty("http.agent", "Chrome");
            URL url = new URL(link);
            File f = new File("tmp.jpg");
            FileUtils.copyURLToFile(url, f);
        } catch (IOException ex) {
            Logger.getLogger(FileControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        try {
//
//            URL url = new URL("http://tshirtdislike.info/wp-content/uploads/2017/07/Awesome-Daughter-Shirt.jpg");
//            File file = new File("tmp.jpg");
//            BufferedInputStream bis = new BufferedInputStream(url.openStream());
//            FileOutputStream fis = new FileOutputStream(file);
//            byte[] buffer = new byte[1024];
//            int count = 0;
//            while ((count = bis.read(buffer, 0, 1024)) != -1) {
//                fis.write(buffer, 0, count);
//            }
//            fis.close();
//            bis.close();
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(FileControler.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(FileControler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
