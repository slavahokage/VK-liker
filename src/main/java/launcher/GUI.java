package launcher;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import net.NetConnector;
import vc.VC;
import vc.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by USER on 26.05.2018.
 */
public class GUI extends JFrame {
    //https://oauth.vk.com/authorize?client_id=6487647&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=friends,wall&response_type=token&v=5.52
    JLabel accessTokenLabel;
    JTextField inputBarAccessTokenLabel;
    JLabel idLabel;
    JTextField inputBarIdLabel;
    JLabel intervalOflikesLabel;
    JTextField inputBarOfIntervalOflikes;
    JLabel timeForGetWall;
    JTextField inputBartimeForGetWall;
    JLabel countOfPosts;
    JLabel countOfLikePosts;
    JButton likeBtn;

    public GUI(){
        super("Like Maker VC");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        inputBarAccessTokenLabel = new JTextField(20);
        inputBarIdLabel = new JTextField(20);
        inputBarOfIntervalOflikes = new JTextField(20);
        inputBartimeForGetWall = new JTextField(20);

        JPanel contents = new JPanel();
        contents.setLayout(new GridBagLayout());

        accessTokenLabel= new JLabel("Введите ключ авторизации пользователя:");
        contents.add(accessTokenLabel, new GridBagConstraints(0,0,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        contents.add(inputBarAccessTokenLabel, new GridBagConstraints(1,0,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        idLabel = new JLabel("Введите id пользователя для лайка стены:");
        contents.add(idLabel, new GridBagConstraints(0,1,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        contents.add(inputBarIdLabel, new GridBagConstraints(1,1,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        intervalOflikesLabel = new JLabel("Интервал между лайками, миллисек:");
        contents.add(intervalOflikesLabel, new GridBagConstraints(0,2,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        contents.add(inputBarOfIntervalOflikes, new GridBagConstraints(1,2,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        timeForGetWall = new JLabel("Время получения постов со стены, миллисек:");
        contents.add(timeForGetWall, new GridBagConstraints(0,3,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        contents.add(inputBartimeForGetWall, new GridBagConstraints(1,3,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        countOfPosts = new JLabel("Полученные посты за данне время: ");
        contents.add(countOfPosts, new GridBagConstraints(0,4,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        countOfLikePosts = new JLabel("Лайкнутые посты:");
        contents.add(countOfLikePosts, new GridBagConstraints(0,5,1,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));
        likeBtn = new JButton("Лайкнуть стеночку");
        contents.add(likeBtn, new GridBagConstraints(0,6,2,1,1,1,
                GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,
                new Insets(2,2,2,2),0,0));

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 String accessToken = inputBarAccessTokenLabel.getText();
                Integer idOfUser = Integer.parseInt(inputBarIdLabel.getText());
                Integer intervalBetweenLikes = Integer.parseInt(inputBarOfIntervalOflikes.getText());
                Integer intervalBetweenGetPosts = Integer.parseInt(inputBartimeForGetWall.getText());
                VC vc = new VC(accessToken,idOfUser);
                Wall wall = new Wall(accessToken);
                NetConnector netConnector = new NetConnector(wall);
                wall.getIdOfPosts(netConnector,vc,intervalBetweenGetPosts);
                countOfPosts.setText("Полученные посты за данне время: "+wall.getListOfRecordsUser().size());

                wall.printId();
                try {
                    vc.likePosts(wall, netConnector, intervalBetweenLikes);
                }catch (Exception ex) {
                    ex.printStackTrace();
                    countOfLikePosts.setText("Колличество лайкнутых записей: " + vc.countLikes);
                }
               // String accessToken = inputBarAccessTokenLabel.getText();
                //NetConnector netConnector = new NetConnector();
                //netConnector.sendRequest(accessToken);
                countOfLikePosts.setText("Колличество лайкнутых записей: " + vc.countLikes);
            }
        };

        likeBtn.addActionListener(actionListener);
        //TransportClient transportClient = HttpTransportClient.getInstance();
        //VkApiClient vk = new VkApiClient(transportClient);

        setContentPane(contents);
        pack();
        setVisible(true);
    }
}
