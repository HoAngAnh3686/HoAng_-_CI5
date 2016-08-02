package Controllers;

import Models.EnemyBullet;
import Models.GameOject;
import views.GameDraw;

/**
 * Created by GGG8 on 8/3/2016.
 */
public class EnemyBulletController extends SingleControllers implements Colliable {
    private static final int SPEED=15;
    public EnemyBulletController(GameOject gameOject, GameDraw gameDraw) {
        super(gameOject, gameDraw);
        this.gameVector.y=SPEED;
        CollsionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameOject.getX() > 600) {
            gameOject.destroy();
        }

    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
        }
    }
}
