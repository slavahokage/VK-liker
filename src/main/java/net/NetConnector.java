package net;

/**
 * Created by USER on 24.05.2018.
 */
import launcher.Mutex;
import vc.Wall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetConnector {

    private Wall wall;

    public NetConnector() {
    }

    public NetConnector(Wall wall) {
        this.wall = wall;
    }

    public void sendRequest(String address) {
            URL url = null;
            try {
                url = new URL(address);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                System.out.println(content);
                in.close();
                con.disconnect();
                wall.wallOfUserJSON = content+"";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

