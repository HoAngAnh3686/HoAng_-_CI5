package Models;

/**
 * Created by GGG8 on 7/31/2016.
 */
public class Bullet extends GameOject {
    private static final int WIDTH=30;
    private static final int HIGHT=13;

    public Bullet(int x, int y, int width, int hight) {
        super(x, y, width, hight);
    }

    public Bullet(int x, int y) {
        super(x, y, WIDTH, HIGHT);
    }
}
