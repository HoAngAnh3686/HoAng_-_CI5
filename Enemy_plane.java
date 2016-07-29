package models;

/**
 * Created by GGG8 on 7/28/2016.
 */
public class Enemy_plane extends Thread {
    public int x;
    public int y;
    public void moveTo(int x, int y){
        this.x=x;
        this.y=y;
    }
}
