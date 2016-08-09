package controllers;

import models.GameObject;
import models.Grift;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by GGG8 on 8/9/2016.
 */
public class GriftController extends SingleController implements Colliable {
    private static final int SPEED=5;
    public GriftController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
        this.gameVector.dy=SPEED;
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            Iterator<SingleController> singleControllerIterator =
                    EnemyControllerManager.instance.getSingleControllerVector().iterator();
            while (singleControllerIterator.hasNext()){
                SingleController singleController = singleControllerIterator.next();
                singleController.getGameObject().destroy();
            }
            Iterator<SingleController> singleControllerIterator1 =
                    EnemyBulletControllerManager.instance.getSingleControllerVector().iterator();
            while (singleControllerIterator.hasNext()){
                SingleController singleController = singleControllerIterator1.next();
                singleController.getGameObject().destroy();
            }
        }
    }
}
