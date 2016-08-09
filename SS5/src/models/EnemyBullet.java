package models;

/**
 * Created by GGG8 on 8/7/2016.
 */
public class EnemyBullet extends GameObject {

    public static final int SIZE = 32;

    public EnemyBullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public EnemyBullet(int x, int y) {
        super(x, y, SIZE, SIZE);
    }
}
