package launcher;

import net.NetConnector;
import org.json.JSONArray;
import org.json.JSONObject;
import vc.LikeObjectType;
import vc.VC;
import vc.Wall;

import javax.swing.*;

/**
 * Created by USER on 24.05.2018.
 */
public class Launcher {
    //1b0c7fd30c2050dd553277cab5d6681846af8ade16835722cfe6f02baa6d718e211fd25a545ec2969502d - access token
    public static void main(String[] args) throws InterruptedException {


        new GUI();
     /*
        VC vc = new VC("1b0c7fd30c2050dd553277cab5d6681846af8ade16835722cfe6f02baa6d718e211fd25a545ec2969502d",mutex);
        Wall wall = new Wall("1b0c7fd30c2050dd553277cab5d6681846af8ade16835722cfe6f02baa6d718e211fd25a545ec2969502d", mutex);
        NetConnector netConnector = new NetConnector(mutex, wall);
        wall.getIdOfPosts(netConnector,vc);
        wall.printId();

        vc.likePosts(wall,161049230,netConnector);*/

        //vc.likePosts(wall,161049230, netConnector);

/*      String addLikeUrl = vc.addLike(LikeObjectType.POST, 161049230, 2683);
        netConnector.sendRequest(addLikeUrl);*/

       // wall.getIdOfPosts(netConnector,vc);
       // wall.printId();

       /* int offset = 9 * 20;
        String wallAddress = vc.getWall(146810783, offset);
        netConnector.sendRequest(wallAddress);
        wall.getIdOfPosts();
        wall.printId();*/


     /*   String wallAddress3 = vc.getWall(1,40);
        NetConnector.sendRequest(wallAddress3);
        wall.getIdOfPosts();

        String wallAddress4 = vc.getWall(1,60);
        NetConnector.sendRequest(wallAddress4);
        wall.getIdOfPosts();

        String wallAddress5 = vc.getWall(1,80);
        NetConnector.sendRequest(wallAddress5);
        wall.getIdOfPosts();

        String wallAddress6 = vc.getWall(1,100);
        NetConnector.sendRequest(wallAddress6);
        wall.getIdOfPosts();

        String wallAddress7 = vc.getWall(1,120);
        NetConnector.sendRequest(wallAddress7);
        wall.getIdOfPosts();


        String wallAddress8 = vc.getWall(161049230,140);
        NetConnector.sendRequest(wallAddress8);
        wall.getIdOfPosts();*/

       /* NetConnector netConnector = new NetConnector();
        VC vc = new VC("b55c64633d9891250f73f608b3c25d7817baf1fa0071b9ac1c62b535bfde1e0e9a1d528e73752d9bad30a");
        String wall = vc.getWall(1);
        netConnector.sendRequest(wall);
        String wallString = netConnector.getJsonObject();
        //System.out.println(wallString);
        JSONObject obj = new JSONObject(wallString);
        JSONArray items = obj.getJSONObject("response").getJSONArray("items");
        //System.out.println(items);
        JSONObject obj1 = items.getJSONObject(0);
        //System.out.println(obj1);
        JSONObject obj2 = items.getJSONObject(1);
        System.out.println(obj2);
*/
       /* String getUser = vc.getUser(1);
        netConnector.sendRequest(getUser);
        String people = netConnector.getJsonObject();
        System.out.println(people);
        JSONObject obj = new JSONObject(people);
        JSONArray arr = obj.getJSONArray("response");
        List qwerty = new ArrayList();

        for (int i = 0; i < arr.length(); i++) {
            qwerty.add(arr.get(i));
        }
        System.out.println(arr);
        System.out.println(arr.getJSONObject(0));
        JSONObject jsonObject = arr.getJSONObject(0);
        System.out.println(jsonObject);
        String str = jsonObject.toString();
        System.out.println(str);*/


        //String addLikeUrl = vc.addLike(LikeObjectType.POST, 1, 2442097);
        //netConnector.sendRequest(addLikeUrl);
       /* String getUser = vc.getUser(1);
        netConnector.sendRequest(getUser);
        String people = netConnector.getJsonObject();
        System.out.println(people);
        //  String str = "{ \"number\": [3, 4, 5, 6] }";
        JSONObject obj = new JSONObject(people);
        JSONArray arr = obj.getJSONArray("response");
        List qwerty = new ArrayList();

        for (int i = 0; i < arr.length(); i++) {
            qwerty.add(arr.get(i));
        }
        System.out.println(arr);
        System.out.println(arr.getJSONObject(0));
        JSONObject jsonObject = arr.getJSONObject(0);
        System.out.println(jsonObject);
        String str = jsonObject.toString();
        System.out.println(str);
        JSONObject obj3 = new JSONObject(str);
        String n = obj3.getString("first_name");
        int a = obj3.getInt("id");
        System.out.println(n);
        System.out.println(a);
       *//* JSONObject obj3 = new JSONObject(str);
        String n = obj3.getString("id");
        String a = obj.getString("last_name");*/

    }
}
