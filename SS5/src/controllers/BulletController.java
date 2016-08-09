package controllers;

import models.Bullet;
import models.GameObjectWithHP;
import views.GameDrawer;

/**
 * Created by GGG8 on 8/7/2016.
 */
public class BulletController extends SingleController implements Colliable {

    private static final int SPEED = 20;

    public BulletController(Bullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(gameObject.getY() < 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController1) {
            Bullet bullet = (Bullet)gameObject;
            ((GameObjectWithHP)colliable.getGameObject()).decreaseHP(bullet.getDamage());
            this.getGameObject().destroy();
        }
    }
}