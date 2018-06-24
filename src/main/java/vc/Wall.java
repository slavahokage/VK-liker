package vc;

import launcher.Mutex;
import launcher.Timer;
import net.NetConnector;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by USER on 25.05.2018.
 */
public class Wall {
    public String wallOfUserJSON;
    private Integer idOfUser;
    List<Integer> listOfRecordsUser = new ArrayList<Integer>();
    private String accessToken;
    private boolean flag = false;

    public Wall(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getIdOfUser() {
        return idOfUser;
    }

    public void setIdOfUser(Integer idOfUser) {
        this.idOfUser = idOfUser;
    }

    public List<Integer> getListOfRecordsUser() {
        return listOfRecordsUser;
    }

    public void setListOfRecordsUser(List<Integer> listOfRecordsUser) {
        this.listOfRecordsUser = listOfRecordsUser;
    }

    public String getAccessToken() {
        return accessToken;
    }

    private void addTolist() {
        JSONObject obj = new JSONObject(wallOfUserJSON);
        JSONArray items = obj.getJSONObject("response").getJSONArray("items");
        for (int i = 0; i < items.length(); i++) {
            listOfRecordsUser.add(items.getJSONObject(i).getInt("id"));
        }

    }

    public void printId() {
        System.out.println(listOfRecordsUser);
        System.out.println(listOfRecordsUser.size());
    }

    public void getIdOfPosts(NetConnector netConnector, VC vc, Integer intervalBetweenGetPosts) {
        Timer timer = new Timer(this,intervalBetweenGetPosts);
        timer.start();
        int i = 0;
        while (!flag) {
            try {
                Thread.sleep(300);
                int offset = i * 20;
                String wallAddress = vc.getWall(offset);
                netConnector.sendRequest(wallAddress);
                addTolist();
                i++;

            } catch (Exception e) {
                e.printStackTrace();
                flag = true;
            }
        }
    }


}