package controllers;

import models.GameObject;
import views.GameDrawer;

/**
 * Created by GGG8 on 8/7/2016.
 */
class EnemyBulletController extends SingleController implements Colliable {

    public EnemyBulletController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            colliable.getGameObject().destroy();
        }
    }
}
