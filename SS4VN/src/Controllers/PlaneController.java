package Controllers;

import Models.Bullet;
import Models.EnemyPlane;
import Models.GameOject;
import Models.Plane;
import Utils.Utils;
import views.GameDraw;
import views.ImageDraw;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by GGG8 on 8/1/2016.
 */
public class PlaneController extends SingleControllers implements KeyListener,Colliable {
    private static final int SPEED=10;
    private ControlerManager bulletManager;

    private PlaneController(Plane plane, GameDraw gameDraw) {
        super(plane, gameDraw);
        this.bulletManager= new ControlerManager();
        CollsionPool.instance.add(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                this.gameVector.x=-SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                this.gameVector.x=SPEED;
                break;
            case KeyEvent.VK_UP:
                this.gameVector.y=-SPEED;
                break;
            case KeyEvent.VK_DOWN:
                this.gameVector.y=SPEED;
                break;
            case KeyEvent.VK_SPACE:
                BulletController bulletController = new BulletController(
                        new Bullet(gameOject.getX(),gameOject.getY()),
                        new ImageDraw(Utils.loadImage("resources/bullet.png")));
                bulletManager.add(bulletController);
                break;


        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                this.gameVector.x=0;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                this.gameVector.y=0;
                break;
        }

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);

    }

    @Override
    public void run() {
        super.run();
        bulletManager.run();
    }

    private static PlaneController PlaneCotroller1;

    public static PlaneController getPlaneCotroller1() {
        if (PlaneCotroller1==null){
            PlaneCotroller1 = new PlaneController(new Plane(250,600),
             new ImageDraw(Utils.loadImage("resources/plane3.png")));
        }
        return PlaneCotroller1;
    }

    @Override
    public void onCollide(Colliable colliable) {
        super.onCollide(colliable);
    }
}
