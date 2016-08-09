package controllers;

import models.GameObject;
import views.GameDrawer;

import java.util.Iterator;

/**
 * Created by GGG8 on 8/9/2016.
 */
public class GriftControllers extends SingleController implements Colliable {
    private static final int SPEED=5;
    private static final int DQT=300;
    public GriftControllers(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
        this.gameVector.dy=SPEED;
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            int x=this.getGameObject().getX();
            int y=this.getGameObject().getY();
            this.getGameObject().destroy();
            Iterator<SingleController> singleControllerIterator =
                    EnemyControllerManager.instance.getSingleControllerVector().iterator();
            while (singleControllerIterator.hasNext()){
                SingleController singleController = singleControllerIterator.next();
                int dx = singleController.getGameObject().getX();
                int dy = singleController.getGameObject().getY();
                double values=Math.sqrt((dx-x)*(dx-x)+(dy-x)*(dy-y));
                if(values<DQT) singleController.getGameObject().destroy();

            }
        }
    }
}
