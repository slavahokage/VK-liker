package launcher;

import vc.Wall;

/**
 * Created by USER on 26.05.2018.
 */
public class Timer extends Thread {
    Wall wall;
    Integer intervalBetweenGetPosts;

    public Timer(Wall wall, Integer intervalBetweenGetPosts) {
        this.wall = wall;
        this.intervalBetweenGetPosts = intervalBetweenGetPosts;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(intervalBetweenGetPosts);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wall.setFlag(true);

    }
}
