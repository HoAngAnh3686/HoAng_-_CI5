package Models;

import java.awt.*;

/**
 * Created by GGG8 on 7/31/2016.
 */
public class GameOject {
    protected int x;
    protected int y;
    protected int width;
    protected int hight;
    protected boolean isLife;

    public GameOject(int x, int y, int width, int hight) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.hight = hight;
        this.isLife= true;

    }
    public void moveTo( int x, int y){
        this.x= x;
        this.y= y;
    }
    public void move(GameVector gameVector){
        this.x += gameVector.x;
        this.y += gameVector.y;
    }

    public boolean isLife() {
        return isLife;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHight() {
        return hight;
    }
    public boolean overlap(GameOject gameOject) {
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameOject.getRect();
        return rect1.intersects(rect2);
    }


    private Rectangle getRect() {
        return new Rectangle(x, y, width, hight);
    }
    public boolean destroy(){
        return isLife=false;
    }
}
