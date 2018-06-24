package vc;

import launcher.Mutex;
import net.NetConnector;

import java.util.List;

/**
 * Created by USER on 24.05.2018.
 */
public class VC {

    final String BASE_URL = "https://api.vk.com/method/";
    final String LIKES_ADD = "likes.add";
    final String LIKES_DELETE = "likes.delete";
    final String FRIENDS_GET = "friends.get";
    final String WALL_GET = "wall.get";
    final String FRIENDS_ADD = "friends.add";
    final String USER_GET = "users.get";

    public int owner_id;
    public int countLikes;
    public String access_token;
    public String version;

    public VC(String access_token, int owner_id) {
        this.access_token = access_token;
        this.version = "5.74";
        this.owner_id = owner_id;
    }

    public String addLike(LikeObjectType type, int item_id) {
        String address = BASE_URL + LIKES_ADD + getStandardParameters();
        address += "&type=" + type + "&owner_id=" + owner_id + "&item_id=" + item_id;
        return address;
    }



    public String getWall(int offset) {
            String address = BASE_URL + WALL_GET + getStandardParameters();
            address += "&owner_id=" + owner_id + "&offset=" + offset + "&filter=all";
            return address;
    }

    public String getUser(int user_ids) {
        String address = BASE_URL + USER_GET + getStandardParameters();
        address += "&user_ids=" + user_ids;
        return address;
    }

    private String getStandardParameters() {
        return "?access_token=" + access_token + "&v=" + version;
    }

    public void likePosts(Wall wall, NetConnector netConnector,Integer intervalBetweenLikes) {
        for (int i = 0; i < wall.listOfRecordsUser.size(); i++) {
            try {
                Thread.sleep(intervalBetweenLikes);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String addLikeUrl =  addLike(LikeObjectType.POST,wall.listOfRecordsUser.get(i));
            netConnector.sendRequest(addLikeUrl);
            countLikes++;
        }
    }
}
