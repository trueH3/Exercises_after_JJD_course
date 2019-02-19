package com.mycompany.ex6;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author szymon
 */
public class HttpChecker {

    public static void main(String[] args) throws MalformedURLException, IOException {
        
        String urlPath = args.length > 0 ? args[0] : new Scanner(System.in).nextLine();
        URL url = new URL(urlPath);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("OPTIONS");
//           try{
//        con.connect();
//           } catch (UnknownHostException e){
//               System.out.println("connection failed due to an invalid or unknown host ");
//               System.exit(1);
//           }
        String methods = con.getHeaderField("Allow");
        if(methods != null){
            System.out.println("Allowed http methods: "+methods);
        } else {
            System.out.println("Sorry, but given url doesn't have defined allowed http methods");
        }
        con=(HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        System.out.println("Content length = "+con.getContentLength());
    }
}
